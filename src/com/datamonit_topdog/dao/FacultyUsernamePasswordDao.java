package com.datamonit_topdog.dao;

import com.datamonit_topdog.exceptions.FacultyUserNamePasswordException;

public interface FacultyUsernamePasswordDao {
	public String createUsernamePassword(int facultyId, String Username, String Password);
	
	public String userLogin(String username, String password) throws FacultyUserNamePasswordException;
	
}
