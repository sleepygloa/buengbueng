package manage.admin.bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		String pageNum=request.getParameter("pageNum");
		int count = 0;
		int pageSize = 10;
		if(pageNum==null){pageNum="1";}
		
		ArrayList<ChattingLogDto> ldto = (ArrayList)sqlMap.queryForList("chatbot.newChatLog", null);
		count=ldto.size();
		int pageCount = count / pageSize + (count%pageSize == 0? 0:1);
		
		int startPage = ((Integer.parseInt(pageNum)-1)/10)*10+1;
		int pageBlock = 10;
		int endPage = startPage + pageBlock - 1;
		if(endPage > pageCount){endPage = pageCount;}
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);	
		request.setAttribute("count", count);
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
		
		/* 지우는 거 아님!! - 키워드 테스트 (혜민) */
//		Iterator iterator=keyvalList.iterator();
//		HashMap<String,Integer> result = new HashMap<String,Integer>();
//		for(int i=0; i<keyvalList.size();i++){
//			String keyword = (String)iterator.next();
//			int countNum = (Integer)sqlMap.queryForObject("chatbot.getKeywordList", keyword);
//			result.put(keyword,countNum);
//			System.out.println(keyword+" "+countNum);
//		}
//		
//		ArrayList countList = sortByValue(result);

		request.setAttribute("countList", countList);
		return "/chatbot/chatbotList";
	}
	
	private static ArrayList sortByValue(final HashMap<String, Integer> result) {
		ArrayList<String> list = new ArrayList();
        list.addAll(result.keySet());
         
        Collections.sort(list,new Comparator() {
             
            public int compare(Object o1,Object o2) {
                Object v1 = result.get(o1);
                Object v2 = result.get(o2);
                 
                return ((Comparable) v2).compareTo(v1);
            }
             
        });
//        Collections.reverse(list); // 주석시 오름차순
        return list;
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
	
	// 선호코드추가
	@RequestMapping("chatSituation.do")
	public ModelAndView chatSituation(Model model){
		ModelAndView mv = new ModelAndView();
		InputStreamReader isr = null;
		BufferedReader br = null;
		BufferedReader r = null;
		int nodeExeCheck = 0; //노드가 꺼져있다.
		
		try{//tasklist.exe 는 실행중인 프레세스를 확인하는 파일입니다. cmd에서도 명령어로 확인가능
		   Process p = Runtime.getRuntime().exec(System.getenv("windir")+"\\system32\\"+"tasklist.exe");
		   isr = new InputStreamReader(p.getInputStream());
		   br = new BufferedReader(isr);
		   
		   String line = null;
		   while ((line = br.readLine())!= null) {
			   if(line.contains("node")){//프로세스중 노드가 실행 중인지 확인합니다.
				   nodeExeCheck = 1; //노드가 켜져있다.
			   }
		   }
		  } catch (Exception e) {
		   e.printStackTrace();
		   System.out.println(" 노드 실행시 프로세스 삭제 시 오류 : "+e);
		  } finally {
		   if(isr!=null) try {isr.close(); } catch (IOException e) {}
		   if(br!=null) try { br.close();} catch (IOException e) {}
		   if(r!=null) try { r.close();} catch (IOException e) {}
		  }
		model.addAttribute("nodeExeCheck", nodeExeCheck);
		mv.setViewName("/chatbot/nodeSituation");
		return mv;
	}
	
	//노드 켜기
	@RequestMapping("nodeStart.do")
	public void nodeStart(){
		
		try{
			
			List<String> list = new ArrayList<String>();
			list.add("cmd.exe");
			list.add("/c");
			list.add("supervisor chatServer.js");
//			list.add("dir");
			
			ProcessBuilder pb = new ProcessBuilder(
					list
					);
//			pb.directory(new File("C:\\Users\\user2\\Documents\\workspace\\buengbueng\\WebContent\\Node\\project\\"));
			pb.directory(new File("C:\\Users\\KO\\Documents\\eclipse\\Spring\\buengbueng\\WebContent\\Node\\project\\"));
		       System.out.println(pb.command());
		       pb.redirectErrorStream(true);
		        Process p = pb.start();
		        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		        String line;
		        while(true){
		            line = r.readLine();
		            if(line == null) { break; }
		            System.out.println("line ::"+line);
		        }
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	//노드 끄기
	@RequestMapping("nodeEnd.do")
	public void nodeEnd(){
		
		StringBuffer message = new StringBuffer();
		 InputStreamReader isr = null;
		 BufferedReader br = null;
		
		 try {
			   Process p = Runtime.getRuntime().exec(System.getenv("windir")+"\\system32\\"+"tasklist.exe");
			   isr = new InputStreamReader(p.getInputStream());
			   br = new BufferedReader(isr);
			   
			   String line = null;
			   while ((line = br.readLine())!= null) {
//				System.out.println("msg=>"+line);
				   if(line.contains("node")){
					   System.out.println("노드가 실행 중입니다. 노드를 종료하고 다시 실행 합니다.");
					   
					   List<String> list = new ArrayList<String>();
						list.add("cmd.exe");
						list.add("/c");
						list.add("taskkill /F /IM node.exe");
						
						ProcessBuilder pb = new ProcessBuilder(
								list
								);
					       System.out.println(pb.command());
					       pb.redirectErrorStream(true);
					        Process p2 = pb.start();
					        BufferedReader r = new BufferedReader(new InputStreamReader(p2.getInputStream()));
					        String line2;
					        while(true){
					            line2 = r.readLine();
					            if(line2 == null) { break; }
					            System.out.println("line : "+line2);
					        } 
					   
				   }
			   }
		  } catch (IOException e) {
				 e.printStackTrace();
		  } finally {
				 if(isr!=null) try {isr.close(); } catch (IOException e) {}
				 if(br!=null) try { br.close();} catch (IOException e) {}
		  }	
	
	}
}
