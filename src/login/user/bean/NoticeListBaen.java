package login.user.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import superclass.all.bean.SuperClass;

@Controller
public class NoticeListBaen {
@Autowired
private SqlMapClientTemplate sqlMap;

	@RequestMapping("notice.do")
	public String noticeList(HttpServletRequest request,HashMap r){
		int snum = Integer.parseInt(request.getParameter("snum"));
		String pageNum = request.getParameter("pageNum");

		if(pageNum == null){
			pageNum = "1";
		}
		int pageSize = 10; //�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕 �뜝�뙇�뙋�삕 �뜝�룞�삕�뜝�룞�삕�듃 �뜝�룞�삕�뜝占�
		int currentPage = Integer.parseInt(pageNum); //�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
		int startRow = (currentPage -1) * pageSize; //泥ュ뜝�룞�삕吏� �뜝�룞�삕�샇
		int endRow = currentPage * pageSize; //�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�샇
		int count = 0; //�뜝�룞�삕�뜝�룞�삕�듃 �뜝�룞�삕�뜝占� �뜝�룞�삕�뜝�룞�삕
		int number = 0; 
		List articleList = null;
		
		count = (Integer)sqlMap.queryForObject("customer.customercount",snum);
		
		number = count-(currentPage-1)*pageSize;
		
		if(count > 0){
			r.put("snum",snum);
			r.put("startRow", startRow);
			r.put("pageSize",pageSize);
			
		    articleList = (List)sqlMap.queryForList("customer.customerlist", r);
		    	
				}else {articleList = Collections.EMPTY_LIST;}
		
		
        int pageCount = count / pageSize + ( count % pageSize == 0 ? 0 : 1); //�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕		 
        int startPage = ((Integer.parseInt(pageNum)-1)/10)*10+1;	//泥ュ뜝�룞�삕吏� �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�샇
		int pageBlock=10; //�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕
        int endPage = startPage + pageBlock-1; //�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�샇
        
        if (endPage > pageCount) endPage = pageCount; 
		
		request.setAttribute("snum", snum);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("count", count);
		request.setAttribute("articleList", articleList);
		request.setAttribute("number", number);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount",pageCount);
		
		return "/customer-center/noticeList";
	}
	

@RequestMapping("noticeForm.do")
public String noticeForm(HttpServletRequest request){
	int snum = Integer.parseInt(request.getParameter("snum"));
	String pageNum = request.getParameter("pageNum");
	int num=0, ref=1, re_step=0;
	if(request.getParameter("num")!=null){
		num=Integer.parseInt(request.getParameter("num"));
		ref=Integer.parseInt(request.getParameter("ref"));
		re_step=Integer.parseInt(request.getParameter("re_step"));
	}
	
	request.setAttribute("snum", snum);
	request.setAttribute("pageNum", pageNum);
	request.setAttribute("num", new Integer(num));
	request.setAttribute("ref", new Integer(ref));
	request.setAttribute("re_step", new Integer(re_step));


	
	return "/customer-center/noticeForm";
}



@RequestMapping("noticePro.do")
	public String noticePro(HttpServletRequest request,CustomerDTO article){
	int snum = Integer.parseInt(request.getParameter("snum"));
	String pageNum = request.getParameter("pageNum");
	int number = 0;
	int ref = 0;
	int asd =(Integer)sqlMap.queryForObject("customer.maxNum", null);
	if(asd !=0){
		number =asd+1;
	}else{
		number=1;
	}
	
	if(article.getNum() !=0){//�뜝�룞�삕�뜝�룞�삕�뜝占� �뜝�룞�삕�뜎�댙�삕�뜝占�, �뜝�룞�삕�뜝�룞�삕�뜝占� ref�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�떛誘�琉꾩삕 re_step�뜝�룞�삕 1 �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�뙏�뙋�삕!!
		article.setRe_step(article.getRe_step()+1);
	}else{
		article.setRef(number);
		article.setRe_step(0);
	}
	
	sqlMap.insert("customer.writePro", article);
	
	request.setAttribute("snum", snum);
	request.setAttribute("pageNum", pageNum);
	request.setAttribute("ref", ref);
	return "/customer-center/noticePro";
   }

