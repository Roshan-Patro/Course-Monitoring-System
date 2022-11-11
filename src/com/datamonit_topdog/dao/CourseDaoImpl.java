package com.datamonit_topdog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.datamonit_topdog.exceptions.CourseException;
import com.datamonit_topdog.models.Course;
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

	@Override
	public String updateCourseFee(String courseName, int fee) {
		String message = "Course fee updation failed..";
				
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update course set fee = ? where coursename = ?");
			ps.setInt(1, fee);
			ps.setString(2, courseName);
			
			
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
	public String updateCourseNameUsingCourseId(int courseId, String courseName) {
		String message = "Course name updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update course set coursename = ? where courseid = ?");
			ps.setString(1, courseName);
			ps.setInt(2, courseId);
			
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
	public String updateCourseNameUsingCourseName(String courseName, String newCourseName) {
		String message = "Course name updation failed..";
				
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update course set coursename = ? where coursename = ?");
			ps.setString(1, newCourseName);
			ps.setString(2, courseName);
			
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
	public String updateCourseDescription(String courseName, String newCourseDescription) {
		String message = "Course description updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update course set coursedescription = ? where coursename = ?");
			ps.setString(1, newCourseDescription);
			ps.setString(2, courseName);
			
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
	public Course getCourseByCourseName(String courseName) throws CourseException {
		Course course = null;
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from course where coursename = ?");
			ps.setString(1, courseName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int ci = rs.getInt("courseid");
				String cn = rs.getString("coursename");
				int f = rs.getInt("fee");
				String cd = rs.getString("coursedescription");
				
				course = new Course(ci, cn, f, cd);
			}
			else {
				throw new CourseException("NO course found with the name: "+courseName);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return course;
	}

	@Override
	public Course getCourseByCourseId(int courseId) throws CourseException {
		Course course = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from course where courseid = ?");
			ps.setInt(1, courseId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int ci = rs.getInt("courseid");
				String cn = rs.getString("coursename");
				int f = rs.getInt("fee");
				String cd = rs.getString("coursedescription");
				
				course = new Course(ci,cn,f,cd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return course;
	}

	@Override
	public int getCourseFeeByCourseName(String courseName) throws CourseException {
		int fee = -1;
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select fee from course where coursename = ?");
			ps.setString(1, courseName);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int f = rs.getInt("fee");
				
				fee = f;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return fee;
	}

	@Override
	public String getCourseDescriptionByCourseName(String courseName) throws CourseException {
		String desc = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select coursedescription from course where coursename = ?");
			ps.setString(1, courseName);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String cd = rs.getString("coursedescription");
				
				desc = cd;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return desc;
	}

	
	@Override
	public List<Course> getAllCourseDetails() throws CourseException {
		List<Course> courseList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from course");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int ci = rs.getInt("courseid");
				String cn = rs.getString("coursename");
				int f = rs.getInt("fee");
				String cd = rs.getString("coursedescription");
				
				Course course = new Course(ci,cn,f,cd);
				
				courseList.add(course);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		if(courseList.size() == 0) {
			throw new CourseException("No course found.");
		}
		
		
		return courseList;
	}
	

}
