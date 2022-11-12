package com.datamonit_topdog.usecases.courseplan;

import java.util.List;
import java.util.Scanner;

import com.datamonit_topdog.dao.CoursePlanDao;
import com.datamonit_topdog.dao.CoursePlanDaoImpl;
import com.datamonit_topdog.exceptions.CoursePlanException;
import com.datamonit_topdog.models.CoursePlan;

public class GetAllCoursePlansOfACourseUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the desires course id to get course plans:");
		int courseId = sc.nextInt();
		
		CoursePlanDao dao = new CoursePlanDaoImpl();
		
		try {
			List<CoursePlan> cplist = dao.getAllCoursePlansOfACourse(courseId);
			
			cplist.forEach(cp -> System.out.println(cp));
			
		} catch (CoursePlanException e) {
			System.out.println(e.getMessage());
		}

	}

}
