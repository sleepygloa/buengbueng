package pc.materials.bean;

import java.sql.Timestamp;

public class PcInfoModifyLogDataDTO {

	private int num;
	private String b_key;
	private int c_code;
	private int m_code;
	private int k_code;
	private int mo_code;
	private int s_code;
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
	public int getC_code() {
		return c_code;
	}
	public void setC_code(int c_code) {
		this.c_code = c_code;
	}
	public int getM_code() {
		return m_code;
	}
	public void setM_code(int m_code) {
		this.m_code = m_code;
	}
	public int getK_code() {
		return k_code;
	}
	public void setK_code(int k_code) {
		this.k_code = k_code;
	}
	public int getMo_code() {
		return mo_code;
	}
	public void setMo_code(int mo_code) {
		this.mo_code = mo_code;
	}
	public int getS_code() {
		return s_code;
	}
	public void setS_code(int s_code) {
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
