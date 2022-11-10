package com.datamonit_topdog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.datamonit_topdog.utility.DBUtil;

public class FacultyDaoImpl implements FacultyDao {
	
	public String registerFaculty(String facultyname, String facultyaddress, long mobile, String email, String username, String password) {
		String message = "Faculty registration failed...";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into faculty(facultyname,facultyaddress,mobile,email,username,password) values(?,?,?,?,?,?)");
			ps.setString(1, facultyname);
			ps.setString(2, facultyaddress);
			ps.setLong(3, mobile);
			ps.setString(4, email);
			ps.setString(5, username);
			ps.setString(6, password);
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = x+" record(s) inserted";
			}
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

}
