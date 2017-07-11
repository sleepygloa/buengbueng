package manage.admin.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

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
		// 질문 리스트 출력
		//최신 3일간 질문 
		ArrayList<ChattingLogDto> ldto = (ArrayList)sqlMap.queryForList("chatbot.newChatLog", null);
		request.setAttribute("ldto", ldto);
		
		//답변할 수 없는 질문
		ArrayList<ChattingLogDto> ldto2 = (ArrayList)sqlMap.queryForList("chatbot.noReChatLog", null);
		request.setAttribute("ldto2", ldto2);
		
		//키워드 검색순
		ArrayList<ChattingLogDto> ldto3 = (ArrayList)sqlMap.queryForList("chatbot.chatLogKeyword", null);
		ArrayList keyList = new ArrayList();
		TreeSet keyvalList = new TreeSet();
		String[] keyval = null;
		
		for(int i =0 ; i < ldto3.size() ; i++){
				String strKey = ((ChattingLogDto)ldto3.get(i)).getKeyword();
				keyval= strKey.split(",|_");
				for(int ii =0 ; ii < keyval.length ; ii++){
					keyList.add(keyval[ii]);
					keyvalList.add(keyval[ii]); // 중복값 제거 후 정렬한 리스트
				}
			}
		Collections.sort(keyList); // 중복값 제거하지 않은 상태의 정렬한 리스트
		Iterator iterator=keyvalList.iterator();	
		ArrayList countList=new ArrayList();
		for(int i=0; i<keyvalList.size();i++){
			int check=0;
			String key = (String)iterator.next(); // 검색 키워드 하나씩 추출
			for(int ii=0;ii<keyList.size();ii++){
				String subkey = (String)keyList.get(ii);
				if(subkey.equals(key)){
					check += 1;					
				}else{
					continue;
				}
			}
			String sumResult= "count:"+check+",keyword:"+key;
			countList.add(sumResult);
		}
		Collections.sort(countList);  // 정렬
		Collections.reverse(countList); // 정렬후 역순으로 정렬 ( 이렇게 안하면 순서 이상해짐)

		request.setAttribute("countList", countList);
		return "/chatbot/chatbotList";
	}
	
	private void reverseArrayInt(ArrayList countList) {
		// TODO Auto-generated method stub
		
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
