package pcRoom.search.bean;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import login.user.bean.BossInfoDataDTO;
import manage.boss.bean.SeatStateDataDTO;
import pc.materials.bean.ComputerDataDTO;
import pc.materials.bean.KeyboardDataDTO;
import pc.materials.bean.MonitorDataDTO;
import pc.materials.bean.MouseDataDTO;
import pc.materials.bean.PcInfoDataDTO;
import pc.materials.bean.SpeakerDataDTO;

@Controller
public class UserSearchPCBean {
	
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	//대메뉴에서 '사장님 가맹점 관리 버튼 클릭시' 이동
	@RequestMapping("searchPCForm.do")
	public String searchPC(Model model){
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 2; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		
		return "/pcRoom/searchPCForm";
	}
	
	@RequestMapping("searchPCNear.do")
	public String searchPCNear(HttpSession session, Model model){
		String id = (String)session.getAttribute("loginId");
		if(id == null){
			return "redirect: loginForm.do";
		}
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 2; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
	
		String address = (String)sqlMap.queryForObject("test.getUserAddr", id);
		String[] spl = address.split(" ");
		String addr = spl[2].substring(0, spl[2].length()-1);
		model.addAttribute("addr", addr);
		return "/pcRoom/searchPCNear";
	}
	
	@RequestMapping("searchPCRoom.do")
	public String searchPCRoom(String addr, Model model){
		ArrayList<BossInfoDataDTO> franchiseeInfo = (ArrayList<BossInfoDataDTO>)sqlMap.queryForList("searchPC.searchPCRoom", addr);
		model.addAttribute("franchiseeInfo",franchiseeInfo);
		return "/pcRoom/resultSearchPCRoom";
	}
	
	@RequestMapping("pcRoomUseState.do")
	public String pcRoomUseState(String b_name, String b_id, Model model){
		HashMap<String,String> param = new HashMap<String,String>();
		param.put("b_name", b_name);
		param.put("b_id", b_id);
		String b_key = (String)sqlMap.queryForObject("bossERP.getLicenseKey", param);
		SeatStateDataDTO sdto = (SeatStateDataDTO)sqlMap.queryForObject("bossERP.getSeatCount", b_key);
		int pcCount = (Integer)sqlMap.queryForObject("bossERP.getPcCount", b_key);
		model.addAttribute("count",pcCount);
		if(sdto != null){
			String[] seatCon = sdto.getSeatCheck().split(",");
			ArrayList<Integer> useSeatNum = new ArrayList<Integer>();
			model.addAttribute("seatCon",seatCon);
			model.addAttribute("useSeatNum",useSeatNum);
		}
		return "/pcRoom/pcRoomUseState";
	}
	
	@RequestMapping("showPcRoomInfo.do")
	public String pcRoomInfo(HttpSession session, String b_name, String b_id, Model model){
		HashMap<String,String> param = new HashMap<String,String>();
		param.put("b_name", b_name);
		param.put("b_id", b_id);
		String b_key = (String)sqlMap.queryForObject("bossERP.getLicenseKey", param);
		BossInfoDataDTO franchiseeInfo = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getFranchiseeOne", b_key);
		FavoritePCRoomDataDTO fpcDto = new FavoritePCRoomDataDTO();
		fpcDto.setB_key(b_key);
		fpcDto.setId((String)session.getAttribute("loginId"));
		String favoritePCRoom = (String)sqlMap.queryForObject("searchPC.searchFavoritePCRoom", fpcDto);
		model.addAttribute("franchiseeInfo", franchiseeInfo);
		model.addAttribute("favoritePCRoom", favoritePCRoom);
		return "/pcRoom/showPcRoomInfo";
	}
	
	@RequestMapping("showPcInfo.do")
	public String showPcInfo(String b_name, String b_id, int pcNum, Model model){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("b_name", b_name);
		map.put("b_id", b_id);
		String b_key = (String)sqlMap.queryForObject("bossERP.getLicenseKey", map);
		map.clear();
		map.put("key", b_key);
		map.put("pcNum", pcNum);
		PcInfoDataDTO pdto = (PcInfoDataDTO)sqlMap.queryForObject("pcInfo.getPcInfo", map);
		ComputerDataDTO cdto = (ComputerDataDTO)sqlMap.queryForObject("pcInfo.getComputerInfo",pdto);
		MonitorDataDTO mdto = (MonitorDataDTO)sqlMap.queryForObject("pcInfo.getMonitorInfo",pdto);
		KeyboardDataDTO kdto = (KeyboardDataDTO)sqlMap.queryForObject("pcInfo.getKeyboardInfo",pdto);
		MouseDataDTO modto = (MouseDataDTO)sqlMap.queryForObject("pcInfo.getMouseInfo",pdto);
		SpeakerDataDTO sdto = (SpeakerDataDTO)sqlMap.queryForObject("pcInfo.getSpeakerInfo",pdto);
		model.addAttribute("pcInfo", pdto);
		model.addAttribute("computer", cdto);
		model.addAttribute("monitor", mdto);
		model.addAttribute("keyboard", kdto);
		model.addAttribute("mouse", modto);
		model.addAttribute("speaker", sdto);
		return "/pcRoom/showPcInfo";
	}
	
	@RequestMapping("favoritePCRoom.do")
	public String favoritePCRoom(HttpSession session, Model model){
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 4; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		
		String id = (String)session.getAttribute("loginId");
		if(id == null){
			return "redirect: loginForm.do";
		}
		ArrayList<BossInfoDataDTO> favoritePCRoom = (ArrayList<BossInfoDataDTO>)sqlMap.queryForList("searchPC.getFavoritePCRoom", id);
		model.addAttribute("favoritePCRoom", favoritePCRoom);
		return "/pcRoom/favoritePCRoom";
	}
	
	@RequestMapping("addFavoritePCRoom.do")
	public String addFavoritePCRoom(HttpSession session, String b_name, String b_id, Model model){
		String id = (String)session.getAttribute("loginId");
		if(id == null){
			return "redirect: loginForm.do";
		}
		HashMap<String,String> param = new HashMap<String,String>();
		param.put("b_name", b_name);
		param.put("b_id", b_id);
		String b_key = (String)sqlMap.queryForObject("bossERP.getLicenseKey", param);
		
		FavoritePCRoomDataDTO fpcDto = new FavoritePCRoomDataDTO();
		fpcDto.setId(id);
		fpcDto.setB_name(b_name);
		fpcDto.setB_key(b_key);
		
		sqlMap.insert("searchPC.addFavoritePCRoom", fpcDto);
		
		model.addAttribute("b_name", b_name);
		model.addAttribute("b_id", b_id);
		return "redirect: showPcRoomInfo.do";
	}
	
	@RequestMapping("deleteFavoritePCRoom.do")
	public String deleteFavoritePCRoom(HttpSession session, String b_name, String b_id, Model model){
		String id = (String)session.getAttribute("loginId");
		if(id == null){
			return "redirect: loginForm.do";
		}
		HashMap<String,String> param = new HashMap<String,String>();
		param.put("b_name", b_name);
		param.put("b_id", b_id);
		String b_key = (String)sqlMap.queryForObject("bossERP.getLicenseKey", param);
		
		FavoritePCRoomDataDTO fpcDto = new FavoritePCRoomDataDTO();
		fpcDto.setId(id);
		fpcDto.setB_key(b_key);
		
		sqlMap.insert("searchPC.deleteFavoritePCRoom", fpcDto);
		
		model.addAttribute("b_name", b_name);
		model.addAttribute("b_id", b_id);
		return "redirect: showPcRoomInfo.do";
	}
}
