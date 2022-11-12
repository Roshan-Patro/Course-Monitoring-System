package com.datamonit_topdog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.datamonit_topdog.utility.DBUtil;

public class FacultyUsernamePasswordDaoImpl implements FacultyUsernamePasswordDao {

	@Override
	public String createUsernamePassword(int facultyId, String Username, String Password) {
		String message = "Username and password creation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into FacultyUsernamePassword(facultyid,username,password) values(?,?,?)");
			ps.setInt(1, facultyId);
			ps.setString(2, Username);
			ps.setString(3, Password);
			
			int x = ps.executeUpdate();
			if(x>0) {
				message = x+" records inserted susccessfully.";
			}
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

}
