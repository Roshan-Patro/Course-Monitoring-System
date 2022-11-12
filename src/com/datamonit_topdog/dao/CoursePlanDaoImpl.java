package com.datamonit_topdog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.datamonit_topdog.exceptions.BatchException;
import com.datamonit_topdog.exceptions.CoursePlanException;
import com.datamonit_topdog.models.Batch;
import com.datamonit_topdog.models.CoursePlan;
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

	@Override
	public List<CoursePlan> getAllCoursePlanDetails() throws CoursePlanException {
		List<CoursePlan> coursePlanList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from courseplan");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int pi = rs.getInt("planid");
				int ci = rs.getInt("courseid");
				int bi = rs.getInt("batchid");
				int dno = rs.getInt("daynumber");
				String t = rs.getString("topic");
				String stat = rs.getString("status");
				
				CoursePlan cp = new CoursePlan(pi,ci,bi,dno,t,stat);
				
				coursePlanList.add(cp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		
		if(coursePlanList.size() == 0) {
			throw new CoursePlanException("No batch found.");
		}
		
		
		return coursePlanList;
	}

	@Override
	public List<CoursePlan> getAllCoursePlansOfACourse(int courseId) throws CoursePlanException {
		List<CoursePlan> coursePlanList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from courseplan where courseid = ?");
			ps.setInt(1, courseId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int pi = rs.getInt("planid");
				int ci = rs.getInt("courseid");
				int bi = rs.getInt("batchid");
				int dno = rs.getInt("daynumber");
				String t = rs.getString("topic");
				String stat = rs.getString("status");
				
				CoursePlan cp = new CoursePlan(pi,ci,bi,dno,t,stat);
				coursePlanList.add(cp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		
		if(coursePlanList.size()==0) {
			throw new CoursePlanException("No course plan found.");
		}
		return coursePlanList;
	}

	@Override
	public CoursePlan getACoursePlanByPlanId(int planId) throws CoursePlanException {
		CoursePlan cp = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from courseplan where planid = ?");
			ps.setInt(1, planId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int pi = rs.getInt("planid");
				int ci = rs.getInt("courseid");
				int bi = rs.getInt("batchid");
				int dno = rs.getInt("daynumber");
				String t = rs.getString("topic");
				String stat = rs.getString("status");
				
				cp = new CoursePlan(pi,ci,bi,dno,t,stat);
			}
			else {
				throw new CoursePlanException("No course plan found.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		
		
		return cp;
	}

	@Override
	public List<CoursePlan> getAllCoursePlansByStatus(String status) throws CoursePlanException {
		List<CoursePlan> coursePlanList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from courseplan where status = ?");
			ps.setString(1, status);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int pi = rs.getInt("planid");
				int ci = rs.getInt("courseid");
				int bi = rs.getInt("batchid");
				int dno = rs.getInt("daynumber");
				String t = rs.getString("topic");
				String stat = rs.getString("status");
				
				CoursePlan cp = new CoursePlan(pi,ci,bi,dno,t,stat);
				coursePlanList.add(cp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		
		if(coursePlanList.size()==0) {
			throw new CoursePlanException("No course plan found.");
		}
		return coursePlanList;
	}

}
