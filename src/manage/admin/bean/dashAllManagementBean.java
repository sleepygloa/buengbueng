package manage.admin.bean;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import index.all.bean.FranchiseeModuleDataDTO;
import index.all.bean.ModuleDataDTO;
import manage.boss.bean.FranchiseeDataDTO;
import superclass.all.bean.Random;

@Controller
public class dashAllManagementBean {
	@Autowired
	SqlMapClientTemplate sqlMap;
	@Autowired
	public Random random;
	
	//가맹점 신청 승인
	@RequestMapping("dashfranchiseeConfirm.do")
	public String franchiseeConfirm(int num, String b_name){
		String b_key = random.random();
		
		HashMap map = new HashMap();
		map.put("num", num);
		map.put("b_key",b_key);
		map.put("b_name", b_name);
		
		try{
			sqlMap.update("franchisee.franchiseeConfirm", map);	
			
			FranchiseeDataDTO franchiseeDto = null;
			franchiseeDto = (FranchiseeDataDTO)sqlMap.queryForObject("franchisee.getFranchiseeLastConfirmLog", num);
			System.out.println(franchiseeDto.getB_key());
			sqlMap.insert("franchisee.insertFranchiseeInfo", franchiseeDto);
			
			// 혜민 코드 추가 시작
			HashMap param = new HashMap();
			int pcCount = Integer.parseInt(franchiseeDto.getB_pccount());
			param.put("b_key", franchiseeDto.getB_key());
			
			StringBuffer sb = new StringBuffer();
			for(int i=1; i<=pcCount; i++){
				sb.append("0");
				if(param.get("num") != null){
					param.remove("num");
				}
				if(i!=pcCount){
					sb.append(",");
				}
				param.put("num", i);
				sqlMap.insert("pcInfo.insertPcInfoDefault", param);
				sqlMap.insert("pcInfo.insertConputerInfoDefault", param);
				sqlMap.insert("pcInfo.insertMonitorInfoDefault", param);
				sqlMap.insert("pcInfo.insertKeyboardInfoDefault", param);
				sqlMap.insert("pcInfo.insertMouseInfoDefault", param);
				sqlMap.insert("pcInfo.insertSpeakerInfoDefault", param);
			}
			param.remove("num");
			param.put("check", sb.toString());
			sqlMap.insert("bossERP.addSeatState", param);
			ModuleDataDTO defaultModule = (ModuleDataDTO)sqlMap.queryForObject("module.getOfferMenu", null);
			FranchiseeModuleDataDTO module = new FranchiseeModuleDataDTO();
			module.setB_id(franchiseeDto.getB_id());
			module.setM_name("기본");
			module.setMenu(defaultModule.getModuleName());
			sb = new StringBuffer();
			for(int i=0; i<defaultModule.getModuleCount(); i++){
				sb.append("1");
				if(i != defaultModule.getModuleCount()-1){
					sb.append(",");
				}
			}
			module.setModule(sb.toString());
			sqlMap.insert("module.setModule", module);
			// 혜민 코드 추가 끝
			
			
		}catch (Exception e){
			e.printStackTrace();
		}
	        
			return  "redirect:/dashAgreeList.do?pageNum=1";	
	}
	
	//관리자 페이지 가맹점 & 신청 리스트
	@RequestMapping("dashAgreeList.do")
	public String dashAgreeList(String pageNum,String pageNum1,HttpServletRequest request,HashMap map){
		if (pageNum == null) {pageNum = "1";}
		if (pageNum1 == null) {pageNum1 = "1";}
		int count1 = 0; //글 갯수 초기화
		int count2 = 0; //글 갯수 초기화
        List articleList1 = null;
        List articleList2 = null; 
                     
        /////////////////////////////////////////////////////////////////////////////////
        //사장님이 보유한 가맹점 리스트
        /////////////////////////////////////////////////////////////////////////////////
        int pageSize = 5; //페이지당 5개씩 보여줌
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize; //시작 행번호  0  5 10  
        count1 = (Integer)sqlMap.queryForObject("admin.getFranchiseeListCount", null); //가맹점 정보의 갯수를 가져온다.
        if (count1 > 0) {
        	map.put("startRow", startRow);
        	map.put("pageSize",pageSize);
            articleList1 = sqlMap.queryForList("admin.getFranchiseeList", map); //가맹점 리스트를 뽑아온다.
        } else {
            articleList1 = Collections.EMPTY_LIST;
        }   
        int pageCount = count1 / pageSize + (count1%pageSize == 0? 0:1);
		int startPage = ((Integer.parseInt(pageNum)-1)/10)*10+1;
		int pageBlock = 10;
		int endPage = startPage + pageBlock - 1;
		if(endPage > pageCount){endPage = pageCount;}
        
        request.setAttribute("pageCount", pageCount);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("count1", count1);
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("articleList1", articleList1);
        /////////////////////////////////////////////////////////////////////////////////
        //가맹점 신청중인 리스트
        /////////////////////////////////////////////////////////////////////////////////
        int currentPage2 = Integer.parseInt(pageNum1);
        int startRow2 = (currentPage2 - 1) * pageSize;
        
        count2 = (Integer)sqlMap.queryForObject("admin.getFranchiseeAddListCount", null); //가맹점 정보의 갯수를 가져온다.
        if (count2 > 0) {
        	map.put("startRow", startRow2);
        	map.put("pageSize",pageSize);
            articleList2 = sqlMap.queryForList("admin.getFranchiseeAddList", map); //가맹점 리스트를 뽑아온다.
        } else {
            articleList2 = Collections.EMPTY_LIST;
        }     
        
		int pageCount2 = count2 / pageSize + (count2%pageSize == 0? 0:1);
		int startPage2 = ((Integer.parseInt(pageNum1)-1)/10)*10+1;
		int endPage2 = startPage2 + pageBlock - 1;
		if(endPage2 > pageCount2){endPage2 = pageCount2;}
		
        request.setAttribute("pageCount2", pageCount2);
        request.setAttribute("startPage2", startPage2);
        request.setAttribute("endPage2", endPage2);
        request.setAttribute("count2", count2);
        request.setAttribute("pageNum1", pageNum1);
        request.setAttribute("articleList2", articleList2);
        
        return  "/dash-Agree/dashAgreeList";	
	}
	//관리자 페이지 가맹점 정보
	@RequestMapping("dashAgreeInfo.do")
	public String dashAgreeInfo(String b_name, Model model){
		FranchiseeDataDTO dto = null;
		dto = (FranchiseeDataDTO)sqlMap.queryForObject("franchisee.getFranchiseeInfo", b_name);

		model.addAttribute("dto", dto);

			return  "/bosspcuse/franchiseeInfo";
		}
	// 관리자 페이지 가맹점 삭제
	@RequestMapping("dashAgreeDelete.do")
	public String dashAgreeDelete(String b_key,HashMap map){
		map.put("b_key", b_key);
		sqlMap.delete("franchisee.deleteFranchisee", map);
		return "/dash-Agree/dashAgreeDelete";
	}
}
