package com.datamonit_topdog.models;

public class Faculty {
	private int facultyid;
	private String facultyname;
	private String facultyaddress;
	private long mobile;
	private String email;
	
	public Faculty() {
		
	}

	public Faculty(int facultyid, String facultyname, String facultyaddress, long mobile, String email) {
		super();
		this.facultyid = facultyid;
		this.facultyname = facultyname;
		this.facultyaddress = facultyaddress;
		this.mobile = mobile;
		this.email = email;
	}

	public int getFacultyid() {
		return facultyid;
	}

	public void setFacultyid(int facultyid) {
		this.facultyid = facultyid;
	}

	public String getFacultyname() {
		return facultyname;
	}

	public void setFacultyname(String facultyname) {
		this.facultyname = facultyname;
	}

	public String getFacultyaddress() {
		return facultyaddress;
	}

	public void setFacultyaddress(String facultyaddress) {
		this.facultyaddress = facultyaddress;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Faculty [facultyid=" + facultyid + ", facultyname=" + facultyname + ", facultyaddress=" + facultyaddress
				+ ", mobile=" + mobile + ", email=" + email + "]";
	}

	
	
	
}
