package com.datamonit_topdog.usecases.courseplan;

import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;
import com.datamonit_topdog.dao.CoursePlanDao;
import com.datamonit_topdog.dao.CoursePlanDaoImpl;

public class UpdateTopicUsingPlanIdUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter plan id you want to update the topic for:");
		int planId = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter new topic:");
		String topic = sc.nextLine();
		
		sc.close();
		
		CoursePlanDao dao = new CoursePlanDaoImpl();
		
		String result = dao.updateTopicUsingPlanId(planId, topic);
		
		System.out.println(result);

	}

}
