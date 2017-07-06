package pc.materials.bean;

import java.sql.Timestamp;

public class PcInfoModifyLogDataDTO {

	private int num;
	private String b_key;
	private String c_code;
	private String m_code;
	private String k_code;
	private String mo_code;
	private String s_code;
	private String os;
	private String ip;
	private Timestamp time;
	private String what;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getB_key() {
		return b_key;
	}
	public void setB_key(String b_key) {
		this.b_key = b_key;
	}
	public String getC_code() {
		return c_code;
	}
	public void setC_code(String c_code) {
		this.c_code = c_code;
	}
	public String getM_code() {
		return m_code;
	}
	public void setM_code(String m_code) {
		this.m_code = m_code;
	}
	public String getK_code() {
		return k_code;
	}
	public void setK_code(String k_code) {
		this.k_code = k_code;
	}
	public String getMo_code() {
		return mo_code;
	}
	public void setMo_code(String mo_code) {
		this.mo_code = mo_code;
	}
	public String getS_code() {
		return s_code;
	}
	public void setS_code(String s_code) {
		this.s_code = s_code;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getWhat() {
		return what;
	}
	public void setWhat(String what) {
		this.what = what;
	}
	
}
