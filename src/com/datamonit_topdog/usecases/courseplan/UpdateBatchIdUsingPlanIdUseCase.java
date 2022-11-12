package com.datamonit_topdog.usecases.courseplan;

import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;
import com.datamonit_topdog.dao.CoursePlanDao;
import com.datamonit_topdog.dao.CoursePlanDaoImpl;

public class UpdateBatchIdUsingPlanIdUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter plan id you want to update the batch id for:");
		int planId = sc.nextInt();
		
		System.out.println("Enter new batch id:");
		int batchId = sc.nextInt();
		
		sc.close();
		
		CoursePlanDao dao = new CoursePlanDaoImpl();
		
		String result = dao.updateBatchIdUsingPlanId(planId, batchId);
		
		System.out.println(result);

	}

}
