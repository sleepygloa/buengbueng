package menu.all.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	// 가맹점 라이센스 찾아서 메뉴사용 
	@RequestMapping("franchiseeMenu.do")
	public String franchiseeMenu(HttpSession session, HttpServletRequest request){
		try{
			String id=(String)session.getAttribute("loginId");
			String name=(String)sqlMap.queryForObject("menu.getBossName",id);
			request.setAttribute("name",name);
			List franchiseeList = sqlMap.queryForList("menu.getLicenseKeyList",id);
			request.setAttribute("franchiseeList", franchiseeList);
		
		}catch(Exception e){e.printStackTrace();}
		return "/menu/franchiseeMenu";
	}
	
	// 가맹점 라이센스 선택 후 
	@RequestMapping("franchiseeMenuPro.do")
	public String franchiseeMenuPro(String name,HttpSession session, HttpServletRequest request){
		int check=0;
		String l_key=null;
		System.out.println(name);
		try{
			if(name=="나의 가맹점 선택"){
				check=0;
			}else{
			String id=(String)session.getAttribute("loginId");
			HashMap map=new HashMap();
			map.put("name",name);
			map.put("id",id);
			l_key = (String)sqlMap.queryForObject("menu.getLicenseKey", map);
			if(l_key!=null){
			check=1;
			}else{
				check=0;
			}
		}
		request.setAttribute("check", check);
		request.setAttribute("name", name);
		request.setAttribute("l_key", l_key);
		
		}catch(Exception e){e.printStackTrace(); check=-1; request.setAttribute("check",check);}
		return "/menu/franchiseeMenuPro";
	}
		
	
	// menu 메인 페이지 이동
	@RequestMapping("menu.do")
	public String menuForm(MenuDTO mdto,HttpSession session,HttpServletRequest request){
		try{
			//사이드메뉴 템플릿
			int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
			int sidemenu = 3; //사이드메뉴의 내용을 선택
			request.setAttribute("sidemenuCheck", sidemenuCheck);
			request.setAttribute("sidemenu", sidemenu);
			
			String l_key= (String)session.getAttribute("b_key");
			List menuList= (List)sqlMap.queryForList("menu.getMenu",l_key);
			request.setAttribute("menuList", menuList);
			
			List categoryList =sqlMap.queryForList("menu.getCategory",l_key);
			if(categoryList!=null){
				request.setAttribute("categoryList",categoryList);
				
			}
		request.setAttribute("l_key", l_key);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return "/menu/menuForm";
	}
	
	/* 메뉴추가 페이지 */
	@RequestMapping("menuInsertForm.do")
	public String menuInsertForm(HttpServletRequest request, String l_key){
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		request.setAttribute("sidemenuCheck", sidemenuCheck);
		request.setAttribute("sidemenu", sidemenu);
		
		request.setAttribute("l_key", l_key);
		return "/menu/menuInsertForm";
	}
	
	@RequestMapping("menuInsertPro.do")
	public String menuInsertPro(MenuDTO mdto, HttpServletRequest request, HttpSession session,
			String l_key ){
		int check=0;
		try{
			String id=(String)session.getAttribute("loginId");
			if(!l_key.equals(null)){
			sqlMap.insert("menu.insertMenu", mdto);
			check=1;
			}else{
				check=0;
			}
			request.setAttribute("check", check);
			request.setAttribute("l_key",l_key);
		
		}
		catch(Exception e){e.printStackTrace(); check=-1; request.setAttribute("check", check);}
		return "/menu/menuInsertPro";
	}
	
	/* 메뉴수정 페이지 */
	
	@RequestMapping("menuModify.do")
	public String menuModify(HttpServletRequest request,String l_key,HttpSession session){

		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		request.setAttribute("sidemenuCheck", sidemenuCheck);
		request.setAttribute("sidemenu", sidemenu);
		
		String id=(String)session.getAttribute("loginId");

		List menuList= (List)sqlMap.queryForList("menu.getMenu",l_key);
		request.setAttribute("menuList", menuList);
		request.setAttribute("l_key",l_key);
		
		
		
		return "/menu/menuModify";
	}

	@RequestMapping("menuModifyForm.do")
	public String menuModifyForm(HttpServletRequest request,String l_key, MenuDTO mdto, HttpSession session){
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		request.setAttribute("sidemenuCheck", sidemenuCheck);
		request.setAttribute("sidemenu", sidemenu);
		
		HashMap map=new HashMap();
		map.put("name",mdto.getName());
		map.put("l_key", l_key);
		
		System.out.println(map);
		mdto=(MenuDTO)sqlMap.queryForObject("menu.getMenuName",map);
		request.setAttribute("mdto",mdto);
		request.setAttribute("l_key",l_key);
		return "/menu/menuModifyForm";
	}
	
	@RequestMapping("menuModifyPro.do")
	public String menuModifyPro(String beforeName,String l_key,MenuDTO mdto, HttpServletRequest request){
		int check=0;
		try{
			check=1;
	
			HashMap map=new HashMap();
			map.put("beforeName",beforeName);
			map.put("name", mdto.getName());
			map.put("price", mdto.getPrice());
			map.put("category", mdto.getCategory());
			map.put("company", mdto.getCompany());
			sqlMap.update("menu.updateMenu", map);
			
			request.setAttribute("check",check);
			request.setAttribute("l_key", l_key);
			
		}catch(Exception e){e.printStackTrace(); check=0; request.setAttribute("check", check);}		
		return "/menu/menuModifyPro";
	}
	
	/* 메뉴삭제 페이지 */
	@RequestMapping("menuDeleteForm.do")
	public String menuDeleteForm(HttpServletRequest request, String l_key){
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		request.setAttribute("sidemenuCheck", sidemenuCheck);
		request.setAttribute("sidemenu", sidemenu);
		
		List menuList= sqlMap.queryForList("menu.getMenu",l_key);
		request.setAttribute("menuList", menuList);
		request.setAttribute("l_key",l_key);
		return "/menu/menuDeleteForm";
	}
	
	@RequestMapping("menuDeletePro.do")
	public String menuDeletePro(HttpServletRequest request, String l_key){
		String name=request.getParameter("name");
		try{
			HashMap map=new HashMap();
			map.put("name", name);
			map.put("l_key", l_key);
			sqlMap.delete("menu.deleteMenu",map);
			request.setAttribute("l_key",l_key);
		}catch(Exception e){e.printStackTrace();}
		return "/menu/menuDeletePro";
	}
	
	/* 카테고리별 메뉴 리스트 보여주기 */
	@RequestMapping("menuCategoryClick.do")
	public String menuCategoryClick(HttpServletRequest request, String l_key){
		String category=request.getParameter("category");
		// 전체 다 뜨는 거
		if(category.equals("all")){
			List menuList= sqlMap.queryForList("menu.getMenu",l_key);
			System.out.println(menuList.size());
			request.setAttribute("menuList", menuList);
			request.setAttribute("l_key", l_key);
		}else{
			HashMap map=new HashMap();
			map.put("category", category);
			map.put("l_key", l_key);
			List<MenuDTO> categoryMenuList=(List<MenuDTO>)sqlMap.queryForList("menu.categoryMenuList",map);
			request.setAttribute("categoryMenuList",categoryMenuList);
			request.setAttribute("l_key", l_key);
		}
		return "/menu/menuCategoryClick";
	}
	
	/* 카테고리 전체 메뉴 보여주기 */
	@RequestMapping("menuCategoryAll.do")
	public String menuCategoryAll(HttpServletRequest request,String l_key){
		List menuList= sqlMap.queryForList("menu.getMenu",l_key);
		request.setAttribute("menuList", menuList);
		request.setAttribute("l_key", l_key);
		return "/menu/menuCategoryAll";
	}
}
