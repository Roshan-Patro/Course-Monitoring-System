package com.datamonit_topdog.dao;

import java.util.List;

import com.datamonit_topdog.exceptions.CourseException;
import com.datamonit_topdog.models.Course;

public interface CourseDao {
	public String createCourse(String courseName, int fee, String courseDescription);
	
	public String updateCourseFee(String courseName,int fee );
	
	public String updateCourseNameUsingCourseId(int courseId,String courseName);
	
	public String updateCourseNameUsingCourseName(String courseName,String newCourseName);
	
	public String updateCourseDescription(String courseName,String newCourseDescription);
	
	public Course getCourseByCourseName(String courseName) throws CourseException;
	
	public Course getCourseByCourseId(int courseId) throws CourseException;
	
	public int getCourseFeeByCourseName(String courseName) throws CourseException;
	
	public String getCourseDescriptionByCourseName(String courseName) throws CourseException;
	
	public List<Course> getAllCourseDetails() throws CourseException;

}
