package manage.boss.bean;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import login.user.bean.BossInfoDataDTO;
import menu.all.bean.OrderDTO;
import pc.materials.bean.ComputerDataDTO;
import pc.materials.bean.KeyboardDataDTO;
import pc.materials.bean.MonitorDataDTO;
import pc.materials.bean.MouseDataDTO;
import pc.materials.bean.PcInfoDataDTO;
import pc.materials.bean.PcInfoModifyLogDataDTO;
import pc.materials.bean.SpeakerDataDTO;

@Controller
public class SeatMaterialsBean {
	@Autowired
	private SqlMapClientTemplate sqlMap;

	/* pc 좌석 정보 받기 */
	private PcInfoDataDTO getPcInfo(String b_key, int pcNum){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("key", b_key);
		map.put("pcNum", pcNum);
		PcInfoDataDTO pdto = (PcInfoDataDTO)sqlMap.queryForObject("pcInfo.getPcInfo", map);
		return pdto;
	}
	
	/* pc 정보에 라이센스키와 좌석 번호 넣기 */
	private void addPcNumBossKey(PcInfoDataDTO pdto,ComputerDataDTO cdto, MonitorDataDTO mdto, KeyboardDataDTO kdto,
			MouseDataDTO modto, SpeakerDataDTO sdto){
		cdto.setC_bossKey(pdto.getB_key());
		mdto.setM_bossKey(pdto.getB_key());
		kdto.setK_bossKey(pdto.getB_key());
		modto.setMo_bossKey(pdto.getB_key());
		sdto.setS_bossKey(pdto.getB_key());
		
		cdto.setC_num(pdto.getNum());
		mdto.setM_num(pdto.getNum());
		kdto.setK_num(pdto.getNum());
		modto.setMo_num(pdto.getNum());
		sdto.setS_num(pdto.getNum());
		return;
	}
	
	/* 좌석 추가인지 좌석 수정인지 체크 */
	private void checkAddModi(String b_key, int num, String os, String ip, String state, ComputerDataDTO cdto, MonitorDataDTO mdto, KeyboardDataDTO kdto,
			MouseDataDTO modto, SpeakerDataDTO sdto){
		PcInfoDataDTO pdto = getPcInfo(b_key, num);
		/* 좌석 수정 */
		if(pdto != null){
			pdto.setOs(os);
			pdto.setIp(ip);
			pdto.setState(state);
			addModifyPcInfo(pdto,cdto,mdto,kdto,modto,sdto,true,b_key);
		}else{
			PcInfoDataDTO dto = new PcInfoDataDTO();
			dto.setB_key(b_key);
			dto.setNum(num);
			dto.setOs(os);
			dto.setIp(ip);
			addModifyPcInfo(dto,cdto,mdto,kdto,modto,sdto,false,b_key);
		}
	}
	
	/* 좌석 정보 추가 또는 수정하기*/
	private void addModifyPcInfo(PcInfoDataDTO dto, ComputerDataDTO cdto, MonitorDataDTO mdto, KeyboardDataDTO kdto,
			MouseDataDTO modto, SpeakerDataDTO sdto, boolean modi, String b_key){
		try{
			/* 수정이면 */
			if(modi){
				addPcNumBossKey(dto,cdto,mdto,kdto,modto,sdto);
				sqlMap.update("pcInfo.modifyPcInfo", dto);
				sqlMap.update("pcInfo.modifyConputerInfo", cdto);
				sqlMap.update("pcInfo.modifyMonitorInfo", mdto);
				sqlMap.update("pcInfo.modifyKeyboardInfo", kdto);
				sqlMap.update("pcInfo.modifyMouseInfo", modto);
				sqlMap.update("pcInfo.modifySpeakerInfo", sdto);
				setPcInfoLog(dto.getNum(), b_key, "수정");
			}
			/* 추가이면 */
			else{
				addPcNumBossKey(dto,cdto,mdto,kdto,modto,sdto);
				sqlMap.insert("pcInfo.insertPcInfo", dto);
				sqlMap.insert("pcInfo.insertConputerInfo", cdto);
				sqlMap.insert("pcInfo.insertMonitorInfo", mdto);
				sqlMap.insert("pcInfo.insertKeyboardInfo", kdto);
				sqlMap.insert("pcInfo.insertMouseInfo", modto);
				sqlMap.insert("pcInfo.insertSpeakerInfo", sdto);
				setPcInfoLog(dto.getNum(), b_key, "추가");
			}
		} catch (Exception e) {
			// 추후 수정
		}
	}

