package fx.user.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import manage.boss.bean.SeatStateDataDTO;

@Controller
public class FxBossERPBean {
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("fxGetPcUseState.do")
	public String fxGetPcUseState(String b_key, Model model){
		SeatStateDataDTO sdto = (SeatStateDataDTO)sqlMap.queryForObject("bossERP.getSeatCount", b_key);
		int pcCount = (Integer)sqlMap.queryForObject("bossERP.getPcCount", b_key);
		model.addAttribute("count",pcCount);
		if(sdto != null){
			model.addAttribute("seatCon",sdto.getSeatCheck());
		}
		return "/fxBossERP/fxGetPcUseState";
	}
}
