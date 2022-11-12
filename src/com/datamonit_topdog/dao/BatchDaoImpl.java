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

	@Override
	public String updateBatchNameUsingBatchId(int batchId, String batchName) {
		String message = "Batch name updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update batch set batchname = ? where batchid = ?");
			ps.setString(1, batchName);
			ps.setInt(2, batchId);
			
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
	public String updateBatchNameUsingBatchName(String batchName, String newBatchName) {
		String message = "Batch name updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update batch set batchname = ? where batchname = ?");
			ps.setString(1, newBatchName);
			ps.setString(2, batchName);
			
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
	public String updateFacultyIdUsingBatchId(int batchId, int facultyId) {
		String message = "Faculty id updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update batch set facultyid = ? where batchid = ?");
			ps.setInt(1, facultyId);
			ps.setInt(2, batchId);
			
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
	public String updateFacultyIdUsingBatchName(String batchName, int facultyId) {
		String message = "Faculty id updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update batch set facultyid = ? where batchname = ?");
			ps.setInt(1, facultyId);
			ps.setString(2, batchName);
			
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
	public String updateNumberOfStudentsUsingBatchId(int batchId, int numberOfStudents) {
		String message = "number of students updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update batch set numberofstudents = ? where batchid = ?");
			ps.setInt(1, numberOfStudents);
			ps.setInt(2, batchId);
			
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
	public String updateNumberOfStudentsUsingBatchName(String batchName, int numberOfStudents) {
		String message = "number of students updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update batch set numberofstudents = ? where batchname = ?");
			ps.setInt(1, numberOfStudents);
			ps.setString(2, batchName);
			
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
	public String updateBatchStartDateUsingBatchId(int batchId, String batchStartDate) {
		String message = "batch start date updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update batch set batchstartdate = ? where batchid = ?");
			ps.setString(1, batchStartDate);
			ps.setInt(2, batchId);
			
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
	public String updateBatchStartDateUsingBatchName(String batchName, String batchStartDate) {
		String message = "batch start date updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update batch set batchstartdate = ? where batchname = ?");
			ps.setString(1, batchStartDate);
			ps.setString(2, batchName);
			
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
	public String updateDurationInMonthsUsingBatchId(int batchId, int durationInMonths) {
		String message = "duration in months updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update batch set durationInMonths = ? where batchid = ?");
			ps.setInt(1, durationInMonths);
			ps.setInt(2, batchId);
			
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
	public String updateDurationInMonthsUsingBatchName(String batchName, int durationInMonths) {
		String message = "duration in months updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update batch set durationInMonths = ? where batchname = ?");
			ps.setInt(1, durationInMonths);
			ps.setString(2, batchName);
			
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
