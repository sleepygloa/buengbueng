package manage.admin.bean;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatbotListBean extends BoardMethodBean {
	@Autowired
	private SqlMapClientTemplate  sqlMap;
	
	/* DB에 저장한 챗봇 질답 리스트 출력 페이지 */
	@RequestMapping("chatbotList.do")
	public String chatbotList(Model model,HttpServletRequest request){
		Alarm(request);
		ArrayList<ChattingDto> dto = (ArrayList)sqlMap.queryForList("chatbot.getChats", null);
		// answer의 구분자(/%/)를 줄바꿈으로 바꿔서 다시 저장 -> 출력 시 답변별로 줄바꿈 되도록
		for(int i=0; i<dto.size(); i++){
			dto.get(i).setAnswer(dto.get(i).getAnswer().replaceAll("/%/", "<br/>"));
		}
		model.addAttribute("chatbot", dto);
		if(dto.size() != 0){
			model.addAttribute("max", dto.get(dto.size()-1).getQuestionNum());
		}else{
			model.addAttribute("max", 0);
		}
		return "/chatbot/chatbotList";
	}
	
	/* 챗봇 질답 추가 페이지 */
	@RequestMapping("addChat.do")
	public String addChat(int max, Model model,HttpServletRequest request){
		Alarm(request);
		model.addAttribute("max", max);
		return "/chatbot/addChat";
	}
	
	/* DB에 새로운 챗봇 질답을 추가*/
	@RequestMapping("addChatPro.do")
	public String addChatPro(ChattingDto dto, HttpServletRequest request){
		Alarm(request);
		try{
			int answerNum = Integer.parseInt(request.getParameter("answerNum"));
			if(answerNum != 0){
				StringBuffer answer  = new StringBuffer(dto.getAnswer());
				for(int i = 0; i< answerNum; i++){
					if(i != answerNum && request.getParameter("answer"+(i))!=null){
						answer.append("/%/");
					}if(request.getParameter("answer"+(i))!=null){
						answer.append(request.getParameter("answer"+i));
					}
				}
				dto.setAnswer(answer.toString());
			}
			sqlMap.insert("chatbot.addChat", dto);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect: chatbotList.do";
	}
	
	/* DB에 저장된 챗봇 질답을 삭제하는 페이지 */
	@RequestMapping("removeChat.do")
	public String removeChat(int questionNum,HttpServletRequest request){
		Alarm(request);
		try{
			sqlMap.delete("chatbot.removeChat", questionNum);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect: chatbotList.do";
	}
	
	/* DB에 저장된 챗봇 질답을 수정하는 페이지 1 */
	@RequestMapping("modifyChat.do")
	public String modifyChat(int questionNum, Model model,HttpServletRequest request){
		Alarm(request);
		try{
			ChattingDto dto = (ChattingDto)sqlMap.queryForObject("chatbot.getChat", questionNum);
			// answer의 구분자(/%/)를 줄바꿈으로 바꿔서 다시 저장 -> 출력 시 답변별로 줄바꿈 되도록
			//dto.setAnswer(dto.getAnswer().replaceAll("/%/", "<br/>"));
			String[] answer = (dto.getAnswer()).split("/%/");
			model.addAttribute("chatbot", dto);
			model.addAttribute("answer", answer);
			model.addAttribute("max", answer.length);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/chatbot/modifyChat";
	}
	
	/* DB에 저장된 챗봇 질답을 수정하는 페이지 2 (DB 사용) */
	@RequestMapping("modifyChatPro.do")
	public String modifyChatPro(ChattingDto dto, HttpServletRequest request){
		Alarm(request);
		try{
			StringBuffer answer = new StringBuffer();
			int max = Integer.parseInt(request.getParameter("answerNum"));
			for(int i=0; i<max ;i++){
				if(request.getParameter("answer"+(i))!=null){
					answer.append(request.getParameter("answer"+i));
					if(i != max-1){
						answer.append("/%/");
					}
				}
			}
			dto.setAnswer(answer.toString());
			sqlMap.update("chatbot.updateChat", dto);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect: chatbotList.do";
	}
	
	@RequestMapping("chatting.do")
	public String test(Model model,HttpServletRequest request){
		Alarm(request);
		ArrayList<ChattingLogDto> dto = (ArrayList)sqlMap.queryForList("chatbot.getChatlog", null);
		model.addAttribute("dto", dto);
		return "/chatbot/chatting";
	}
}
