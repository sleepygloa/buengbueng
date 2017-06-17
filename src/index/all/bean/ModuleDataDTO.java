package index.all.bean;

import java.sql.Timestamp;

public class ModuleDataDTO {

	private int num;
	private String moduleName;
	private int moduleCount;
	private Timestamp time;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public int getModuleCount() {
		return moduleCount;
	}
	public void setModuleCount(int moduleCount) {
		this.moduleCount = moduleCount;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	
}
