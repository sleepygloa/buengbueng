package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ConnectServer {
	// param = 요청할 파라미터의 정보 입력
	// urlInfo = 요청 주소
	public static JSONObject connect(String param, String urlInfo){
		JSONObject jsonObj = null;
		try {
			// URL클래스의 생성자로 주소를 넘겨줌
			URL url = new URL(urlInfo);
			// 해당 주소의 페이지로 접속을 하고, 단일 HTTP 접속을 하기 위해 캐스?마
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			// OutputStream으로 POST 데이터를 넘겨주겠다는 옵션 정의
			conn.setDoOutput(true);
			// POST방식으로 요청
			conn.setRequestMethod("POST");
			// OutputStream에 요청할 OutpuStream을 넣음
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
			// 메세지로 작성된 파라미터 정보를 바이트 단위로 요청
			out.write(param);
			// 스트림의 버퍼를 비움
			out.flush();

			// 응답받은 메세지의 길이만큼 버퍼를 생성하여 읽고, "UTF-8"로 디코딩해서 읽어들임
			BufferedReader br = new BufferedReader( new InputStreamReader( conn.getInputStream(), "UTF-8" ), conn.getContentLength());
			String buf;
			StringBuffer json = new StringBuffer();
			// 한 라인씩 읽음
			while( ( buf = br.readLine() ) != null ) {
				json.append(buf);
			}
			// 스트림 닫음
			out.close();
			br.close();
			
			// 서버에서 전달해준 String을 JSON으로 변경 후 JSON에서 값 꺼내서 사용
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(json.toString());
			jsonObj = (JSONObject)obj;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObj;
	}
	
}
