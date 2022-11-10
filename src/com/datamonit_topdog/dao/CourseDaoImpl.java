package com.datamonit_topdog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.datamonit_topdog.utility.DBUtil;

public class CourseDaoImpl implements CourseDao {

	@Override
	public String createCourse(String courseName, int fee, String courseDescription) {
		String message = "Course creation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into Course(coursename,fee,coursedescription) values(?,?,?)");
			ps.setString(1, courseName);
			ps.setInt(2, fee);
			ps.setString(3, courseDescription);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = x+" records inserted.";
			}
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}
	

}
