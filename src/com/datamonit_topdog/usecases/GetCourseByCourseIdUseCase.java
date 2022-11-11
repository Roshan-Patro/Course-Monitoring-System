package com.datamonit_topdog.usecases;

import java.util.Scanner;

import com.datamonit_topdog.dao.CourseDao;
import com.datamonit_topdog.dao.CourseDaoImpl;
import com.datamonit_topdog.exceptions.CourseException;
import com.datamonit_topdog.models.Course;

public class GetCourseByCourseIdUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter id of the desired course:");
		int courseid = sc.nextInt();
		
		sc.close();
		
		CourseDao dao = new CourseDaoImpl();
		
		try {
			Course course = dao.getCourseByCourseId(courseid);
			System.out.println(course);
		} catch (CourseException e) {
			System.out.println(e.getMessage());
		}

	}

}
