package com.datamonit_topdog.usecases;

import java.util.Scanner;

import com.datamonit_topdog.dao.CourseDao;
import com.datamonit_topdog.dao.CourseDaoImpl;

public class UpdateCourseNameUsingCourseIdUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter course id you want to update the name for:");
		int courseid = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter new name:");
		String name = sc.nextLine();
		
		sc.close();
		
		CourseDao dao = new CourseDaoImpl();
		
		String result = dao.updateCourseNameUsingCourseId(courseid, name);
		
		System.out.println(result);

	}

}
