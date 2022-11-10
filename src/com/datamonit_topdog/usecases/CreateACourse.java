package com.datamonit_topdog.usecases;

import java.util.Scanner;

import com.datamonit_topdog.dao.CourseDao;
import com.datamonit_topdog.dao.CourseDaoImpl;

public class CreateACourse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter course name:");
		String coursename = sc.nextLine();
		
		System.out.println("Enter the fee:");
		int fee = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter course description:");
		String coursedescription = sc.nextLine();
		
		sc.close();
		
		CourseDao dao = new CourseDaoImpl();
		
		String result = dao.createCourse(coursename, fee, coursedescription);
		
		System.out.println(result);
	}

}
