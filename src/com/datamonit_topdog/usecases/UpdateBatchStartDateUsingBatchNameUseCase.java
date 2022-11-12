package com.datamonit_topdog.usecases;

import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;

public class UpdateBatchStartDateUsingBatchNameUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter batch name you want to update the batch start date for:");
		String batchName = sc.nextLine();
		
		System.out.println("Enter new batch start date:");
		String batchStartDate = sc.nextLine();
		
		sc.close();
		
		BatchDao dao = new BatchDaoImpl();
		
		String result = dao.updateBatchStartDateUsingBatchName(batchName, batchStartDate);
		
		System.out.println(result);

	}

}
