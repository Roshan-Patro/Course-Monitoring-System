package com.datamonit_topdog.dao;

import java.util.List;

import com.datamonit_topdog.exceptions.FacultyException;
import com.datamonit_topdog.models.Faculty;

public interface FacultyDao {
	public String registerFaculty(String facultyname, String facultyaddress, long mobile, String email);
	
	public String updateFacultyNameUsingFacultyId(int facultyId,String facultyName);
	
	public String updateFacultlyNameUsingFacultyName(String FacultyName,String newFacultyName);
	
	public String updateFacultyAddressUsingFacultyId(int facultyId,String facultyAddress);
	
	public String updateFacultlyAddressUsingFacultyName(String FacultyName,String newFacultyAddress);
	
	public String updateFacultyMobileUsingFacultyId(int facultyId,long mobile);
	
	public String updateFacultlyMobileUsingFacultyName(String FacultyName,long mobile);
	
	public String updateFacultyEmailUsingFacultyId(int facultyId,String facultyEmail);
	
	public String updateFacultlyEmailUsingFacultyName(String FacultyName,String newFacultyEmail);
	
	public List<Faculty> getAllFacultyDetails() throws FacultyException;
	
	public Faculty getFacultyByFacultyName(String facultyName) throws FacultyException;
	
	public Faculty getFacultyByFacultyId(int facultyId) throws FacultyException;
	
	public String getAddressByFacultyName(String facultyName) throws FacultyException;
}
