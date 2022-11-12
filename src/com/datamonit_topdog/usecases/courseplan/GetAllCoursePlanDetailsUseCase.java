package com.datamonit_topdog.usecases.courseplan;

import java.util.List;

import com.datamonit_topdog.dao.CoursePlanDao;
import com.datamonit_topdog.dao.CoursePlanDaoImpl;
import com.datamonit_topdog.exceptions.CoursePlanException;
import com.datamonit_topdog.models.CoursePlan;

public class GetAllCoursePlanDetailsUseCase {

	public static void main(String[] args) {
		
		CoursePlanDao dao = new CoursePlanDaoImpl();
		
		try {
			List<CoursePlan> coursePlanList = dao.getAllCoursePlanDetails();
			
			coursePlanList.forEach(c -> System.out.println(c));
			
		} catch (CoursePlanException e) {
			System.out.println(e.getMessage());
		}

	}

}