	@RequestMapping("noticeContent.do")
		public String noticeContent(HttpServletRequest request,CustomerDTO article,HashMap r,Model model){
		
		
		int snum = Integer.parseInt(request.getParameter("snum"));//4
		String pageNum = request.getParameter("pageNum");//1
		int num = Integer.parseInt(request.getParameter("num"));//535
		int ref = 0;
		if(request.getParameter("ref") == null){
			
		}else{
			ref = Integer.parseInt(request.getParameter("ref"));//14
		}
		int number = Integer.parseInt(request.getParameter("number"));//1
		int count =0;
		List CmList = null;
		
		sqlMap.update("customer.contentUp",num);
		
	
		article=(CustomerDTO)sqlMap.queryForObject("customer.getContent", num);//snum怨펝um�쑝濡� 李얠쓬
	
		snum = 5; //�씠�쟾源뚯� num�� 4
		count = (Integer)sqlMap.queryForObject("customer.customercount",snum);
		
		if(count > 0){	
			
			r.put("snum", snum);//5
			r.put("ref",ref);//14

			  CmList = (List)sqlMap.queryForList("customer.commentList",r);
		    	System.out.println(CmList);
				}else {CmList = Collections.EMPTY_LIST;}
	
		 
		int countRe = (Integer)sqlMap.queryForObject("customer.commentListCount",r );
		

		
		request.setAttribute("countRe", countRe);		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("article", article);
		request.setAttribute("number", number);
		request.setAttribute("CmList", CmList);
		
		return "/customer-center/noticeContent";
	}
	
	@RequestMapping("noticeModifyForm.do")
	public String noticeModify(HttpServletRequest request,CustomerDTO article,HashMap r){
		int snum = Integer.parseInt(request.getParameter("snum"));
		String pageNum = request.getParameter("pageNum");
		int num = Integer.parseInt(request.getParameter("num"));
		int number = Integer.parseInt(request.getParameter("number"));
		
	
		article = (CustomerDTO)sqlMap.queryForObject("customer.getContent",num);
		
		request.setAttribute("snum", snum);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("num",num);
		request.setAttribute("article", article);
		request.setAttribute("number", number);
		
		return "/customer-center/noticeModifyForm";
	}
	
	@RequestMapping("noticeModifyPro.do")
	public String noticeModifyPro(HttpServletRequest request,CustomerDTO article,HashMap r){
		int snum = Integer.parseInt(request.getParameter("snum"));
		String pageNum = request.getParameter("pageNum");
		int num = Integer.parseInt(request.getParameter("num"));
		int number = Integer.parseInt(request.getParameter("number"));
		
		sqlMap.update("customer.noticeModify", article);
		
		request.setAttribute("snum", snum);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("num", num);
		request.setAttribute("number", number);
		
		return "/customer-center/noticeModifyPro";
	}
	
	
	@RequestMapping("noticeDeleteForm.do")
	public String noticeDeleteForm(HttpServletRequest request){
		int snum = Integer.parseInt(request.getParameter("snum"));
		String pageNum = request.getParameter("pageNum");
		int num = Integer.parseInt(request.getParameter("num"));
		int number = Integer.parseInt(request.getParameter("number"));
		int ref = Integer.parseInt(request.getParameter("ref"));
		
		request.setAttribute("snum", snum);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("num", num);
		request.setAttribute("number", number);
		request.setAttribute("ref", ref);
		
		return "/customer-center/noticeDeleteForm";
	}
	
	
	@RequestMapping("noticeDeletePro.do")
	public String noticeDeletePro(HttpServletRequest request,HttpSession session,HashMap r){
		int snum = Integer.parseInt(request.getParameter("snum"));
		String pageNum = request.getParameter("pageNum");
		int num = Integer.parseInt(request.getParameter("num"));
		int ref = Integer.parseInt(request.getParameter("ref"));
		String pw = request.getParameter("pw");
		int check2=0;
		
		String id = (String)session.getAttribute("loginId");
		
		String pw2 = (String)sqlMap.queryForObject("test.checkPasswd",id);
		
		if(pw2.equals(pw)){ 
			r.put("snum", snum);
			r.put("ref", ref);
			sqlMap.delete("customer.deleteCustomerBoard", r);
			check2=1;
		}
		
		
		
		request.setAttribute("snum", snum);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("ref", ref);
		request.setAttribute("check2", check2);
		return "/customer-center/noticeDeletePro";
	}
	
	

//메인 화면(index.do) 의 공지사항 최신내용 3개 불러오기
@RequestMapping("indexNoticeList.do")
public ModelAndView indexNoticeList(Model model){
	ModelAndView mv = new ModelAndView();
	List articleList = new ArrayList();;
	
	int snum = 4; //고객센터 게시판
	
	try{
		articleList = (List)sqlMap.queryForList("customer.indexCustomerlist", snum);
	}catch(Exception e){
		e.printStackTrace();
	}	
	    
	model.addAttribute("list", articleList);
	mv.setViewName("/customer-center/indexNoticeList");    
	
	return mv;
	}

//메인 화면(index.do) 의 고객센터 최신내용 3개 불러오기
@RequestMapping("indexFranchiseeList.do")
public ModelAndView indexfrachiseeList(Model model){
	ModelAndView mv = new ModelAndView();
	List articleList = new ArrayList();;
	
	int snum = 1; //고객센터 게시판
	
	try{
		articleList = (List)sqlMap.queryForList("customer.indexFranchiseelist", snum);
	}catch(Exception e){
		e.printStackTrace();
	}	
	    System.out.println("어디까지되나요");
	model.addAttribute("list", articleList);
	mv.setViewName("/customer-center/indexFranchiseeList");    
	
	return mv;
	}





}