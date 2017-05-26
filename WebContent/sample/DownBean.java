package sample;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownBean {
	
	@RequestMapping("down.do")
	public ModelAndView down(String name){
		File down = new File("d://save//"+name);
		ModelAndView mv = new ModelAndView("download", "downloadFile", down);
		//ModelAndView(사용할빈의 이름, 파라미터이름, 보낼파일) 
//		mv.addObject("id", id); //request.setAttribute()
		return mv;
	}
	
}
