package com.datamonit_topdog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.datamonit_topdog.exceptions.FacultyException;
import com.datamonit_topdog.models.Faculty;
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

	@Override
	public List<Faculty> getAllFacultyDetails() throws FacultyException {
		List<Faculty> facultyList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from faculty");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int fi = rs.getInt("facultyid");
				String fn = rs.getString("facultyname");
				String fa = rs.getString("facultyaddress");
				long mob = rs.getLong("mobile");
				String email = rs.getString("email");
				
				Faculty faculty = new Faculty(fi,fn,fa,mob,email);
				
				facultyList.add(faculty);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		if(facultyList.size() == 0) {
			throw new FacultyException("No faculty found.");
		}
		
		return facultyList;
	}

	@Override
	public Faculty getFacultyByFacultyName(String facultyName) throws FacultyException {
		Faculty faculty = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from faculty where facultyname = ?");
			ps.setString(1, facultyName);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int fi = rs.getInt("facultyid");
				String fn = rs.getString("facultyname");
				String fa = rs.getString("facultyaddress");
				long mob = rs.getLong("mobile");
				String email = rs.getString("email");
				
				faculty = new Faculty(fi,fn,fa,mob,email);
			}
			else {
				throw new FacultyException("NO faculty found with the name: "+facultyName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		return faculty;
	}

	@Override
	public Faculty getFacultyByFacultyId(int facultyId) throws FacultyException {
		Faculty faculty = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from faculty where facultyid = ?");
			ps.setInt(1, facultyId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int fi = rs.getInt("facultyid");
				String fn = rs.getString("facultyname");
				String fa = rs.getString("facultyaddress");
				long mob = rs.getLong("mobile");
				String email = rs.getString("email");
				
				faculty = new Faculty(fi,fn,fa,mob,email);
			}
			else {
				throw new FacultyException("NO faculty found with the name: "+facultyId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		return faculty;
	}

	@Override
	public String getAddressByFacultyName(String facultyName) throws FacultyException {
		String message = "No faculty found with this name..";
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select facultyaddress from faculty where facultyname = ?");
			ps.setString(1, facultyName);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String fa = rs.getString("facultyaddress");
				
				message = fa;
			}
			else {
				throw new FacultyException("NO faculty found with the name: "+facultyName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		return message;
	}

}
