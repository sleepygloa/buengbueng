package superclass.all.bean;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import manage.boss.bean.FranchiseeDataDTO;

@Controller
public class FranchiseeSelect {

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("franchiseeSelect.do")
	public String franchiseeSelect(HttpSession session, String b_key){
		if(session.getAttribute(b_key) != null){
			session.removeAttribute("b_key");
		}
		session.setAttribute("b_key", b_key);
		
		return "sidemenu";
				
	}
	
	@RequestMapping("franchiseeSelectList.do")
	public String franchiseeList(HttpSession session,String id,Model model){
		List list = new ArrayList();
		FranchiseeDataDTO fdto= null;
		int gradeCheck = 0;
		try{
		gradeCheck = (Integer)sqlMap.queryForObject("erpEmp.getUserGrade", id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//알바생 아이디검사
		if( id !=null && id.contains("employee") ){
				list.add((FranchiseeDataDTO)sqlMap.queryForObject("erpEmp.getEidBkey", id));
				try{
					fdto = (FranchiseeDataDTO)list.get(0);
						if(session.getAttribute("b_key") != null){
							session.removeAttribute("b_key");		
						}
					session.setAttribute("b_key", fdto.getB_key());
					System.out.println("가맹점 라이센스 세션("+fdto.getB_key()+")이 생성 되었습니다.");
				}catch(Exception e){
					System.out.println("가맹점 라이센스 세션생성 오류");
				}

		}else if(gradeCheck == 1){
				list = (List)sqlMap.queryForList("erpEmp.getBossFranchiseeList", id);
				try{
					fdto = (FranchiseeDataDTO)list.get(0);
						if(session.getAttribute("b_key") != null){
							session.removeAttribute("b_key");		
						}
					session.setAttribute("b_key", fdto.getB_key());
					System.out.println("가맹점 라이센스 세션("+fdto.getB_key()+")이 생성 되었습니다.");
				}catch(Exception e){
					System.out.println("가맹점 라이센스 세션생성 오류");
				}
		}else{
			list = sqlMap.queryForList("franchisee.getFirstFranchiseeInfo", id);
		}

		model.addAttribute("flist",list);
		
		return "/bossERP/employeeManage/franchiseeList";
	}

}
