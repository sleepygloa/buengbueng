package fx.user.bean;

import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DecimalFormat;
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
import payment.all.bean.UserAccountDTO;
import superclass.all.bean.FindIpBean;

@Controller
public class FxLoginBean {
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@Autowired
	private FindIpBean fib;
	
	private void modifySeatState(String key, int pcNum, String value){
		SeatStateDataDTO sdto = (SeatStateDataDTO)sqlMap.queryForObject("bossERP.getSeatCount", key); //좌석이용현황
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
	
	@RequestMapping("fxCheckLicenseKey.do")
	public String fxCheckLicenseKey(String b_key, Model model){
		String result = "fail";
		try{
			int chk = (Integer)sqlMap.queryForObject("bossERP.checkLicenseKey", b_key);
			if(chk != 0){
				result = "succ";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("result", result);
		return "/fxUserInfo/fxLogoutPro";
	}
	
	@RequestMapping("fxUserStart.do")
	public String fxStart(String key, Model model){
		try{
			String franchiseeName = (String)sqlMap.queryForObject("bossERP.getFranchiseeName", key);
			model.addAttribute("franchiseeName", URLEncoder.encode(franchiseeName,"UTF-8"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "/fxUserInfo/fxUserStart";
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
		String result = "";
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
			int money = 0;
			double moneyPolicy = 0;
			String bossIP  = null;
			int historyNum = 0;
			result = info.getId();
			if(info.getGrade() == 3){ //자리정보 계좌정보 + 사용 가능 유무
				UserAccountDTO uadto = (UserAccountDTO)sqlMap.queryForObject("cash.getUserAccount", info.getId()); //아이디의 계좌를 불러옴.
				money = uadto.getMoney();
				moneyPolicy = (double)sqlMap.queryForObject("bossERP.getMoneyPolicy", key);
				if(money*2 < moneyPolicy){
					result = "fail,충전 후 사용해 주십시오.";
				}
				pcNum = (Integer)sqlMap.queryForObject("bossERP.getPcNum", map);//좌석 갯수 불러오기
				modifySeatState(key, pcNum, "1"); //좌석 이용현황 초기화
				BossInfoDataDTO bdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getFranchiseeOne", key); //가맹점 IP 불러오기
				
				bossIP = bdto.getB_ip();
				
				UsageHistoryDataDTO uhdto = new UsageHistoryDataDTO();
				uhdto.setUserId(info.getId());
				uhdto.setUserName(info.getName());
				uhdto.setAffiliateCode(key);
				uhdto.setUsageTime(udto.getLoginTime());
				uhdto.setBusinessName(bdto.getB_name());
				uhdto.setBossId(bdto.getB_id());
				uhdto.setAmountUsed(0);
				uhdto.setPcAmount(0);
				uhdto.setMenuAmount(0);
				sqlMap.insert("cash.addUsageHistory", uhdto);
				historyNum = (Integer)sqlMap.queryForObject("cash.getUserHistoryNum", info.getId());
			}
			model.addAttribute("money", money);
			model.addAttribute("grade", info.getGrade());
			model.addAttribute("loginTime", udto.getLoginTime());
			model.addAttribute("pcNum", pcNum);
			model.addAttribute("bossIP", bossIP);
			model.addAttribute("moneyPolicy", moneyPolicy);
			model.addAttribute("historyNum", historyNum);
		}else{
			result = "fail,로그인 실패";
		}
		try{
			model.addAttribute("result", URLEncoder.encode(result,"UTF-8"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "/fxUserInfo/fxLoginPro";
	}
	
	@RequestMapping("fxLogoutPro.do")
	public String fxLogoutPro(String id, String loginTime, String key, String pcNum, Double useAmount, int idx, Model model){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("loginTime", loginTime);
		map.put("licenseKey", key);
		String result = "fail";
		try{
			sqlMap.update("useSeat.useTimeLogout", map);
			if(!pcNum.equals("0")){
				modifySeatState(key, Integer.parseInt(pcNum), "0");
			}
			UserInfoDataDTO udto = (UserInfoDataDTO)sqlMap.queryForObject("test.getUserInfo", id);
			if(udto.getGrade() == 3){
				UseTimeLogDTO utdto = (UseTimeLogDTO)sqlMap.queryForObject("useSeat.getUseUserInfo", map);
				BossInfoDataDTO fdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getFranchiseeOne", key);
				String menuAmount = (String)sqlMap.queryForObject("order.getUserMenuOrderSum", map);
				if(menuAmount == null){
					menuAmount = "0";
				}
				String amount = (String)sqlMap.queryForObject("cash.getpcAmount", idx);
				UsageHistoryDataDTO uhdto = new UsageHistoryDataDTO();
				uhdto.setEndTime(utdto.getLogoutTime());
				uhdto.setMenuAmount(Integer.parseInt(menuAmount));
				uhdto.setPcAmount(useAmount);
				String beforePcAmount = (String)sqlMap.queryForObject("cash.getpcAmount", idx);
				DecimalFormat df = new DecimalFormat("0.###");
				double all =  Double.parseDouble(amount) + uhdto.getPcAmount() + Double.parseDouble(menuAmount);
				
				uhdto.setAmountUsed(Double.parseDouble(df.format(all)));
				uhdto.setIdx(idx);
				
				sqlMap.update("cash.addUserEtc", uhdto);
				
				map.clear();
				map.put("id", id);
				map.put("cash", useAmount-Double.parseDouble(menuAmount));
				sqlMap.update("cash.deductMoney", map);
			}
			result = "succ";
			model.addAttribute("result", result);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/fxUserInfo/fxLogoutPro";
	}
	
	@RequestMapping("fxGetUserPoint.do")
	public String fxGetUserPoint(String id, double point, double startPoint, int historyNum, Model model){
		double usePoint = startPoint - point;
		DecimalFormat df = new DecimalFormat("0.###");
		
		String pcAmount = df.format(usePoint);
		
		HashMap param = new HashMap();
		param.put("idx", historyNum);
		param.put("cash", pcAmount);
		
		sqlMap.update("cash.addUserPcAmount", param);
		
		param.remove("idx");
		param.put("id", id);
		sqlMap.update("cash.deductMoney", param);
		UserAccountDTO uadto = (UserAccountDTO)sqlMap.queryForObject("cash.getUserAccount", id);
		double money = uadto.getMoney();
		model.addAttribute("point", money);
		return "/fxUserInfo/fxGetUserPoint";
	}
}
