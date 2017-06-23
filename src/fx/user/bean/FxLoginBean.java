package fx.user.bean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import login.user.bean.BossInfoDataDTO;
import login.user.bean.UseTimeLogDTO;
import login.user.bean.UserInfoDataDTO;
import manage.boss.bean.SeatStateDataDTO;
import payment.all.bean.UsageHistoryDataDTO;

@Controller
public class FxLoginBean {
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	private void modifySeatState(String key, int pcNum, String value){
		SeatStateDataDTO sdto = (SeatStateDataDTO)sqlMap.queryForObject("bossERP.getSeatCount", key);
		String[] check = sdto.getSeatCheck().split(",");
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < check.length; i++){
			if(i == pcNum-1){
				sb.append(value);
			}else{
				sb.append(check[i]);
			}if(i != check.length-1){
				sb.append(",");
			}
		}
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("key", key);
		map.put("seatCheck", sb.toString());
		sqlMap.update("bossERP.modiSeatCount", map);
	}
	
	@RequestMapping("fxSearchId.do")
	public String fxSearchId(UserInfoDataDTO dto, Model model){
		try{
			String id = (String) sqlMap.queryForObject("checkInfo.SearchId", dto);
			if(id != null){
				model.addAttribute("result", id);
			}else{
				model.addAttribute("result", "fail");
			}
		}catch(Exception e){
			// 추후...수정
		}
		return "/fxUserInfo/fxSearchId";
	}
	
	@RequestMapping("fxSearchPw.do")
	public String fxSearchPw(UserInfoDataDTO dto, Model model){
		try{
			System.out.println(dto.getPhone());
			String pw = (String) sqlMap.queryForObject("checkInfo.SearchPw", dto);
			if(pw != null){
				model.addAttribute("result", pw);
			}else{
				model.addAttribute("result", "fail");
			}
		}catch(Exception e){
			// 추후...수정
		}
		return "/fxUserInfo/fxSearchPw";
	}
	
	@RequestMapping("fxLoginPro.do")
	public String fxLoginPro(UserInfoDataDTO dto, String ip, String key, Model model){
		UserInfoDataDTO info = (UserInfoDataDTO)sqlMap.queryForObject("test.getUserInfo", dto.getId());
		if(info != null && info.getPw().equals(dto.getPw())){
			UseTimeLogDTO udto = new UseTimeLogDTO();
			udto.setId(info.getId());
			udto.setGrade(info.getGrade());
			SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			String today = null;
			today = formatter.format(cal.getTime());
			Timestamp ts = Timestamp.valueOf(today);
			udto.setLoginTime(ts);
			udto.setIp(ip);
			udto.setLicenseKey(key);
			sqlMap.insert("useSeat.useTimeLogin", udto);
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("ip", ip);
			map.put("key", key);
			int pcNum = 0;
			if(info.getGrade() == 3){
				pcNum = (Integer)sqlMap.queryForObject("bossERP.getPcNum", map);
				modifySeatState(key, pcNum, "1");
			}
			
			model.addAttribute("result", info.getId());
			model.addAttribute("grade", info.getGrade());
			model.addAttribute("loginTime", udto.getLoginTime());
			model.addAttribute("pcNum", pcNum);
		}else{
			model.addAttribute("result", "fail");
		}
		return "/fxUserInfo/fxLoginPro";
	}
	
	@RequestMapping("fxLogoutPro.do")
	public String fxLogoutPro(String id, String loginTime, String key, String pcNum, Model model){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("loginTime", loginTime);
		map.put("licenseKey", key);
		String result = "fail";
		try{
			sqlMap.update("useSeat.useTimeLogout", map);	
			modifySeatState(key, Integer.parseInt(pcNum), "0");
			UserInfoDataDTO udto = (UserInfoDataDTO)sqlMap.queryForObject("test.getUserInfo", id);
			if(udto.getGrade() != 1){
				UseTimeLogDTO utdto = (UseTimeLogDTO)sqlMap.queryForObject("useSeat.getUseUserInfo", map);
				BossInfoDataDTO fdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getFranchiseeOne", key);
				UsageHistoryDataDTO uhdto = new UsageHistoryDataDTO();
				uhdto.setUserId(id);
				uhdto.setUserName(udto.getName());
				uhdto.setAffiliateCode(key);
				uhdto.setUsageTime(utdto.getLoginTime());
				uhdto.setEndTime(utdto.getLogoutTime());
				uhdto.setBusinessName(fdto.getB_name());
				uhdto.setBossId(fdto.getB_id());
				uhdto.setEtc("etc");
				uhdto.setAmountUsed(1000);
				sqlMap.insert("cash.addUsageHistory", uhdto);
			}
			result = "succ";
			model.addAttribute("result", result);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/fxUserInfo/fxLogoutPro";
	}
}
