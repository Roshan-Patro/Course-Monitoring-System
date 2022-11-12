package com.datamonit_topdog.usecases.courseplan;

import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;
import com.datamonit_topdog.dao.CoursePlanDao;
import com.datamonit_topdog.dao.CoursePlanDaoImpl;

public class UpdateStatusUsingPlanIdUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter plan id you want to update the status for:");
		int planId = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter new status:");
		String status = sc.nextLine();
		
		sc.close();
		
		CoursePlanDao dao = new CoursePlanDaoImpl();
		
		String result = dao.updateStatusUsingPlanId(planId, status);
		
		System.out.println(result);

	}

}
