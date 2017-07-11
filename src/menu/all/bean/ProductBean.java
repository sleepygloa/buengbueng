package menu.all.bean;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

@Controller
public class ProductBean {
	@Autowired
	private SqlMapClientTemplate sqlMap;

	
	/* 재고관리 첫 페이지*/
	@RequestMapping("product.do")
	public String productForm(HttpServletRequest request, HttpSession session){
		try{
			//사이드메뉴 템플릿
			int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
			int sidemenu = 3; //사이드메뉴의 내용을 선택
			request.setAttribute("sidemenuCheck", sidemenuCheck);
			request.setAttribute("sidemenu", sidemenu);
	
			
		String l_key=(String)session.getAttribute("b_key");		
		ArrayList menuCount=new ArrayList(); 
		ArrayList categoryList=new ArrayList();
		
		List productnameList=(List)sqlMap.queryForList("menu.distinctProductName",l_key);
		if(productnameList!=null){
		for(int i=0;i<productnameList.size();i++){
			 String menuname=(String)productnameList.get(i);
			 HashMap map = new HashMap();
			 map.put("name",menuname);
			 map.put("l_key",l_key);
			 int count = (Integer)sqlMap.queryForObject("menu.getProductCount", map);
			 menuCount.add(count);
			 String categorymenu=(String)sqlMap.queryForObject("menu.getProductCategory",map);
			 categoryList.add(categorymenu);
			}
		}else{
			productnameList=java.util.Collections.EMPTY_LIST;
		}
		
		request.setAttribute("nameList",productnameList);
		request.setAttribute("countList",menuCount);
		request.setAttribute("categoryList",categoryList);
		
		request.setAttribute("productList",productnameList);
		request.setAttribute("l_key", l_key);
		}catch(Exception e){e.printStackTrace();}
		return "/menu/productForm";
	}
	
	/* 재고추가 페이지*/
	@RequestMapping("productInsertForm.do")
	public String productInsertForm(HttpServletRequest request, String l_key){
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		request.setAttribute("sidemenuCheck", sidemenuCheck);
		request.setAttribute("sidemenu", sidemenu);
		
		List nameList = sqlMap.queryForList("menu.productName",l_key);
		request.setAttribute("nameList",nameList);
		request.setAttribute("l_key", l_key);
		return "/menu/productInsertForm";
	}
	
	/* 재고추가시 판매여부 값 1 넣어주고 바코드값 중복 체크해주고 재고등록*/
	@RequestMapping("productInsertPro.do")
	public String productInsertPro(ProductDTO pdto,String last,String l_key, HttpServletRequest request){
		int check;
		int salecheck=1;
		try{
			HashMap map=new HashMap();
			map.put("code",pdto.getCode());
			map.put("name", pdto.getName());
			map.put("l_key",l_key);
			ProductDTO codeDto =(ProductDTO)sqlMap.queryForObject("menu.getProductName",map);
			if(codeDto==null){
				pdto.setSalecheck(salecheck);
				pdto.setLastday(java.sql.Date.valueOf(last));
				sqlMap.insert("menu.insertProduct",pdto);
				sqlMap.insert("menu.insertSaleBuyLog",pdto);
				check=1;	
				request.setAttribute("l_key", pdto.getL_key());
			}else{
				check=0;
				request.setAttribute("l_key", pdto.getL_key());
			}
			request.setAttribute("check",check);
			request.setAttribute("l_key", pdto.getL_key());
		}catch(Exception e){e.printStackTrace(); check=0; request.setAttribute("check",check);}
		
		return "/menu/productInsertPro";
	}
	
