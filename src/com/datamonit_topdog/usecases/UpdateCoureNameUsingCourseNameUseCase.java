package com.datamonit_topdog.usecases;

import java.util.Scanner;

import com.datamonit_topdog.dao.CourseDao;
import com.datamonit_topdog.dao.CourseDaoImpl;

public class UpdateCoureNameUsingCourseNameUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter course name you want to update the name for:");
		String coursename = sc.nextLine();
		
		System.out.println("Enter new name:");
		String newName = sc.nextLine();
		
		sc.close();
		
		CourseDao dao = new CourseDaoImpl();
		
		String result = dao.updateCourseNameUsingCourseName(coursename, newName);
		
		System.out.println(result);

	}

}
