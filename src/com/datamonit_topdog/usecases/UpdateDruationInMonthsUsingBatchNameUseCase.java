package com.datamonit_topdog.usecases;

import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;

public class UpdateDruationInMonthsUsingBatchNameUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter batch name you want to update the duration in months for:");
		String batchName = sc.nextLine();
		
		System.out.println("Enter new duration in months:");
		int newDurationInMonths = sc.nextInt();
		
		sc.close();
		
		BatchDao dao = new BatchDaoImpl();
		
		String result = dao.updateDurationInMonthsUsingBatchName(batchName, newDurationInMonths);
		
		System.out.println(result);

	}

}
