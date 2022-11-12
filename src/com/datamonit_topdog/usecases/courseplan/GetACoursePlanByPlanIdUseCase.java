package com.datamonit_topdog.usecases.courseplan;

import java.util.Scanner;

import com.datamonit_topdog.dao.CoursePlanDao;
import com.datamonit_topdog.dao.CoursePlanDaoImpl;
import com.datamonit_topdog.exceptions.CoursePlanException;
import com.datamonit_topdog.models.CoursePlan;

public class GetACoursePlanByPlanIdUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the desires plan id to get the course plan:");
		int planId = sc.nextInt();
		
		CoursePlanDao dao = new CoursePlanDaoImpl();
		
		try {
			CoursePlan cp = dao.getACoursePlanByPlanId(planId);
			
			System.out.println(cp);
			
		} catch (CoursePlanException e) {
			System.out.println(e.getMessage());
		}

	}

}
