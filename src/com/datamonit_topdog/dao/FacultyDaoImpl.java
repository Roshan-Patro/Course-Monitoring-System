package com.datamonit_topdog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.datamonit_topdog.utility.DBUtil;

public class FacultyDaoImpl implements FacultyDao {
	
	public String registerFaculty(String facultyname, String facultyaddress, long mobile, String email) {
		String message = "Faculty registration failed...";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into faculty(facultyname,facultyaddress,mobile,email) values(?,?,?,?)");
			ps.setString(1, facultyname);
			ps.setString(2, facultyaddress);
			ps.setLong(3, mobile);
			ps.setString(4, email);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = x+" record(s) inserted";
			}
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

	@Override
	public String updateFacultyNameUsingFacultyId(int facultyId, String facultyName) {
		String message = "faculty name updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update faculty set facultyname = ? where facultyId = ?");
			ps.setString(1, facultyName);
			ps.setInt(2, facultyId);
			
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
	public String updateFacultlyNameUsingFacultyName(String FacultyName, String newFacultyName) {
		String message = "Faculty name updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update faculty set FacultyName = ? where FacultyName = ?");
			ps.setString(1, newFacultyName);
			ps.setString(2, FacultyName);
			
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
	public String updateFacultyAddressUsingFacultyId(int facultyId, String facultyAddress) {
		String message = "faculty address updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update faculty set facultyaddress = ? where facultyId = ?");
			ps.setString(1, facultyAddress);
			ps.setInt(2, facultyId);
			
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
	public String updateFacultlyAddressUsingFacultyName(String FacultyName, String newFacultyAddress) {
		String message = "Faculty address updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update faculty set FacultyAddress = ? where FacultyName = ?");
			ps.setString(1, newFacultyAddress);
			ps.setString(2, FacultyName);
			
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
	public String updateFacultyMobileUsingFacultyId(int facultyId, long mobile) {
		String message = "faculty mobile updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update faculty set mobile = ? where facultyId = ?");
			ps.setLong(1, mobile);
			ps.setInt(2, facultyId);
			
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
	public String updateFacultlyMobileUsingFacultyName(String FacultyName, long mobile) {
		String message = "Faculty mobile updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update faculty set mobile = ? where FacultyName = ?");
			ps.setLong(1, mobile);
			ps.setString(2, FacultyName);
			
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
	public String updateFacultyEmailUsingFacultyId(int facultyId, String facultyEmail) {
		String message = "faculty email updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update faculty set email = ? where facultyId = ?");
			ps.setString(1, facultyEmail);
			ps.setInt(2, facultyId);
			
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
	public String updateFacultlyEmailUsingFacultyName(String FacultyName, String newFacultyEmail) {
		String message = "Faculty email updation failed..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update faculty set email = ? where FacultyName = ?");
			ps.setString(1, newFacultyEmail);
			ps.setString(2, FacultyName);
			
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