	/* pc방 좌석 정보 추가/수정/삭제 로그 남기기 */
	private void setPcInfoLog(int num, String b_key, String what){
		PcInfoModifyLogDataDTO plog = new PcInfoModifyLogDataDTO();
		plog.setNum(num);
		plog.setB_key(b_key);
		plog.setWhat(what);
		
		HashMap map = (HashMap) sqlMap.queryForObject("pcInfo.getAllPcInfo",plog);
		plog.setC_code((Integer)map.get("c_code"));
		plog.setM_code((Integer)map.get("m_code"));
		plog.setMo_code((Integer)map.get("mo_code"));
		plog.setS_code((Integer)map.get("s_code"));
		plog.setK_code((Integer)map.get("k_code"));
		plog.setIp((String)map.get("ip"));
		plog.setOs((String)map.get("os"));
		sqlMap.insert("pcInfo.setPcInfoLog", plog);
	}
	
	/* pc방 좌석 관리 */
	@RequestMapping("seatDispose.do")
	public String seatDispose(HttpSession session, Model model){
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		
		String b_key = (String)session.getAttribute("b_key");
		BossInfoDataDTO bdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getFranchiseeOne",b_key);		
		model.addAttribute("count",bdto.getB_pccount());
		model.addAttribute("b_key",bdto.getB_key());
		return "/bossERP/seatMaterials/seatDispose";
	}
	
