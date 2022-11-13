package com.datamonit_topdog.usecases;

import java.util.Scanner;

import com.datamonit_topdog.dao.CourseDao;
import com.datamonit_topdog.dao.CourseDaoImpl;

public class UpdateCourseDescriptionByCourseNameUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter course name you want to update the description for:");
		String coursename = sc.nextLine();
		
		System.out.println("Enter new description:");
		String newDescription = sc.nextLine();
		
		sc.close();
		
		CourseDao dao = new CourseDaoImpl();
		
		String result = dao.updateCourseDescription(coursename, newDescription);
		
		System.out.println(result);

	}

}
