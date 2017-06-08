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
	
	/* 메뉴수정 페이지 */
	
	@RequestMapping("menuModify.do")
	public String menuModify(HttpServletRequest request){
		List menuList= sqlMap.queryForList("menu.getMenu",null);
		request.setAttribute("menuList", menuList);
		return "/menu/menuModify";
	}

	@RequestMapping("menuModifyForm.do")
	public String menuModifyForm(HttpServletRequest request){
		String name=request.getParameter("name");
		MenuDTO mdto=(MenuDTO)sqlMap.queryForObject("menu.getMenuName",name);
		request.setAttribute("mdto",mdto);
		return "/menu/menuModifyForm";
	}
	
	@RequestMapping("menuModifyPro.do")
	public String menuModifyPro(MenuDTO mdto, HttpServletRequest request){
		int check;
		try{
			check=1;
			System.out.println(mdto.getName());
			sqlMap.update("menu.updateMenu", mdto);
			request.setAttribute("check",check);
		}catch(Exception e){e.printStackTrace(); check=0;}		
		return "/menu/menuModifyPro";
	}
	
	/* 메뉴삭제 페이지 */
	@RequestMapping("menuDeleteForm.do")
	public String menuDeleteForm(HttpServletRequest request){
		List menuList= sqlMap.queryForList("menu.getMenu",null);
		request.setAttribute("menuList", menuList);
		return "/menu/menuDeleteForm";
	}
	
	@RequestMapping("menuDeletePro.do")
	public String menuDeletePro(HttpServletRequest request){
		String name=request.getParameter("name");
		try{
			sqlMap.delete("menu.deleteMenu",name);
		}catch(Exception e){e.printStackTrace();}
		return "/menu/menuDeletePro";
	}
	
	/* 카테고리별 메뉴 리스트 보여주기 */
	@RequestMapping("menuCategoryClick.do")
	public String menuCategoryClick(HttpServletRequest request){
		String category=request.getParameter("category");
		// 전체 다 뜨는 거
		if(category.equals("all")){
			List menuList= sqlMap.queryForList("menu.getMenu",null);
			request.setAttribute("menuList", menuList);
		}else{
			List categoryMenuList=sqlMap.queryForList("menu.categoryMenuList",category);
			request.setAttribute("categoryMenuList",categoryMenuList);
		}
		return "/menu/menuCategoryClick";
	}
	
	/* 카테고리 전체 메뉴 보여주기 */
	@RequestMapping("menuCategoryAll.do")
	public String menuCategoryAll(HttpServletRequest request){
		List menuList= sqlMap.queryForList("menu.getMenu",null);
		request.setAttribute("menuList", menuList);
		return "/menu/menuCategoryAll";
	}
}
