package spring.test.bean;

public class EmpDTO {
	int emp_no; //사원번호
	String emp_id; //사원아이디
	String emp_name; //사원이름
	String emp_pwd; //사원비밀번호
	String emp_hiredate; //고용날짜
	String job_name; //직종이름
	String dep_name; //부서이름
	int emp_depno; //부서번호
	int emp_jobno; //직종번호
	int emp_total; //??
	
	
	public String getJob_name() {
		return job_name;
	}

	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}

	public String getDep_name() {
		return dep_name;
	}

	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}


	
	public int getEmp_depno() {
		return emp_depno;
	}

	public void setEmp_depno(int emp_depno) {
		this.emp_depno = emp_depno;
	}

	public EmpDTO() {}

	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_pwd() {
		return emp_pwd;
	}

	public void setEmp_pwd(String emp_pwd) {
		this.emp_pwd = emp_pwd;
	}

	public String getEmp_hiredate() {
		return emp_hiredate;
	}

	public void setEmp_hiredate(String emp_hiredate) {
		this.emp_hiredate = emp_hiredate;
	}


	public int getEmp_jobno() {
		return emp_jobno;
	}

	public void setEmp_jobno(int emp_jobno) {
		this.emp_jobno = emp_jobno;
	}

	public int getEmp_total() {
		return emp_total;
	}

	public void setEmp_total(int emp_total) {
		this.emp_total = emp_total;
	}

	
}