	/* pc방 좌석 추가 및 삭제 */
	@RequestMapping("seatAddDel.do")
	public String seatAdd(HttpSession session, HttpServletRequest request, Model model){
		String b_key = (String)session.getAttribute("b_key");
		BossInfoDataDTO bdto = null;
		int pcCount = 1;
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("b_key", b_key);
		/* 좌석 추가 */
		if(request.getParameter("what").equals("add")){
			for(int i=0; i<Integer.parseInt(request.getParameter("pcNums")); i++){
				map.put("pcCount", "1");
				sqlMap.update("bossERP.addSeat", map);
				bdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getFranchiseeOne", b_key);
				pcCount = Integer.parseInt(bdto.getB_pccount());
				map.remove("pcCount");
				map.put("num",pcCount);
				sqlMap.insert("pcInfo.insertPcInfoDefault", map);
				sqlMap.insert("pcInfo.insertConputerInfoDefault", map);
				sqlMap.insert("pcInfo.insertMonitorInfoDefault", map);
				sqlMap.insert("pcInfo.insertKeyboardInfoDefault", map);
				sqlMap.insert("pcInfo.insertMouseInfoDefault", map);
				sqlMap.insert("pcInfo.insertSpeakerInfoDefault", map);
				map.remove("num");
			}
		}
		/* 좌석 삭제 */
		else{
			bdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getFranchiseeOne", b_key);
			String[] buf = request.getParameter("pcNums").split(",");
			ArrayList<PcInfoDataDTO> pcAll = (ArrayList)sqlMap.queryForList("pcInfo.getPcInfoAll", b_key);
			if(pcAll.size() > 1){
				/* 단일 삭제 */
				if(buf[buf.length-1].equals("")){
					map.put("pcCount", "1");
					sqlMap.update("bossERP.delSeat", map);
					PcInfoDataDTO pdto = new PcInfoDataDTO();
					pdto.setB_key(b_key);
					int lastNum = (Integer)sqlMap.queryForObject("pcInfo.getLastPcNum", b_key);
					pdto.setNum(lastNum);
					setPcInfoLog(lastNum, bdto.getB_key(), "삭제");
					sqlMap.delete("pcInfo.delPcInfo", pdto);
					pcCount = Integer.parseInt(bdto.getB_pccount())-1;
				}
				/* 다중 삭제 */
				else{
					for(int i = 0; i<buf.length; i++){
						map.put("pcCount", "1");
						setPcInfoLog(Integer.parseInt(buf[i]), b_key, "삭제");
						sqlMap.update("bossERP.delSeat", map);
						PcInfoDataDTO pdto = getPcInfo(b_key, Integer.parseInt(buf[i]));
						sqlMap.delete("pcInfo.delPcInfo", pdto);
					}
					pcAll = (ArrayList)sqlMap.queryForList("pcInfo.getPcInfoAll", b_key);
					if(pcAll.get(0).getNum() != 1){
						map.clear();
						map.put("after_num", "1");
						map.put("before_num", pcAll.get(0).getNum());
						map.put("b_key", b_key);
						sqlMap.update("pcInfo.modifyPcNum", map);
						pcAll = (ArrayList)sqlMap.queryForList("pcInfo.getPcInfoAll", b_key);
					}
					for(int i = 0; i < pcAll.size(); i++){
						if(i != pcAll.size()-1){
							int search = pcAll.get(i+1).getNum() - pcAll.get(i).getNum();
							if(search != 1){
								map.clear();
								map.put("after_num", pcAll.get(i).getNum()+1);
								map.put("before_num", pcAll.get(i+1).getNum());
								map.put("b_key", b_key);
								sqlMap.update("pcInfo.modifyPcNum", map);
								pcAll = (ArrayList)sqlMap.queryForList("pcInfo.getPcInfoAll", b_key);
							}
						}
					}
					pcCount = pcAll.size();
				}
			}
		}
		map.clear();
		/* 이용 현황 테이블에 추가,삭제된 좌석 개수만큼 다시 현황 넣기 */
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < pcCount; i++){
			sb.append("0");
			if(i!=pcCount-1){
				sb.append(",");
			}
		}
		map.put("seatCheck", sb.toString());
		map.put("key",b_key);
		sqlMap.update("bossERP.modiSeatCount", map);
		model.addAttribute("count",pcCount);
		return "/bossERP/seatMaterials/seatUpdate";
	}
	
	/* pc방 좌석 이용 현황 */
	@RequestMapping("seatState.do")
	public String seatState(HttpSession session, String tf, Model model){
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		
		String b_key = (String)session.getAttribute("b_key");
		SeatStateDataDTO sdto = (SeatStateDataDTO)sqlMap.queryForObject("bossERP.getSeatCount", b_key);
		int pcCount = (Integer)sqlMap.queryForObject("bossERP.getPcCount", b_key);
		ArrayList<String> pcState = (ArrayList<String>)sqlMap.queryForList("pcInfo.getState", b_key);
		model.addAttribute("pcState",pcState);
		model.addAttribute("count",pcCount);
		if(sdto != null){
			String[] seatCon = sdto.getSeatCheck().split(",");
			ArrayList<HashMap<String,String>> param = (ArrayList<HashMap<String,String>>)sqlMap.queryForList("useSeat.getUseUserId", b_key);
			ArrayList<String> useSeatId = new ArrayList<String>();
			ArrayList<Integer> useSeatNum = new ArrayList<Integer>();
			// 해당 가맹점을 사용하고 있는 유저가 있으면
			if(param != null){
				for(int i=0; i<param.size(); i++){
					HashMap<String,Object> a = new HashMap();
					a.put("key",b_key);
					a.put("ip",param.get(i).get("ip"));
					// 사용자의 좌석번호 알아내기
					int num = (int)sqlMap.queryForObject("bossERP.getPcNum",a);
					useSeatNum.add(num);
					a.remove("ip");
					a.put("id", param.get(i).get("id").toString());
					useSeatId.add(param.get(i).get("id").toString());
				}
				model.addAttribute("useSeatId",useSeatId);
			}
			model.addAttribute("seatCon",seatCon);
			model.addAttribute("useSeatNum",useSeatNum);
		}
		if(tf == null){
			return "/bossERP/seatMaterials/seatState";
		}else{
			return "/bossERP/seatMaterials/seatState2";
		}
	}
	
	/* 좌석 사용 중인 사용자의 정보 가져오기 */
	@RequestMapping("getUseUserInfo.do")
	public String getUseUserInfo(HttpSession session, String pcNum, String id, Model model){
		String b_key = (String)session.getAttribute("b_key");
		String startTime = (String)sqlMap.queryForObject("useSeat.getUserStartTime", id);
		
		model.addAttribute("pcNum", pcNum);
		model.addAttribute("id", id);
		model.addAttribute("startTime", startTime);
		
		ArrayList<RentLogDataDTO> rentOrderList = (ArrayList<RentLogDataDTO>)sqlMap.queryForList("rent.getOneUserRentList", id);
				
		HashMap<String,Object> param = new HashMap<String,Object>();
		param.put("id", id);
		param.put("l_key", b_key);
		param.put("loginTime", startTime);
		ArrayList<OrderDTO> menuOrderList = (ArrayList<OrderDTO>)sqlMap.queryForList("order.getOneUserMenuOrder", param);
		
		model.addAttribute("rentOrderList", rentOrderList);
		model.addAttribute("menuOrderList", menuOrderList);
		
		return "/bossERP/seatMaterials/getUseUserInfo";
	}

	/* pc방 좌석 정보 확인 */
	@RequestMapping("getSetPcInfo.do")
	public String getPcInfo(String pcNum, int page, HttpSession session, Model model){
		String b_key = (String)session.getAttribute("b_key");
		boolean all = false;
		/* 단일 좌석 정보 */
		if(page != 2){
			PcInfoDataDTO pdto = getPcInfo(b_key, Integer.parseInt(pcNum));
			if(pdto != null){
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
			}
		}
		/* 체크한 좌석 일괄 수정 */
		else{
			all = true;
		}
		model.addAttribute("pcNum", pcNum);
		// 선택한 좌석 정보 보기(0)로 이동
		if(page == 0){
			return "/bossERP/seatMaterials/getPcInfo";
		}
		// 선택한 좌석(1) 또는 일괄 좌석(2) 수정으로 이동
		else{
			model.addAttribute("all", all);
			return "/bossERP/seatMaterials/setPcInfo";
		}
	}
	
	/* pc방 좌석 정보 및 수정 */
	@RequestMapping("addModiPcInfo.do")
	public String modiPcInfo(HttpSession session, PcInfoDataDTO dto, String pcNum, ComputerDataDTO cdto, MonitorDataDTO mdto, KeyboardDataDTO kdto,
			MouseDataDTO modto, SpeakerDataDTO sdto, HttpServletRequest request, Model model){
		try {
			String b_key = (String)session.getAttribute("b_key");
			dto.setB_key(b_key);
			cdto.setC_date(java.sql.Date.valueOf(request.getParameter("computer_date")));
			mdto.setM_date(java.sql.Date.valueOf(request.getParameter("monitor_date")));
			String[] buf = pcNum.split(",");
			for(int i = 0; i < buf.length; i++){
				checkAddModi(dto.getB_key(), Integer.parseInt(buf[i]), request.getParameter("os"), request.getParameter("ip"), request.getParameter("state"), cdto, mdto, kdto, modto, sdto);
			}
		} catch (Exception e) {
			// 추후 수정
		}
		return "/bossERP/seatMaterials/modifyPcInfo";
	}
	
	/* 관리자 - pc방 좌석 기본 정보 관리 페이지 */
	@RequestMapping("managePcInfo.do")
	public String managePcInfo(){
		return "/bossERP/seatMaterials/setPcInfoDefault";
	}
	
	/* 관리자 - pc방 좌석 기본 정보 관리 수정 */
	@RequestMapping("managePcInfoPro.do")
	public String managePcInfoPro(String os, ComputerDataDTO cdto, MonitorDataDTO mdto, KeyboardDataDTO kdto,
			MouseDataDTO modto, SpeakerDataDTO sdto){
		sqlMap.update("pcInfo.modifyPcInfoDefault", os);
		sqlMap.update("pcInfo.modifyConputerInfoDefault", cdto);
		sqlMap.update("pcInfo.modifyMonitorInfoDefault", mdto);
		sqlMap.update("pcInfo.modifyKeyboardInfoDefault", kdto);
		sqlMap.update("pcInfo.modifyMouseInfoDefault", modto);
		sqlMap.update("pcInfo.modifySpeakerInfoDefault", sdto);
		return "redirect: managePcInfo.do";
	}
}
