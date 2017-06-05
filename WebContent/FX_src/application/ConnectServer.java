package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ConnectServer {
	// param = ��û�� �Ķ������ ���� �Է�
	// urlInfo = ��û �ּ�
	public static JSONObject connect(String param, String urlInfo){
		JSONObject jsonObj = null;
		try {
			// URLŬ������ �����ڷ� �ּҸ� �Ѱ���
			URL url = new URL(urlInfo);
			// �ش� �ּ��� �������� ������ �ϰ�, ���� HTTP ������ �ϱ� ���� ĳ������
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			// OutputStream���� POST �����͸� �Ѱ��ְڴٴ� �ɼ� ����
			conn.setDoOutput(true);
			// POST������� ��û
			conn.setRequestMethod("POST");
			// OutputStream�� ��û�� OutpuStream�� ����
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
			// �޼����� �ۼ��� �Ķ���� ������ ����Ʈ ������ ��û
			out.write(param);
			// ��Ʈ���� ���۸� ���
			out.flush();

			// ������� �޼����� ���̸�ŭ ���۸� �����Ͽ� �а�, "UTF-8"�� ���ڵ��ؼ� �о����
			BufferedReader br = new BufferedReader( new InputStreamReader( conn.getInputStream(), "UTF-8" ), conn.getContentLength());
			String buf;
			StringBuffer json = new StringBuffer();
			// �� ���ξ� ����
			while( ( buf = br.readLine() ) != null ) {
				json.append(buf);
			}
			// ��Ʈ�� ����
			out.close();
			br.close();
			
			// �������� �������� String�� JSON���� ���� �� JSON���� �� ������ ���
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
