package menu.all.bean;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuBean {
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	// menu 메인 페이지 이동
	@RequestMapping("menu.do")
	public String menuForm(MenuDTO mdto, HttpServletRequest request){
		try{
		List menuList= sqlMap.queryForList("menu.getMenu",null);
		request.setAttribute("menuList", menuList);
		List categoryList =sqlMap.queryForList("menu.getCategory",null);
		if(categoryList!=null){
			request.setAttribute("categoryList",categoryList);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/menu/menuForm";
	}
	
	/* 메뉴추가 페이지 */
	@RequestMapping("menuInsertForm.do")
	public String menuInsertForm(){
		return "/menu/menuInsertForm";
	}
	
	@RequestMapping("menuInsertPro.do")
	public String menuInsertPro(MenuDTO dto, Model model){
		int check;
		try{
			sqlMap.insert("menu.insertMenu", dto);
			check=1;
		}
		catch(Exception e){e.printStackTrace(); check=0;}
		model.addAttribute("check",check);
		return "/menu/menuInsertPro";
	}
	
	/* 메뉴삭제 페이지 */
	@RequestMapping("menuDeleteForm.do")
	public String menuDeleteForm(HttpServletRequest request){
		List menuList= sqlMap.queryForList("menu.getMenu",null);
		request.setAttribute("menuList", menuList);
		return "/menu/menuDeleteForm";
	}
	
	@RequestMapping("menuDeletePro.do")
	public String menuDeletePro(MenuDTO dto, HttpServletRequest request){
		String name=request.getParameter("name");
		try{
			sqlMap.delete("menu.deleteMenu",name);
		}catch(Exception e){e.printStackTrace();}
		return "/menu/menuDeletePro";
	}
}
