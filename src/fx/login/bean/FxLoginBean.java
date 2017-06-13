package fx.login.bean;

import java.net.InetAddress;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import login.user.bean.UseTimeDataDTO;
import login.user.bean.UseTimeLogDTO;
import login.user.bean.UserInfoDataDTO;

@Controller
public class FxLoginBean {
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
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
	public String fxLoginPro(UserInfoDataDTO dto, Model model){
		UserInfoDataDTO info = (UserInfoDataDTO)sqlMap.queryForObject("test.getUserInfo", dto.getId());
		if(info != null && info.getPw().equals(dto.getPw())){

			UseTimeLogDTO udto = new UseTimeLogDTO();
			udto.setId(info.getId());
			SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
			Calendar cal = Calendar.getInstance();
			String today = null;
			today = formatter.format(cal.getTime());
			Timestamp ts = Timestamp.valueOf(today);
			udto.setLoginTime(ts);
			try {
				InetAddress local = InetAddress.getLocalHost();
				String ip = local.getHostAddress();
				udto.setIp(ip);
			} catch (Exception e) {
				// 추후...수정
			}
			sqlMap.insert("useSeat.useTimeLogin", udto);
			
			model.addAttribute("result", info.getId());
			model.addAttribute("grade", info.getGrade());
			model.addAttribute("loginTime", udto.getLoginTime());
		}else{
			model.addAttribute("result", "fail");
		}
		return "/fxUserInfo/fxLoginPro";
	}
	
	@RequestMapping("fxLogoutPro.do")
	public String fxLogoutPro(String id, String loginTime, Model model){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("loginTime", loginTime);
		String result = "fail";
		try{
			sqlMap.update("useSeat.useTimeLogout", map);
			result = "succ";
		}catch(Exception e){
			// 추후...수정
		}finally{
			model.addAttribute("result", result);
		}
		return "/fxUserInfo/fxLogoutPro";
	}
}
