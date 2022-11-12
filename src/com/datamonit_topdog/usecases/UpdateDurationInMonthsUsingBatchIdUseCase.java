package com.datamonit_topdog.usecases;

import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;

public class UpdateDurationInMonthsUsingBatchIdUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter batch id you want to update the duration in months for:");
		int batchId = sc.nextInt();
		
		System.out.println("Enter new duration in months:");
		int durationInMonths = sc.nextInt();
		
		sc.close();
		
		BatchDao dao = new BatchDaoImpl();
		
		String result = dao.updateDurationInMonthsUsingBatchId(batchId, durationInMonths);
		
		System.out.println(result);

	}

}
