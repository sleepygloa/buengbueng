package superclass.all.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class Random {

		//sql을 연결 시켜주는 변수
		@Autowired
		private SqlMapClientTemplate sqlMap;
		
		public String random() {
			//랜덤 수를 구해서 임의의 수를 곱한다.
			//그결과를 16으로 나누어 나머지를 구한다 (0~15)
			//나머지를 String에 차례대로 8번 더하여 8자리 16진수 코드를 만든다.
			int check = 0;
			String random = "";
			int a = 1; //0이면 연산시 수가 0이되어버림.
			int b = 1;
			
			do{
			
			random = ""; a = 1; b = 1;

			a = ((int)(Math.random() * 10) + 1); // 1~10까지의 랜덤 수를 구한다.
			if(a == 0){
				a = 1; //a 가 혹시라도 0 일때 1이라고 지칭한다.
			}
			
			for(int j = 1; j < 9; j++){
				for(int i = 1; i < 10; i ++){
					b = ((int)(Math.random() * 10) + 1); // b 또한 1~10까지의 랜덤 수를 구하고,
					b = (b * i * a) + 1 ; //랜덤한 수를 만들기 위해, 랜덤 b, 증가하는 i(정해진값), 랜덤 a값을 곱하고 1을 더하는 행위를 반복한다.
				}		
				b = b % 16; //이 수를 16진수로 표현하기 위해, 16으로나눈 나머지를 구한다.
					if(b == 0){ //이때 나머지 b가 0 이라면,
						b = ((int)(Math.random() * 10) + 1); //b의 랜덤수를 구한다 1~10
						b = (b * a) % 16 + 2; //또한 16으로 나눈나머지에 변동을 주기 위해 +2를 더한다.
					}
					
				random += Integer.toHexString(b); // 구한 값을 차례대로 8번 저장한다.
			}
			
			//라이센스키 중복검사 중복된키일경우, 한번더.
			check = (Integer)sqlMap.queryForObject("superClass.licenseKeyDuplicateInspection", random);
			}while(check == 1);
			//--- 변수 들기 끝
			
			return random;
		}

	}