	/* 재고수정 페이지*/
	@RequestMapping("productModify.do")
	public String productModify(HttpServletRequest request, String l_key, String name){
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		request.setAttribute("sidemenuCheck", sidemenuCheck);
		request.setAttribute("sidemenu", sidemenu);
		
		HashMap map = new HashMap();
		map.put("name",name);
		map.put("l_key", l_key);		
		List productList=sqlMap.queryForList("menu.getProductStatus",map);
		request.setAttribute("productList",productList);
		request.setAttribute("l_key", l_key);
		request.setAttribute("name",name);
		return "/menu/productModify";
	}
	
	
	@RequestMapping("productModifyForm.do")
	public String productModifyForm(HttpServletRequest request,String name,String code, String l_key){
		try{

			//사이드메뉴 템플릿
			int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
			int sidemenu = 3; //사이드메뉴의 내용을 선택
			request.setAttribute("sidemenuCheck", sidemenuCheck);
			request.setAttribute("sidemenu", sidemenu);
			
			HashMap map = new HashMap();
			map.put("name", name);
			map.put("code",code);
			map.put("l_key", l_key);
			ProductDTO pdto=(ProductDTO)sqlMap.queryForObject("menu.getProductName",map);
			request.setAttribute("pdto",pdto);
			List nameList = sqlMap.queryForList("menu.productName",pdto.getL_key());
			request.setAttribute("pdto",pdto);
			request.setAttribute("nameList",nameList);
			request.setAttribute("l_key",l_key);
			request.setAttribute("name", name);
		}catch(Exception e){e.printStackTrace();}
		return "/menu/productModifyForm";
	}
	
	@RequestMapping("productModifyPro.do")
	public String productModifyPro(ProductDTO pdto, HttpServletRequest request, String name){
		int check=0;
		String l_key=request.getParameter("l_key");
		String last=request.getParameter("last");
		String beforeCode=request.getParameter("beforeCode");
		String beforeLastday=request.getParameter("beforeLastday");
		
		pdto.setLastday(java.sql.Date.valueOf(last));
		Date beforelastday=java.sql.Date.valueOf(beforeLastday);
		try{
			HashMap map2=new HashMap();
			map2.put("code",pdto.getCode());
			map2.put("l_key",l_key);
		ProductDTO codeDto =(ProductDTO)sqlMap.queryForObject("menu.getProductName",map2);
		if(codeDto==null){
			HashMap map = new HashMap();
			map.put("beforeCode", beforeCode);
			map.put("lastday",pdto.getLastday());
			map.put("code",pdto.getCode());
			map.put("l_key",l_key);
			sqlMap.update("menu.updateProduct",map);
			check=1;
		}
		else if(!pdto.getLastday().equals(beforelastday)){
			HashMap map = new HashMap();
			map.put("beforeCode", beforeCode);
			map.put("lastday",pdto.getLastday());
			map.put("code",pdto.getCode());
			map.put("l_key",l_key);
			sqlMap.update("menu.updateProduct",map);
			check=1;
		}else if(pdto.getLastday().equals(beforelastday)){
			HashMap map = new HashMap();
			map.put("beforeCode", beforeCode);
			map.put("lastday",pdto.getLastday());
			map.put("code",pdto.getCode());
			map.put("l_key",l_key);
			sqlMap.update("menu.updateProduct",map);
			check=1;
		}

		request.setAttribute("l_key", l_key);
		request.setAttribute("check",check);
		request.setAttribute("name", name);
		}catch(Exception e){e.printStackTrace();check=-1; request.setAttribute("check",check);}
		
		return "/menu/productModifyPro";
	}
	
	@RequestMapping("productDeleteForm.do")
	public String productDeleteForm(HttpServletRequest request, String l_key){
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		request.setAttribute("sidemenuCheck", sidemenuCheck);
		request.setAttribute("sidemenu", sidemenu);
		
		List productList=sqlMap.queryForList("menu.getProduct",l_key);
		request.setAttribute("productList",productList);
		request.setAttribute("l_key", l_key);
		return "/menu/productDeleteForm";
	}
	
	@RequestMapping("productDeletePro.do")
	public String productDeletePro(HttpServletRequest request,String code, String l_key,String name){
		try{
			HashMap map=new HashMap();
			map.put("code", code);
			map.put("l_key", l_key);
			map.put("name", name);
			sqlMap.delete("menu.deleteProduct",map);
			request.setAttribute("l_key", l_key);
			request.setAttribute("name",name);
		}catch(Exception e){e.printStackTrace();}
		return "/menu/productDeletePro";
	}
	
}
