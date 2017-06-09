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
	public String productForm(){
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
		try{
			sqlMap.insert("menu.insertProduct",pdto);
			check=1;
		}catch(Exception e){e.printStackTrace(); check=0;}
		return "/menu/productInsertPro";
	}
	
	@RequestMapping("productModifyForm.do")
	public String productModifyForm(){
		return "/menu/productModifyForm";
	}
	
	@RequestMapping("productModifyPro.do")
	public String productModifyPro(){
		return "/menu/productModifyPro";
	}
	
	@RequestMapping("productDeleteForm.do")
	public String productDeleteForm(){
		return "/menu/productDeleteForm";
	}
	
	@RequestMapping("productDeletePro.do")
	public String productDeletePro(){
		return "/menu/productDeletePro";
	}
	
}
