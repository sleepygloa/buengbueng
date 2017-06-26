package fx.user.bean;

import java.net.URLEncoder;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import index.all.bean.FranchiseeModuleDataDTO;
import index.all.bean.ModuleDataDTO;

@Controller
public class FxBossModuleBean {

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("fxGetModule.do")
	public String fxGetModule(FranchiseeModuleDataDTO fdto, int grade, String change, Model model){
		try{
			if(grade == 2){
				String bossId = (String)sqlMap.queryForObject("module.getBossId", fdto.getB_id());
				fdto.setB_id(bossId);
			}
			
			ArrayList<String> getN = (ArrayList<String>)sqlMap.queryForList("module.getModuleNames",fdto.getB_id());
			StringBuffer name = new StringBuffer();
			StringBuffer module = new StringBuffer();
			StringBuffer menu = new StringBuffer();
			for(int i=0; i<getN.size(); i++){
				name.append("\""+getN.get(i)+"\"");
				if(i!=getN.size()-1){
					name.append(",");
				}
			}

			model.addAttribute("name", URLEncoder.encode(name.toString(),"UTF-8"));
			FranchiseeModuleDataDTO dto = null;
			if(fdto.getM_name() == null){
				dto = (FranchiseeModuleDataDTO)sqlMap.queryForObject("module.getModule",fdto.getB_id());
				if(grade == 2){
					module.append(dto.getModule().substring(0, dto.getModule().length()-2));
					int last = dto.getMenu().indexOf(",\"option\"");
					menu.append(dto.getMenu().substring(0, last));
				}else{
					module.append(dto.getModule());
					menu.append(dto.getMenu());
				}
			}else if(fdto.getM_name() != null && change == null){
				dto = (FranchiseeModuleDataDTO)sqlMap.queryForObject("module.getModuleForName",fdto);
				module.append(dto.getModule().substring(0, dto.getModule().length()-2));
				int last = dto.getMenu().indexOf(",\"option\"");
				menu.append(dto.getMenu().substring(0, last));
			}else{
				sqlMap.update("module.setModuleFalse", fdto);
				fdto.setM_name(change);
				sqlMap.update("module.changeModule", fdto);
				dto = (FranchiseeModuleDataDTO)sqlMap.queryForObject("module.getModuleForName",fdto);
				module.append(dto.getModule());
				menu.append(dto.getMenu());
			}
			model.addAttribute("module", module.toString());
			model.addAttribute("menu", menu.toString());
			
		}catch(Exception e){
			
		}
		return "/fxBossModule/fxGetModule";
	}
	
	@RequestMapping("fxSetModule.do")
	public String fxSetModule(Model model){
		ModuleDataDTO moduleName = (ModuleDataDTO)sqlMap.queryForObject("module.getOfferMenu", null);
		int last = moduleName.getModuleName().indexOf(",\"option\"");
		model.addAttribute("moduleName", moduleName.getModuleName().substring(0, last));
		return "/fxBossModule/fxSetModule";
	}
	
	@RequestMapping("fxSetModulePro.do")
	public String fxSetModulePro(FranchiseeModuleDataDTO fdto, Model model){
		sqlMap.update("module.setModuleFalse", fdto);
		sqlMap.update("module.setModule", fdto);
		FranchiseeModuleDataDTO dto = (FranchiseeModuleDataDTO)sqlMap.queryForObject("module.getModule",fdto.getB_id());
		StringBuffer module = new StringBuffer();
		module.append(dto.getModule());
		model.addAttribute("module", module.toString());
		StringBuffer menu = new StringBuffer();
		menu.append(dto.getMenu());
		model.addAttribute("menu", menu.toString());
		return "/fxBossModule/fxGetModule";
	}

	@RequestMapping("fxRemoveModule.do")
	public String fxRemoveModule(FranchiseeModuleDataDTO fdto, Model model){
		sqlMap.delete("module.deleteModule", fdto);
		FranchiseeModuleDataDTO dto = (FranchiseeModuleDataDTO)sqlMap.queryForObject("module.getModule",fdto.getB_id());
		StringBuffer module = new StringBuffer();
		module.append(dto.getModule());
		model.addAttribute("module", module.toString());
		StringBuffer menu = new StringBuffer();
		menu.append(dto.getMenu());
		model.addAttribute("menu", menu.toString());
		return "/fxBossModule/fxGetModule";
	}
	
	@RequestMapping("fxModiModulePro.do")
	public String fxModiModulePro(FranchiseeModuleDataDTO fdto, Model model){
		sqlMap.update("module.updateModule", fdto);
		FranchiseeModuleDataDTO dto = (FranchiseeModuleDataDTO)sqlMap.queryForObject("module.getModule",fdto.getB_id());
		StringBuffer module = new StringBuffer();
		module.append(dto.getModule());
		model.addAttribute("module", module.toString());
		StringBuffer menu = new StringBuffer();
		menu.append(dto.getMenu());
		model.addAttribute("menu", menu.toString());
		return "/fxBossModule/fxGetModule";
	}
}
