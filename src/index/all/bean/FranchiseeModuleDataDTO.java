package index.all.bean;

import java.sql.Timestamp;

public class FranchiseeModuleDataDTO {
	private String b_key;
	private String m_name;
	private String module;
	private String menu;
	private boolean m_check;
	private Timestamp time;
	public String getB_key() {
		return b_key;
	}
	public void setB_key(String b_key) {
		this.b_key = b_key;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public boolean isM_check() {
		return m_check;
	}
	public void setM_check(boolean m_check) {
		this.m_check = m_check;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}

	
}
