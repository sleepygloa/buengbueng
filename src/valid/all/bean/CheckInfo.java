package valid.all.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;

import login.user.bean.UserInfoDataDTO;


@Controller
public class CheckInfo {

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	//아이디 검사
	public int idCheck(String id){
		//유효성 검사 상황을 나타내는 변수
		int validCheck = -1;
		
		// 파라메터로 받은 id가 DB에 저장되어 있는지 확인
		int result = (Integer)sqlMap.queryForObject("checkInfo.validIDCheck", id);
		
		if(result == 0){
			validCheck = 2; // 아이디 없음
		}else{
			validCheck = 1; // 아이디 있음
		}
		
		return validCheck;
	}
	
	//비밀번호검사
	public int pwCheck(UserInfoDataDTO dto){
		//유효성 검사 상황을 나타내는 변수
		int validCheck = -1;
		
		//유효성 검사할 변수
		String pw = dto.getPw();
		
		//유효성검사에 필요한 정보를 받아낼 Key 변수
		String id = dto.getId();
		
		//아이디를 불러와서 각각의 변수로 저장
		dto = (UserInfoDataDTO)sqlMap.queryForObject("checkInfo.validCheck", dto);
		String dbId = dto.getId();
		String dbPw = dto.getPw();
		
		if(!pw.equals(dbPw)){
			validCheck = 2; // 실패
		}else{
			validCheck = 1; // 성공
		}
		
		return validCheck;
	}
	
	
	//아이디와 비밀번호 검사
	
	
	
}
