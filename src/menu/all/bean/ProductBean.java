package menu.all.bean;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductBean {
	@Autowired
	private SqlMapClientTemplate sqlMap;

	
	/* 재고관리 첫 페이지*/
	@RequestMapping("product.do")
	public String productForm(HttpServletRequest request, String l_key){
		try{
		List productList=sqlMap.queryForList("menu.getProduct",l_key);
		request.setAttribute("productList",productList);
		request.setAttribute("l_key", l_key);
		}catch(Exception e){e.printStackTrace();}
		return "/menu/productForm";
	}
	
	/* 재고추가 페이지*/
	@RequestMapping("productInsertForm.do")
	public String productInsertForm(HttpServletRequest request, String l_key){
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
	public String productModify(HttpServletRequest request, String l_key){
		List productList=sqlMap.queryForList("menu.getProduct",l_key);
		request.setAttribute("productList",productList);
		request.setAttribute("l_key", l_key);
		return "/menu/productModify";
	}
	
	
	@RequestMapping("productModifyForm.do")
	public String productModifyForm(HttpServletRequest request,String code, String l_key){
		try{

			HashMap map = new HashMap();
			map.put("code",code);
			map.put("l_key", l_key);
			ProductDTO pdto=(ProductDTO)sqlMap.queryForObject("menu.getProductName",map);
			request.setAttribute("pdto",pdto);
			List nameList = sqlMap.queryForList("menu.productName",pdto.getL_key());
			request.setAttribute("nameList",nameList);
			request.setAttribute("l_key",l_key);
		}catch(Exception e){e.printStackTrace();}
		return "/menu/productModifyForm";
	}
	
	@RequestMapping("productModifyPro.do")
	public String productModifyPro(ProductDTO pdto, HttpServletRequest request){
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
		}catch(Exception e){e.printStackTrace();check=-1; request.setAttribute("check",check);}
		
		return "/menu/productModifyPro";
	}
	
	@RequestMapping("productDeleteForm.do")
	public String productDeleteForm(HttpServletRequest request, String l_key){
		List productList=sqlMap.queryForList("menu.getProduct",l_key);
		request.setAttribute("productList",productList);
		request.setAttribute("l_key", l_key);
		return "/menu/productDeleteForm";
	}
	
	@RequestMapping("productDeletePro.do")
	public String productDeletePro(HttpServletRequest request,String code, String l_key){
		try{
			HashMap map=new HashMap();
			map.put("code", code);
			map.put("l_key", l_key);
			sqlMap.delete("menu.deleteProduct",map);
			request.setAttribute("l_key", l_key);
		}catch(Exception e){e.printStackTrace();}
		return "/menu/productDeletePro";
	}
	
}
