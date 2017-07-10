package manage.boss.bean;

import java.io.File;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SetupDownBean {
	@RequestMapping("down.do")
	public ModelAndView down(String fileName){
		File down = new File(this.getClass().getResource("/").getPath()+"\\setup\\"+fileName+".exe");
		ModelAndView mv = new ModelAndView("download","downloadFile",down);
		return mv;
	}
}