package superclass.all.bean;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;

import manage.boss.bean.FranchiseeDataDTO;

@Controller
public class ReadDbWriteArray {

	@Autowired
	private	SqlMapClientTemplate sqlMap;
	
	@Autowired
	public NowDate nowdate;
	
	public  void readDb(Object dto, String fileName, String fileCheck)throws IOException {
		////////////////////////////////
		//각 Log의 TEXT파일의 Line 수를 세는 코드
		File file = new File("..\\..\\workspace\\buengbueng");
//		File file = new File("C:\\Users\\KO\\Documents\\eclipse\\Spring\\buengbueng");
		String totalFileName = 
				"" + file.getCanonicalPath() + 
				"\\WebContent\\log"+ fileName;
		
		 InputStream is = new BufferedInputStream(new FileInputStream(totalFileName));
		 int count = 0;
		    try {
		        byte[] c = new byte[1024];
		        
		        int readChars = 0;
		        boolean empty = true;
		        while ((readChars = is.read(c)) != -1) {
		        	System.out.println(readChars);
		            empty = false;
		            for (int i = 0; i < readChars; ++i) {
		                if (c[i] == '\n') {
		                    ++count;
		                    System.out.println(count);
		                }
		            }
		        }
		        if (count == 0 && !empty) { count = 1;}else{ }
		    } finally {
		        is.close();
		    }
		
		//////////////////////////////////////////////////////
		//라인수와 DTO를 받아 테스트파일안에 다음줄에 입력해 주는 코드
		String content = "";

		//현재시각 불러오기
		String nowDate = NowDate.nowDate();
		
		//////////////////////////////////////
		FranchiseeDataDTO DTO =  (FranchiseeDataDTO)dto ;
		/////////////////////////////////////
		
		content += "{";
		switch (fileCheck){
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		case "franchisee" : 
			content += count +","+ DTO.getB_id() +","+ DTO.getB_key() +","+ DTO.getB_name() +","+ DTO.getB_number() +","+ DTO.getB_pccount() +","+ DTO.getB_address() +","+ DTO.getB_pccount() +","+ DTO.getB_size() +","+ DTO.getB_tel() +","+ DTO.getB_ip()+","+nowDate;
		case "franchiseeUpdate" :
			content += count +","+ DTO.getB_id() +","+ DTO.getB_key() +","+ DTO.getB_name() +","+ DTO.getB_number() +","+ DTO.getB_pccount() +","+ DTO.getB_address() +","+ DTO.getB_pccount() +","+ DTO.getB_size() +","+ DTO.getB_tel() +","+ DTO.getB_ip()+","+nowDate;
		case "franchiseeDelete" :
			content += count +","+ DTO.getB_id() +","+ DTO.getB_key() +","+ DTO.getReason() +","+ nowDate;
			
		}
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		content += "}" ;
		
		File inFile = new File(totalFileName);
		BufferedWriter bw = null;
		try{
			bw = new BufferedWriter(new FileWriter(inFile,true));
			bw.write(content);
			bw.newLine();
			bw.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(bw != null) try{ bw.close(); }catch(IOException e){}
		}
		
	} 
	
}
