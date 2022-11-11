package com.datamonit_topdog.usecases;

import java.util.Scanner;

import com.datamonit_topdog.dao.CourseDao;
import com.datamonit_topdog.dao.CourseDaoImpl;
import com.datamonit_topdog.exceptions.CourseException;

public class GetFeeByCourseNameUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name of the course to see the fee of:");
		String courseName = sc.nextLine();
		
		sc.close();
		
		CourseDao dao = new CourseDaoImpl();
		
		try {
			int fee = dao.getCourseFeeByCourseName(courseName);
			System.out.println("Fee for the course "+courseName+" is: "+fee);
		} catch (CourseException e) {
			System.out.println(e.getMessage());
		}

	}

}
