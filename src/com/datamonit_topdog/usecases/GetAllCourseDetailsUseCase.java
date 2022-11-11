package com.datamonit_topdog.usecases;

import java.util.List;

import com.datamonit_topdog.dao.CourseDao;
import com.datamonit_topdog.dao.CourseDaoImpl;
import com.datamonit_topdog.exceptions.CourseException;
import com.datamonit_topdog.models.Course;

public class GetAllCourseDetailsUseCase {

	public static void main(String[] args) {
		
		CourseDao dao = new CourseDaoImpl();
		
		try {
			List<Course> courseList = dao.getAllCourseDetails();
			
			courseList.forEach(c -> System.out.println(c));
			
		} catch (CourseException e) {
			System.out.println(e.getMessage());
		}

	}

}
