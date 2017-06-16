package fx.user.bean;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import index.all.bean.FranchiseeModuleDataDTO;

@Controller
public class FxBossERPBean {

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("fxGetModule.do")
	public String fxGetModule(FranchiseeModuleDataDTO fdto, String change, Model model){
		try{
			ArrayList<String> getN = (ArrayList<String>)sqlMap.queryForList("module.getModuleNames",fdto.getB_key());
			StringBuffer name = new StringBuffer();
			for(int i=0; i<getN.size(); i++){
				name.append("\""+getN.get(i)+"\"");
				if(i!=getN.size()-1){
					name.append(",");
				}
			}
			model.addAttribute("name", name.toString());
			FranchiseeModuleDataDTO dto = null;
			if(fdto.getM_name() == null){
				dto = (FranchiseeModuleDataDTO)sqlMap.queryForObject("module.getModule",fdto.getB_key());
			}else if(fdto.getM_name() != null && change == null){
				dto = (FranchiseeModuleDataDTO)sqlMap.queryForObject("module.getModuleForName",fdto);

			}else{
				sqlMap.update("module.setModuleFalse", fdto);
				fdto.setM_name(change);
				sqlMap.update("module.changeModule", fdto);
				dto = (FranchiseeModuleDataDTO)sqlMap.queryForObject("module.getModuleForName",fdto);
			}
			StringBuffer module = new StringBuffer();
			module.append(dto.getModule());
			model.addAttribute("module", module.toString());
			StringBuffer menu = new StringBuffer();
			menu.append(dto.getMenu());
			model.addAttribute("menu", menu.toString());
			
		}catch(Exception e){
			
		}
		return "/fxBossERP/fxGetModule";
	}
	
	@RequestMapping("fxSetModule.do")
	public String fxSetModule(Model model){
		String moduleName = (String)sqlMap.queryForObject("module.getOfferMenu", null);
		model.addAttribute("moduleName", moduleName);
		return "/fxBossERP/fxSetModule";
	}
	
	@RequestMapping("fxSetModulePro.do")
	public String fxSetModulePro(FranchiseeModuleDataDTO fdto, Model model){
		sqlMap.update("module.setModuleFalse", fdto);
		sqlMap.update("module.setModule", fdto);
		FranchiseeModuleDataDTO dto = (FranchiseeModuleDataDTO)sqlMap.queryForObject("module.getModule",fdto.getB_key());
		StringBuffer module = new StringBuffer();
		module.append(dto.getModule());
		model.addAttribute("module", module.toString());
		StringBuffer menu = new StringBuffer();
		menu.append(dto.getMenu());
		model.addAttribute("menu", menu.toString());
		return "/fxBossERP/fxGetModule";
	}

	@RequestMapping("fxRemoveModule.do")
	public String fxRemoveModule(FranchiseeModuleDataDTO fdto, Model model){
		sqlMap.delete("module.deleteModule", fdto);
		FranchiseeModuleDataDTO dto = (FranchiseeModuleDataDTO)sqlMap.queryForObject("module.getModule",fdto.getB_key());
		StringBuffer module = new StringBuffer();
		module.append(dto.getModule());
		model.addAttribute("module", module.toString());
		StringBuffer menu = new StringBuffer();
		menu.append(dto.getMenu());
		model.addAttribute("menu", menu.toString());
		return "/fxBossERP/fxGetModule";
	}
}
