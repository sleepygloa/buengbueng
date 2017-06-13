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

			a = ((int)(Math.random() * 10) + 1); 
			if(a == 0){
				a = 1;
			}
			
			for(int j = 1; j < 9; j++){
				for(int i = 1; i < 10; i ++){
					b = ((int)(Math.random() * 10) + 1);
					b = (b * i * a) + 1 ;
				}		
				b = b % 16;
					if(b == 0){
						b = ((int)(Math.random() * 10) + 1);
						b = (b * a) % 7 + 2;
					}
					
				random += Integer.toHexString(b);
			}
			
			//라이센스키 중복검사 중복된키일경우, 한번더.
			check = (Integer)sqlMap.queryForObject("superClass.licenseKeyDuplicateInspection", random);
			}while(check == 1);
			//--- 변수 들기 끝
			
			return random;
		}

	}
