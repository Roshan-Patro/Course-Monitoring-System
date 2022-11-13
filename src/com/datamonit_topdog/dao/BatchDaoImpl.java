package com.datamonit_topdog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.datamonit_topdog.exceptions.BatchException;
import com.datamonit_topdog.exceptions.CoursePlanException;
import com.datamonit_topdog.exceptions.FacultyException;
import com.datamonit_topdog.models.Batch;
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

	@Override
	public List<Batch> getAllBatchDetails() throws BatchException {
		List<Batch> batchList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from batch");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int bi = rs.getInt("batchid");
				String bn = rs.getString("batchname");
				int ci = rs.getInt("courseid");
				int fi = rs.getInt("facultyid");
				int nos = rs.getInt("numberofstudents");
				String bsd = rs.getString("batchstartdate");
				int dim = rs.getInt("durationinmonths");
				
				Batch batch = new Batch(bi,bn,ci,fi,nos,bsd,dim);
				
				batchList.add(batch);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		
		if(batchList.size() == 0) {
			throw new BatchException("No batch found.");
		}
		
		
		return batchList;
	}

	@Override
	public Batch getBatchByBatchId(int batchId) throws BatchException {
		Batch batch = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from batch where batchid = ?");
			ps.setInt(1, batchId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int bi = rs.getInt("batchid");
				String bn = rs.getString("batchname");
				int ci = rs.getInt("courseid");
				int fi = rs.getInt("facultyid");
				int nos = rs.getInt("numberofstudents");
				String bsd = rs.getString("batchstartdate");
				int dim = rs.getInt("durationinmonths");
				
				batch = new Batch(bi,bn,ci,fi,nos,bsd,dim);
			}
			else {
				throw new BatchException("NO batch found with the id: "+batchId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		
		return batch;
	}

	@Override
	public Batch getBatchByBatchName(String batchName) throws BatchException {
		Batch batch = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from batch where batchname = ?");
			ps.setString(1, batchName);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int bi = rs.getInt("batchid");
				String bn = rs.getString("batchname");
				int ci = rs.getInt("courseid");
				int fi = rs.getInt("facultyid");
				int nos = rs.getInt("numberofstudents");
				String bsd = rs.getString("batchstartdate");
				int dim = rs.getInt("durationinmonths");
				
				batch = new Batch(bi,bn,ci,fi,nos,bsd,dim);
			}
			else {
				throw new BatchException("NO batch found with the name: "+batchName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		
		return batch;
	}

	@Override
	public List<Batch> getAllBatchesOfACourse(int courseid) throws BatchException {
		List<Batch> batchList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from batch where courseid = ?");
			
			ps.setInt(1, courseid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int bi = rs.getInt("batchid");
				String bn = rs.getString("batchname");
				int ci = rs.getInt("courseid");
				int fi = rs.getInt("facultyid");
				int nos = rs.getInt("numberofstudents");
				String bsd = rs.getString("batchstartdate");
				int dim = rs.getInt("durationinmonths");
				
				Batch batch = new Batch(bi,bn,ci,fi,nos,bsd,dim);
				
				batchList.add(batch);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		
		if(batchList.size() == 0) {
			throw new BatchException("No batch found.");
		}
		
		
		return batchList;
	}

	@Override
	public List<String> getAllFacultiesOfABatch(int batchid) throws BatchException {
		List<String> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select f.facultyname from faculty f inner join batch b on f.facultyid = b.facultyid where b.batchid = ?");
			ps.setInt(1, batchid);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String facultyName = rs.getString("facultyname");
				list.add(facultyName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		
		if(list.size()==0) {
			throw new BatchException("No faculty found for batchid: "+batchid);
		}
		
		return list;
	}

	@Override
	public List<String> getAllBatchesNamesOfAFaculty(int facultyId) throws BatchException {
		List<String> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select b.batchname from batch b inner join faculty f on f.facultyid = b.facultyid where f.facultyid = ?");
			ps.setInt(1, facultyId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				String batchName = rs.getString("batchname");
				list.add(batchName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		
		if(list.size()==0) {
			throw new BatchException("No batch found for facultyid: "+facultyId);
		}
		
		return list;
	}

	@Override
	public List<Integer> getAllBatchesIdsOfAFaculty(int facultyId) throws BatchException {
		List<Integer> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select b.batchid from batch b inner join faculty f on f.facultyid = b.facultyid where f.facultyid = ?");
			ps.setInt(1, facultyId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				int batchId = rs.getInt("batchid");
				list.add(batchId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		
		if(list.size()==0) {
			throw new BatchException("No batch found for facultyid: "+facultyId);
		}
		
		return list;
	}

	@Override
	public List<String> getDaywiseUpdateOfEveryBatch(int dayNumber)
			throws BatchException, FacultyException, CoursePlanException {
		List<String> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select cp.planid,cp.courseid,cp.batchid,b.batchname,cp.daynumber,"
					                                     + "f.facultyid,f.facultyname,cp.topic,cp.status from courseplan cp inner "
					                                     + "join batch b inner join faculty f on cp.batchid=b.batchid and "
					                                     + "f.facultyid=b.facultyid and cp.daynumber = ?;");
			ps.setInt(1, dayNumber);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				int planid = rs.getInt("planid");
				int courseid = rs.getInt("courseid");
				int batchid = rs.getInt("batchid");
				String batchname = rs.getString("batchname");
				int daynumber = rs.getInt("daynumber");
				int facultyid = rs.getInt("facultyid");
				String facultyname = rs.getString("facultyname");
				String topic = rs.getString("topic");
				String status = rs.getString("status");
				
				String str = "PlanId: "+planid+", CourseId: "+courseid+", BatchId: "+batchid+", BatchName: "+batchname+", DayNumber: "+daynumber+", FacultyId: "+facultyid+", FacultyName: "+facultyname+", Topic: "+topic+", Status:"+status;
				list.add(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		
		if(list.size()==0) {
			throw new BatchException("No update found for daynumber: "+dayNumber);
		}
		
		return list;
	}

}
