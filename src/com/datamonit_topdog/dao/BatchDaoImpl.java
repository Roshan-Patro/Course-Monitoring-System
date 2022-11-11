package com.datamonit_topdog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.datamonit_topdog.utility.DBUtil;

public class BatchDaoImpl implements BatchDao {
	public String createBatch(String batchName, int courseId, int facultyId, int numberOfStudents, String batchStartDate, int durationInMonths) {
		String message = "Batch creation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into batch(batchName,courseId,facultyId,numberOfStudents,batchStartDate,durationInMonths) values(?,?,?,?,?,?)");
			ps.setString(1, batchName);
			ps.setInt(2, courseId);
			ps.setInt(3, facultyId);
			ps.setInt(4, numberOfStudents);
			ps.setString(5, batchStartDate);
			ps.setInt(6, durationInMonths);
			
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
