package com.datamonit_topdog.usecases;

import java.util.Scanner;

import com.datamonit_topdog.dao.CoursePlanDao;
import com.datamonit_topdog.dao.CoursePlanDaoImpl;

public class CreateACoursePlan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter course id:");
		int courseid = sc.nextInt();
		
		System.out.println("Enter batch id:");
		int batchid = sc.nextInt();
		
		System.out.println("Enter day number:");
		int daynumber = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter topic:");
		String topic = sc.nextLine();
		
		System.out.println("Enter status:");
		String status = sc.nextLine();
		
		sc.close();
		
		CoursePlanDao dao = new CoursePlanDaoImpl();
		
		String result = dao.createCoursePlan(courseid, batchid, daynumber, topic, status);
		
		System.out.println(result);

	}

}
