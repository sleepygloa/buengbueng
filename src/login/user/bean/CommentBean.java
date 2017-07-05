package login.user.bean;

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
public class CommentBean {
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("noticeComment.do")
	public String noticeComment(HttpServletRequest request,CustomerDTO article,HashMap r){
	int snum =Integer.parseInt(request.getParameter("snum"));//5
	int num =Integer.parseInt(request.getParameter("num"));//535

	String writer =request.getParameter("writer");
	String content = request.getParameter("content");
	int ref = 	Integer.parseInt(request.getParameter("ref"));//14
	int re_step = 	Integer.parseInt(request.getParameter("re_step"));//0	
	String passwd = request.getParameter("passwd");	
	
	
		
		
	      num=article.getNum(); 
	      ref=article.getRef();
	      re_step=article.getRe_step();
	      snum=article.getSnum();
	      int number=0;
	      
	    
	      if(number!=0){
	    	  
	         number=number;
	      }else{
	         number=1;
	      }
	      
	      if (num!=0){ 
	    	  //article.setRe_step(re_step+1);//
	    	  int zxc=(Integer)sqlMap.queryForObject("customer.Max(re_step)",ref);
	    	  re_step=zxc+1;
	    	  article.setRe_step(re_step);//�씠嫄� 瑗ъ삤�삤�삤�삦 �빐以섏빞�븿!!!!!!!!!!!!!!!!!!!!!!
	      }else{ 
	    	  article.setRef(number);
	    	  article.setRe_step(0);
	      }
		
		
	
		
		sqlMap.insert("customer.commentInsert", article);
		
		r.put("snum", 5);
		r.put("ref",ref);  //14
		
	 List CmList = (List)sqlMap.queryForList("customer.commentList", r);
			    	
	
	r.put("ref",ref);
	r.put("re_step", re_step);
	int countRe = (Integer)sqlMap.queryForObject("customer.commentListCount",r );
				
				request.setAttribute("CmList",CmList);
				request.setAttribute("countRe", countRe);
				
				
		return "/customer-center/noticeComment";
	}
	
	
	
@RequestMapping("commentDeleteForm.do")
	public String commentDeleteForm(HttpServletRequest request,HashMap r){
		int snum = Integer.parseInt(request.getParameter("snum"));
	
		int ref = Integer.parseInt(request.getParameter("ref"));
		int re_step = Integer.parseInt(request.getParameter("re_step"));
		
		r.put("ref", ref);
		r.put("re_step", re_step);
		
		String content=(String)sqlMap.queryForObject("customer.getCommentContent", r);
		
		request.setAttribute("snum", snum);
		request.setAttribute("ref", ref);
		request.setAttribute("re_step", re_step);
		request.setAttribute("content", content);
		return "/customer-center/commentDeleteForm";
	}
	
@RequestMapping("commentDeletePro.do")
public String CommentDeletePRo(HttpServletRequest request,HttpSession session,HashMap r){
	
	int snum = Integer.parseInt(request.getParameter("snum"));
	int ref = Integer.parseInt(request.getParameter("ref"));
	int re_step = Integer.parseInt(request.getParameter("re_step"));
	String passwd = request.getParameter("passwd");	
	
	int asd = 0;
   	
	
	r.put("ref",ref);
	r.put("re_step",re_step);
	String passwd3 =(String)sqlMap.queryForObject("customer.commentPasswd", r);
	if(passwd3.equals(passwd)){
		
		r.put("snum",snum);
		r.put("ref",ref);
		r.put("re_step",re_step);
		sqlMap.delete("customer.commentDelete",r);
		asd = 1;
	}
  
	request.setAttribute("asd", asd);	
	return"/customer-center/commentDeletePro";
}

@RequestMapping("commentModifyForm.do")
 public String commentModifyForm(HttpServletRequest request,HashMap r){
	int snum = Integer.parseInt(request.getParameter("snum"));
	String pageNum = request.getParameter("pageNum");
	int ref = Integer.parseInt(request.getParameter("ref"));
	int re_step = Integer.parseInt(request.getParameter("re_step"));


r.put("ref", ref);
r.put("re_step", re_step);
String content=(String)sqlMap.queryForObject("customer.getCommentContent", r);
	
	request.setAttribute("snum", snum);
	request.setAttribute("pageNum", pageNum);
	request.setAttribute("ref", ref);
	request.setAttribute("re_step", re_step);
	request.setAttribute("content", content);

	return "/customer-center/commentModifyForm";
}

@RequestMapping("commentModifyPro.do")
public String commentModifyPro(Model model, HttpServletRequest request,HashMap r,HttpSession session){
	int snum = Integer.parseInt(request.getParameter("snum"));
	int ref = Integer.parseInt(request.getParameter("ref"));
	int re_step = Integer.parseInt(request.getParameter("re_step"));
	String content = request.getParameter("content");
	String passwd = request.getParameter("passwd");	
	int check = 0;
	
	
	
	r.put("ref",ref);
	r.put("re_step",re_step);
String passwd2 = (String)sqlMap.queryForObject("customer.commentPasswd", r);
	
	
	
	if(passwd2.equals(passwd)){
	r.put("ref", ref);
	r.put("re_step",re_step);
	r.put("content", content);
	sqlMap.update("customer.commentModifyUpdate",r);
	check=1;
	}
	r.put("snum", snum);
	r.put("ref",ref);
	
List CmList =(List)sqlMap.queryForList("customer.commentList", r);
	

	request.setAttribute("check", check);
	System.out.println("check="+check);

	
	return "/customer-center/commentModifyPro";
}


}
