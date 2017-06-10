package manage.boss.bean;

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

	
	private PcInfoDataDTO getPcInfo(String id, int pcNum){
		BossInfoDataDTO bdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getBossInfo", id);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("key",bdto.getB_key());
		map.put("pcNum", pcNum);
		PcInfoDataDTO pdto = (PcInfoDataDTO)sqlMap.queryForObject("pcInfo.getPcInfo", map);
		return pdto;
	}
	
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
	
	private void checkAddModi(String id, int num, String os, String ip, ComputerDataDTO cdto, MonitorDataDTO mdto, KeyboardDataDTO kdto,
			MouseDataDTO modto, SpeakerDataDTO sdto){
		PcInfoDataDTO pdto = getPcInfo(id, num);
		if(pdto != null){
			pdto.setOs(os);
			pdto.setIp(ip);
			addModifyPcInfo(pdto,cdto,mdto,kdto,modto,sdto,true,id);
		}else{
			PcInfoDataDTO dto = new PcInfoDataDTO();
			dto.setNum(num);
			dto.setOs(os);
			dto.setIp(ip);
			addModifyPcInfo(dto,cdto,mdto,kdto,modto,sdto,false,id);
		}
	}
	
	private void addModifyPcInfo(PcInfoDataDTO dto, ComputerDataDTO cdto, MonitorDataDTO mdto, KeyboardDataDTO kdto,
			MouseDataDTO modto, SpeakerDataDTO sdto, boolean modi, String id){
		try{
			if(modi){
				addPcNumBossKey(dto,cdto,mdto,kdto,modto,sdto);
				sqlMap.update("pcInfo.modifyPcInfo", dto);
				sqlMap.update("pcInfo.modifyConputerInfo", cdto);
				sqlMap.update("pcInfo.modifyMonitorInfo", mdto);
				sqlMap.update("pcInfo.modifyKeyboardInfo", kdto);
				sqlMap.update("pcInfo.modifyMouseInfo", modto);
				sqlMap.update("pcInfo.modifySpeakerInfo", sdto);
				setPcInfoLog(dto.getNum(), dto.getB_key(), "수정");
			}else{
				BossInfoDataDTO bdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getBossInfo", id);
				dto.setB_key(bdto.getB_key());
				addPcNumBossKey(dto,cdto,mdto,kdto,modto,sdto);
				sqlMap.insert("pcInfo.insertPcInfo", dto);
				sqlMap.insert("pcInfo.insertConputerInfo", cdto);
				sqlMap.insert("pcInfo.insertMonitorInfo", mdto);
				sqlMap.insert("pcInfo.insertKeyboardInfo", kdto);
				sqlMap.insert("pcInfo.insertMouseInfo", modto);
				sqlMap.insert("pcInfo.insertSpeakerInfo", sdto);
				setPcInfoLog(dto.getNum(), dto.getB_key(), "추가");
			}
		} catch (Exception e) {
			// 추후...수정
		}
	}

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
		String id = (String) session.getAttribute("loginId");
		BossInfoDataDTO bdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getBossInfo", id);		
		
		model.addAttribute("count",bdto.getB_pccount());
		
		return "/bossERP/seatMaterials/seatDispose";
	}
	
	/* pc방 좌석 추가 및 삭제 */
	@RequestMapping("seatAddDel.do")
	public String seatAdd(HttpSession session, HttpServletRequest request, Model model){
		String id = (String) session.getAttribute("loginId");
		BossInfoDataDTO bdto = null;
		int pcCount = 0;
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		if(request.getParameter("what").equals("add")){
			map.put("pcCount", "1");
			sqlMap.update("bossERP.addSeat", map);
			bdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getBossInfo", id);
			pcCount = Integer.parseInt(bdto.getB_pccount());
		}else{
			bdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getBossInfo", id);
			String[] buf = request.getParameter("pcNums").split(",");
			if(buf[buf.length-1].equals("")){
				map.put("pcCount", "1");
				sqlMap.update("bossERP.delSeat", map);
				PcInfoDataDTO pdto = new PcInfoDataDTO();
				pdto.setB_key(bdto.getB_key());
				int lastNum = (Integer)sqlMap.queryForObject("pcInfo.getLastPcNum", bdto.getB_key());
				pdto.setNum(lastNum);
				setPcInfoLog(lastNum, bdto.getB_key(), "삭제");
				sqlMap.delete("pcInfo.delPcInfo", pdto);
				pcCount = Integer.parseInt(bdto.getB_pccount())-1;
			}else{
				for(int i = 0; i<buf.length; i++){
					map.put("pcCount", "1");
					setPcInfoLog(Integer.parseInt(buf[i]), bdto.getB_key(), "삭제");
					sqlMap.update("bossERP.delSeat", map);
					PcInfoDataDTO pdto = getPcInfo(id, Integer.parseInt(buf[i]));
					sqlMap.delete("pcInfo.delPcInfo", pdto);
				}
				ArrayList<PcInfoDataDTO> pcAll = (ArrayList)sqlMap.queryForList("pcInfo.getPcInfoAll", bdto.getB_key());
				pcCount = pcAll.size();
				for(int i = 0; i < pcAll.size(); i++){
					if(i != pcAll.size()-1){
						int search = pcAll.get(i+1).getNum() - pcAll.get(i).getNum();
						if(search != 1){
							map.clear();
							map.put("after_num", pcAll.get(i).getNum()+1);
							map.put("before_num", pcAll.get(i+1).getNum());
							sqlMap.update("pcInfo.modifyPcNum", map);
							pcAll = (ArrayList)sqlMap.queryForList("pcInfo.getPcInfoAll", bdto.getB_key());
						}
					}
				}
			}
		}
		map.clear();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < pcCount; i++){
			sb.append("0");
			if(i!=pcCount-1){
				sb.append(",");
			}
		}
		map.put("seatCheck", sb.toString());
		map.put("key",bdto.getB_key());
		sqlMap.update("bossERP.modiSeatCount", map);
		model.addAttribute("count",pcCount);
		return "/bossERP/seatMaterials/seatUpdate";
	}
	
	/* pc방 좌석 이용 현황 */
	@RequestMapping("seatState.do")
	public String seatState(HttpSession session, String page, Model model){
		String id = (String) session.getAttribute("loginId");
		BossInfoDataDTO bdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getBossInfo", id);		
		SeatStateDataDTO sdto = (SeatStateDataDTO)sqlMap.queryForObject("bossERP.getSeatCount", bdto.getB_key());
		model.addAttribute("count",bdto.getB_pccount());
		if(sdto != null){
			String[] seatCon = sdto.getSeatCheck().split(",");
			ArrayList<HashMap<String,String>> param = (ArrayList)sqlMap.queryForList("useSeat.getUseUserId", bdto.getB_key());
			ArrayList<String> useSeatId = new ArrayList<String>();
			ArrayList<Integer> useSeatNum = new ArrayList<Integer>();
			for(int i=0; i<param.size(); i++){
				HashMap<String,Object> a = new HashMap();
				a.put("key",bdto.getB_key());
				a.put("ip",param.get(i).get("ip"));
				int num = (int)sqlMap.queryForObject("bossERP.getPcNum",a);
				useSeatNum.add(num);
				useSeatId.add(param.get(i).get("id").toString());
			}
			model.addAttribute("seatCon",seatCon);
			model.addAttribute("useSeatId",useSeatId);
			model.addAttribute("useSeatNum",useSeatNum);
		}
		if(page == null){
			return "/bossERP/seatMaterials/seatState";
		}else{
			return "/bossERP/seatMaterials/seatState2";
		}
	}

	/* pc방 좌석 정보 확인 */
	@RequestMapping("getSetPcInfo.do")
	public String getPcInfo(String pcNum, int page, HttpSession session, Model model){
		String id = (String)session.getAttribute("loginId");
		boolean all = false;
		if(page != 2){
			PcInfoDataDTO pdto = getPcInfo(id, Integer.parseInt(pcNum));
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
		}else{
			all = true;
		}
		model.addAttribute("pcNum", pcNum);
		if(page == 0){
			return "/bossERP/seatMaterials/getPcInfo";
		}else{
			model.addAttribute("all", all);
			return "/bossERP/seatMaterials/setPcInfo";
		}
	}
	
	/* pc방 좌석 정보 일괄 추가 및 수정 */
	@RequestMapping("addModiPcInfo.do")
	public String modiPcInfo(PcInfoDataDTO dto, String pcNum, ComputerDataDTO cdto, MonitorDataDTO mdto, KeyboardDataDTO kdto,
			MouseDataDTO modto, SpeakerDataDTO sdto, HttpSession session, HttpServletRequest request){
		try {
			cdto.setC_date(java.sql.Date.valueOf(request.getParameter("computer_date")));
			mdto.setM_date(java.sql.Date.valueOf(request.getParameter("monitor_date")));
			String id = (String)session.getAttribute("loginId");
			if(pcNum == null){
				checkAddModi(id, dto.getNum(), request.getParameter("os"), request.getParameter("ip"), cdto, mdto, kdto, modto, sdto);
			}else{
				String[] buf = pcNum.split(",");
				for(int i = 0; i < buf.length; i++){
					checkAddModi(id, Integer.parseInt(buf[i]), request.getParameter("os"), request.getParameter("ip"), cdto, mdto, kdto, modto, sdto);
				}
			}
		} catch (Exception e) {
			// 추후...수정
		}
		return "/bossERP/seatMaterials/modifyPcInfo";
	}
}
