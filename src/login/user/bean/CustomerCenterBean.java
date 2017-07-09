package login.user.bean;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerCenterBean extends CustomerMethodBean{ // 가맹 문의 , 1:1 문의 , 자주 묻는 질문 ,관리자 권한 삭제

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	// 가맹 문의 게시판	
	
	@RequestMapping("franchiseQA.do")  // 게시판 리스트
	public String franchiseQA(HttpServletRequest request,HashMap map,Model model){
		boardList(request, map,model);
		return "/customer-center/franchiseList";
	}
	
	@RequestMapping("franchiseForm.do")
	public String franchiseForm(HttpServletRequest request,HttpSession session){   // 문의 작성 폼 
		writeForm(request, session);
		return "/customer-center/franchiseForm";
	}
	
	@RequestMapping("franchisePro.do")  // 문의 작성 DB insert 
	public String franchisePro(CustomerDTO dto,HashMap map,HttpServletRequest request) throws Exception{
		writePro(request, dto, map);
		return "/customer-center/franchisePro";
	}
	
	@RequestMapping("franchiseWriteCheck.do")  //  게시글 호출시 패스워드 검사 창
	public String franchiseWriteCheck(HttpServletRequest request,HttpSession session,HashMap map) {
		writeCheck(request);
		return "/customer-center/franchiseWriteCheck";
	}

	@RequestMapping("franchiseContent.do")  // 게시글 내용 호출
	public String franchiseContent(HttpServletRequest request,HashMap map,CustomerDTO dto,HttpSession session,UserInfoDataDTO user){
		writeContent(request, map, session,dto);
		return "/customer-center/franchiseContent";
	}
	
	@RequestMapping("franchiseDelete.do")  // 게시글 삭제 폼
	public String franchiseDelete(HttpServletRequest request){
		writeDelete(request);
		return "/customer-center/franchiseDelete";
	}
	
	@RequestMapping("franchiseDeletePro.do")  //게시글 삭제 Pro
	public String franchiseDeletePro(HttpServletRequest request,HashMap map){
		writeDeletePro(request, map);
		return "/customer-center/franchiseDeletePro";
	}
	
	@RequestMapping("franchiseModify.do")
	public String franchiseModify(HttpServletRequest request,CustomerDTO dto,HashMap map){
		modify(request, dto);
		return "/customer-center/franchiseModify";
	}
	
	@RequestMapping("franchiseModifyPro.do")
	public String franchiseModifyPro(HttpServletRequest request,CustomerDTO dto,HashMap map){
		modifyPro(request, dto, map);
		return "/customer-center/franchiseModifyPro";
	}
	
	
	// 1:1 게시판
	@RequestMapping("oneQA.do")  // 게시판 리스트
	public String oneQA(HttpServletRequest request,HashMap map,Model model){
		boardList(request, map,model);
		return "/customer-center/oneList";
	}
	
	@RequestMapping("oneForm.do")
	public String oneForm(HttpServletRequest request,HttpSession session){   // 문의 작성 폼 
		writeForm(request, session);
		return "/customer-center/oneForm";
	}
	
	@RequestMapping("onePro.do")  // 문의 작성 DB insert 
	public String onePro(CustomerDTO dto,HashMap map,HttpServletRequest request) throws Exception{
		writePro(request, dto, map);
		return "/customer-center/onePro";
	}
	
	@RequestMapping("oneWriteCheck.do")  //  게시글 호출시 패스워드 검사 창
	public String oneWriteCheck(HttpServletRequest request,HttpSession session,HashMap map) {
		writeCheck(request);
		return "/customer-center/oneWriteCheck";
	}

	@RequestMapping("oneContent.do")  // 게시글 내용 호출
	public String oneContent(HttpServletRequest request,HashMap map,CustomerDTO dto,HttpSession session,UserInfoDataDTO user){
		writeContent(request, map, session,dto);
		return "/customer-center/oneContent";
	}
	
	@RequestMapping("oneDelete.do")  // 게시글 삭제 폼
	public String oneDelete(HttpServletRequest request){
		writeDelete(request);
		return "/customer-center/oneDelete";
	}
	
	@RequestMapping("oneDeletePro.do")  //게시글 삭제 Pro
	public String oneDeletePro(HttpServletRequest request,HashMap map){
		writeDeletePro(request, map);
		return "/customer-center/oneDeletePro";
	}
	
	@RequestMapping("oneModify.do")
	public String oneModify(HttpServletRequest request,CustomerDTO dto,HashMap map){
		modify(request, dto);
		return "/customer-center/oneModify";
	}
	
	@RequestMapping("oneModifyPro.do")
	public String oneModifyPro(HttpServletRequest request,CustomerDTO dto,HashMap map){
		modifyPro(request, dto, map);
		return "/customer-center/oneModifyPro";
	}
	
	// 자주 묻는 목록 게시판 
	
	@RequestMapping("customerQA.do")  
	public String customerQA(HttpServletRequest request,HashMap map,Model model){
		boardList(request, map,model);
		return "/customer-center/customerList";
	}
	// 문의 작성 폼 
	@RequestMapping("customerForm.do")
	public String customerForm(HttpServletRequest request,HttpSession session){  
		writeForm(request, session);
		return "/customer-center/customerForm";
	}
	// 문의 작성 DB insert
	@RequestMapping("customerPro.do")   
	public String customerPro(CustomerDTO dto,HashMap map,HttpServletRequest request) throws Exception{
		String pageNum = request.getParameter("pageNum");
		
		int num=dto.getNum(); 
		int ref=dto.getRef();
		int re_step=dto.getRe_step();
		int snum=dto.getSnum();
		int number=0;
		
		number = (Integer)sqlMap.queryForObject("customer.maxNum", null);
		
		if(number!=0){
			number=number+1;
		}else{
			number=1;
		}
		
		if (num!=0){ 
			dto.setRe_step(re_step+1);
		}else{ 
			dto.setRef(number);
			dto.setRe_step(0);
		}
		
		sqlMap.insert("customer.writePro", dto);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("snum", snum);
		return "/customer-center/customerPro";
	}
	// 게시글 내용 호출
	@RequestMapping("customerContent.do")  
	public String customerContent(HttpServletRequest request,HashMap map,CustomerDTO dto,HttpSession session){
		String pageNum = request.getParameter("pageNum");
		String number = request.getParameter("number");
		int snum = Integer.parseInt(request.getParameter("snum"));
		int num = Integer.parseInt(request.getParameter("num"));

		sqlMap.update("customer.contentUp", num);
	
		dto = (CustomerDTO)sqlMap.queryForObject("customer.getContent",num);
		
		map.put("ref", dto.getRef());
		map.put("snum",snum);
		int re_step = (Integer)sqlMap.queryForObject("customer.getReply",map); // 답글의 여부 확인 1일때만 답변 쓸수있음.
		
		request.setAttribute("re_step", re_step);
		request.setAttribute("dto", dto);
		request.setAttribute("number", number);
		request.setAttribute("pageNum", pageNum);
		return "/customer-center/customerContent";
	}
	
	// 게시글 삭제 폼
	@RequestMapping("customerDelete.do")  
	public String customerDelete(HttpServletRequest request){
		writeDelete(request);
		return "/customer-center/customerDelete";
	}
	
	//관리자 글수정 폼
	@RequestMapping("customerModify.do")
	public String customerModify(HttpServletRequest request,CustomerDTO dto){
		Integer snum = Integer.parseInt(request.getParameter("snum"));
		Integer num = Integer.parseInt(request.getParameter("num"));
		String pageNum=request.getParameter("pageNum");
		
		dto = (CustomerDTO)sqlMap.queryForObject("customer.getContent",num);
		
		request.setAttribute("dto", dto);
		request.setAttribute("pageNum", pageNum);
		return "/customer-center/customerModify";
	}
	
	// 관리자 글수정
	@RequestMapping("customerModifyPro.do")
	public String customerModifyPro(HttpServletRequest request,CustomerDTO dto,HashMap map){
		String pageNum= request.getParameter("pageNum");
		int check = 0;
			
		sqlMap.update("customer.modifyContent", dto);

		request.setAttribute("pageNum", pageNum);
		request.setAttribute("dto", dto);
		return "/customer-center/customerModifyPro";
	}
	
	 // 관리자 권한 삭제 확인
	@RequestMapping("bossDelete.do") 
	public String bossDelete(HttpServletRequest request,HashMap map){
		int num = Integer.parseInt(request.getParameter("num"));
		Integer snum = Integer.parseInt(request.getParameter("snum"));
		String pageNum = request.getParameter("pageNum");
		String addr=null;
		int check=0;
		map.put("num", num);
		map.put("snum",snum);
		int ref = (Integer)sqlMap.queryForObject("customer.getRef", map);
		int re_step = (Integer)sqlMap.queryForObject("customer.getRe_step", map);
		map.put("snum",snum);
		map.put("ref",ref);
		map.put("re_step",re_step);
		sqlMap.delete("customer.bossDel", map);
		
		if(snum == 1){addr="franchiseQA"; check=1;}
		if(snum == 2){addr="customerQA"; check=1;}
		if(snum == 3){addr="oneQA"; check=1;}
		
		request.setAttribute("check", check);
		request.setAttribute("addr", addr);
		request.setAttribute("snum", snum);
		request.setAttribute("pageNum", pageNum);
		return "/customer-center/bossDelete";
	}
}
