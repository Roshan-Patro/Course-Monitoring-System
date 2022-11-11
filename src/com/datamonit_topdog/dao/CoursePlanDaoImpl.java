package com.datamonit_topdog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.datamonit_topdog.utility.DBUtil;

public class CoursePlanDaoImpl implements CoursePlanDao {

	@Override
	public String createCoursePlan(int courseId, int batchId, int daynumber, String topic, String status) {
		String message = "Course creation failed..";
				
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into courseplan(courseid,batchid,daynumber,topic,status) values(?,?,?,?,?)");
			ps.setInt(1, courseId);
			ps.setInt(2, batchId);
			ps.setInt(3, daynumber);
			ps.setString(4, topic);
			ps.setString(5, status);
			
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