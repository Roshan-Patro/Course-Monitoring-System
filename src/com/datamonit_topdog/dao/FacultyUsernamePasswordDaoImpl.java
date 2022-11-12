package com.datamonit_topdog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.datamonit_topdog.exceptions.FacultyUserNamePasswordException;
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

	@Override
	public String userLogin(String username, String password) throws FacultyUserNamePasswordException {
		String message = "Invalid details provided...";
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select facultyid from facultyusernamepassword where username = ? AND password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				message = "Login successful.";
			}
			else {
				throw new FacultyUserNamePasswordException(message);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyUserNamePasswordException(e.getMessage());
		}
		
		return message;
	}

}
