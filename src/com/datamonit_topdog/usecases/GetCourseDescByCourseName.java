package com.datamonit_topdog.usecases;

import java.util.Scanner;

import com.datamonit_topdog.dao.CourseDao;
import com.datamonit_topdog.dao.CourseDaoImpl;
import com.datamonit_topdog.exceptions.CourseException;

public class GetCourseDescByCourseName {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name of the course to see the description of:");
		String courseName = sc.nextLine();
		
		sc.close();
		
		CourseDao dao = new CourseDaoImpl();
		
		try {
			String desc = dao.getCourseDescriptionByCourseName(courseName);
			System.out.println("Description of the course "+courseName+" is: "+desc);
		} catch (CourseException e) {
			System.out.println(e.getMessage());
		}

	}

}
