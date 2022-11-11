package com.datamonit_topdog.usecases;

import java.util.Scanner;

import com.datamonit_topdog.dao.CourseDao;
import com.datamonit_topdog.dao.CourseDaoImpl;

public class UpdateCouseFeeUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter course name you want to update the fee for:");
		String coursename = sc.nextLine();
		
		System.out.println("Enter new fee:");
		int fee = sc.nextInt();
		
		sc.close();
		
		CourseDao dao = new CourseDaoImpl();
		
		String result = dao.updateCourseFee(coursename, fee);
		
		System.out.println(result);

	}

}
