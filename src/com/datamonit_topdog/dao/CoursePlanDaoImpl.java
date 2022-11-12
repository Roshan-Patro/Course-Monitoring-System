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

	@Override
	public String updateCourseIdUsingPlanId(int planId, int courseId) {
		String message = "CourseId updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update courseplan set courseid = ? where planid = ?");
			ps.setInt(1, courseId);
			ps.setInt(2, planId);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = x+" records updated.";
			}
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

	@Override
	public String updateBatchIdUsingPlanId(int planId, int batchId) {
		String message = "BatchId updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update courseplan set batchid = ? where planid = ?");
			ps.setInt(1, batchId);
			ps.setInt(2, planId);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = x+" records updated.";
			}
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

	@Override
	public String updateDayNumberUsingPlanId(int planId, int dayNumber) {
		String message = "Day number updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update courseplan set daynumber = ? where planid = ?");
			ps.setInt(1, dayNumber);
			ps.setInt(2, planId);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = x+" records updated.";
			}
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

	@Override
	public String updateTopicUsingPlanId(int planId, String newTopic) {
		String message = "Topic updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update courseplan set topic = ? where planid = ?");
			ps.setString(1, newTopic);
			ps.setInt(2, planId);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = x+" records updated.";
			}
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

	@Override
	public String updateStatusUsingPlanId(int planId, String newStatus) {
		String message = "Status updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update courseplan set status = ? where planid = ?");
			ps.setString(1, newStatus);
			ps.setInt(2, planId);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = x+" records updated.";
			}
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

}
