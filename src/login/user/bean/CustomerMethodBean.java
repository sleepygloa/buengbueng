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
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerMethodBean {  // 사용자 게시판 메서드( 가맹문의, 1:1 문의 , 자주묻는 질문)
	
	@Autowired
	SqlMapClientTemplate sqlMap;
	//글 목록
	public void boardList(HttpServletRequest request,HashMap map){
		Integer snum = Integer.parseInt(request.getParameter("snum"));
		String pageNum = request.getParameter("pageNum");
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		if(pageNum==null){pageNum="1";}
		
		int pageSize=10; // endRow와 같이써도 가능함. mysql limit 사용시. 출력은 고정.
		int currentPage = Integer.parseInt(pageNum);
	    int startRow = (currentPage - 1) * pageSize; // mysql에서 limit 는 0부터 시작해야 rownum 1번 값부터 호출
	    int number=0;
	    
	    List list=null;
	    String[] dates = null;	
	    int count = (Integer)sqlMap.queryForObject("customer.customercount", snum); //해당 페이지 게시글 갯수
	    if (count > 0) {
	    	map.put("snum",snum);
	    	map.put("startRow",startRow);
		    map.put("pageSize",pageSize);
	    	list = sqlMap.queryForList("customer.customerlist", map);
            dates = new String[count];
			for(int i = 0; i< list.size(); i++){
				dates[i] = sdf.format(((CustomerDTO)list.get(i)).getReg_date());
				}
	    }else{
	    	list = Collections.EMPTY_LIST;
	    }
	    
		number=count-(currentPage-1)*pageSize;
		// 페이지 카운트
        int pageCount = count / pageSize + ( count % pageSize == 0 ? 0 : 1);
		 
        int startPage = ((Integer.parseInt(pageNum)-1)/10)*10+1;
		int pageBlock=10;
        int endPage = startPage + pageBlock-1;
        if (endPage > pageCount) endPage = pageCount;

		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("number", number);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("snum", snum);
		request.setAttribute("dates", dates);
	}
	// 글쓰기 폼
	public void writeForm(HttpServletRequest request,HttpSession session){
		if(session.getAttribute("loginId") != null){  // 로그인 세션 기록 있을때 해당 로그인 정보 호출
			String id = (String)session.getAttribute("loginId");
			UserInfoDataDTO user = (UserInfoDataDTO)sqlMap.queryForObject("test.getUserInfo", id);
			request.setAttribute("user", user);
		}
		
		Integer snum = Integer.parseInt(request.getParameter("snum"));
		String pageNum = request.getParameter("pageNum");
		int num=0,ref=1,re_step=0;
		if(request.getParameter("num")!=null){
			String title=request.getParameter("title");
			num=Integer.parseInt(request.getParameter("num"));
			ref=Integer.parseInt(request.getParameter("ref"));
			re_step=Integer.parseInt(request.getParameter("re_step"));
			request.setAttribute("title", title);
		}
		request.setAttribute("num", new Integer(num));
		request.setAttribute("ref", new Integer(ref));
		request.setAttribute("re_step", new Integer(re_step));
		request.setAttribute("snum", snum);
		request.setAttribute("pageNum", pageNum);
	}
	// 글 입력
	public void writePro(HttpServletRequest request,CustomerDTO dto,HashMap map){
		String pageNum = request.getParameter("pageNum");

		int num=dto.getNum(); 
		int ref=dto.getRef();
		int re_step=dto.getRe_step();
		int snum=dto.getSnum();
		int number=0;
		
		// 답글 작성시 기존 글과 비밀번호 통일
		if(request.getParameter("b_passwd")==""){
			map.put("snum", snum);
			map.put("num",num);
			String passwd = (String)sqlMap.queryForObject("customer.getPasswd", map);
			dto.setPasswd(passwd);
		}
		
		
		number = (Integer)sqlMap.queryForObject("customer.maxNum", snum);
		
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
	}
	// 글 불러오기 이전 유효성 체크
	public void writeCheck(HttpServletRequest request){
		String pageNum = request.getParameter("pageNum");
		String number = request.getParameter("number");
		Integer num = Integer.parseInt(request.getParameter("num"));
				
		CustomerDTO dto = (CustomerDTO)sqlMap.queryForObject("customer.getContent", num);
		
		request.setAttribute("dto", dto);
		request.setAttribute("number", number);
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
	}
	// 글 불러오기
	public void writeContent(HttpServletRequest request,HashMap map,HttpSession session,CustomerDTO dto){
		String passwd = request.getParameter("passwd");
		String pageNum = request.getParameter("pageNum");
		String number = request.getParameter("number");
		Integer snum = Integer.parseInt(request.getParameter("snum"));
		Integer num = Integer.parseInt(request.getParameter("num"));
		int check = 0;
		int grade = 0;
		
		dto = (CustomerDTO)sqlMap.queryForObject("customer.getContent", num);
		
		// 등급이 관리자 or 해당글 비밀번호 일치시 ...
		if(session.getAttribute("grade")!=null){grade = (Integer)session.getAttribute("grade");}
		if(dto.getPasswd().equals(passwd) || grade==4){check=1; sqlMap.update("customer.contentUp", map);
		}else{ check =0;}
				
		map.put("ref", dto.getRef());
		map.put("snum",snum);
		int re_step = (Integer)sqlMap.queryForObject("customer.getReply",map); // 답글의 여부 확인 1일때만 답변 쓸수있음.	
		request.setAttribute("re_step", re_step);

		request.setAttribute("check", check);
		request.setAttribute("dto", dto);
		request.setAttribute("number", number);
		request.setAttribute("pageNum", pageNum);
	}
	
	// 글삭제 폼
	public void writeDelete(HttpServletRequest request){
		Integer num = Integer.parseInt(request.getParameter("num"));
		Integer snum = Integer.parseInt(request.getParameter("snum"));
		String pageNum = request.getParameter("pageNum");
		request.setAttribute("snum", snum);
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
	}
	//글삭제 유효성 체크
	public void writeDeletePro(HttpServletRequest request,HashMap map){
		int num = Integer.parseInt(request.getParameter("num"));
		Integer snum = Integer.parseInt(request.getParameter("snum"));
		String pageNum = request.getParameter("pageNum");
		String passwd = request.getParameter("passwd");
		int check=0;
		// 고유 번호와 글번호로 DB 비밀번호 호출
		map.put("num", num);
		map.put("snum",snum);
		String dispasswd = (String)sqlMap.queryForObject("customer.getPasswd", map);
		// 뷰에서 받은 비밀번호와 DB에서 받은 비밀번호 비교
		if(passwd.equals(dispasswd)){
			// 해당 글의 ref 그룹 호출 후 해당글 삭제
			int ref = (Integer)sqlMap.queryForObject("customer.getRef", map);  
			int re_step = (Integer)sqlMap.queryForObject("customer.getRe_step", map);
			map.put("snum", snum);
			map.put("ref",ref);
			map.put("re_step",re_step);
			sqlMap.delete("customer.delRef", map);
			check =1;
		}	
		request.setAttribute("snum", snum);
		request.setAttribute("check", check);
		request.setAttribute("pageNum", pageNum);
	}
	
	// 글수정 폼
	public void modify(HttpServletRequest request,CustomerDTO dto){
		Integer snum = Integer.parseInt(request.getParameter("snum"));
		Integer num = Integer.parseInt(request.getParameter("num"));
		String pageNum=request.getParameter("pageNum");

		dto = (CustomerDTO)sqlMap.queryForObject("customer.getContent",num);
		
		request.setAttribute("dto", dto);
		request.setAttribute("pageNum", pageNum);
	}
	
	// 글수정 유효성 검사
	public void modifyPro(HttpServletRequest request,CustomerDTO dto,HashMap map){
		String pageNum= request.getParameter("pageNum");
		int check = 0;

		map.put("num",dto.getNum());
		map.put("snum",dto.getSnum());
		String dispasswd = (String)sqlMap.queryForObject("customer.getPasswd",map);

		if(dto.getPasswd().equals(dispasswd)){
			sqlMap.update("customer.modifyContent", dto);
			check=1;
		}
		request.setAttribute("check", check);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("dto", dto);
	}
}
