package menu.all.bean;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductBean {
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("product.do")
	public String productForm(HttpServletRequest request){
		try{
		List productList=sqlMap.queryForList("menu.getProduct",null);
		request.setAttribute("productList",productList);
		}catch(Exception e){e.printStackTrace();}
		return "/menu/productForm";
	}
	
	@RequestMapping("productInsertForm.do")
	public String productInsertForm(HttpServletRequest request){
		List nameList = sqlMap.queryForList("menu.productName",null);
		request.setAttribute("nameList",nameList);
		return "/menu/productInsertForm";
	}
	
	@RequestMapping("productInsertPro.do")
	public String productInsertPro(ProductDTO pdto, HttpServletRequest request){
		int check;
		int salecheck=1;
		
			ProductDTO codeDto =(ProductDTO)sqlMap.queryForObject("menu.getProductName",pdto.getCode());
			if(codeDto==null){
				pdto.setSalecheck(salecheck);
				sqlMap.insert("menu.insertProduct",pdto);
				check=1;	
				System.out.println(check);
			}else{
				check=0;
			}
			request.setAttribute("check",check);
		
		return "/menu/productInsertPro";
	}
	
	@RequestMapping("productModify.do")
	public String productModify(HttpServletRequest request){
		List productList=sqlMap.queryForList("menu.getProduct",null);
		request.setAttribute("productList",productList);
		return "/menu/productModify";
	}
	
	@RequestMapping("productModifyForm.do")
	public String productModifyForm(HttpServletRequest request){
		int code=Integer.parseInt(request.getParameter("code"));
		try{
			ProductDTO pdto=(ProductDTO)sqlMap.queryForList("menu.getProductName",code);
			request.setAttribute("pdto",pdto);
		}catch(Exception e){e.printStackTrace();}
		return "/menu/productModifyForm";
	}
	
	@RequestMapping("productModifyPro.do")
	public String productModifyPro(){
		return "/menu/productModifyPro";
	}
	
	@RequestMapping("productDeleteForm.do")
	public String productDeleteForm(HttpServletRequest request){
		List productList=sqlMap.queryForList("menu.getProduct",null);
		request.setAttribute("productList",productList);
		return "/menu/productDeleteForm";
	}
	
	@RequestMapping("productDeletePro.do")
	public String productDeletePro(HttpServletRequest request){
		int code=Integer.parseInt(request.getParameter("code"));
		try{
			sqlMap.delete("menu.deleteProduct",code);
		}catch(Exception e){e.printStackTrace();}
		return "/menu/productDeletePro";
	}
	
}
