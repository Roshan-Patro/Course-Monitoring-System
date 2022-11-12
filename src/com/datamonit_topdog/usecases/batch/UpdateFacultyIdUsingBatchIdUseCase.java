package com.datamonit_topdog.usecases.batch;

import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;

public class UpdateFacultyIdUsingBatchIdUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter batch id you want to update the faculty id for:");
		int batchId = sc.nextInt();
		
		System.out.println("Enter new faculty id:");
		int newFacultyId = sc.nextInt();
		
		sc.close();
		
		BatchDao dao = new BatchDaoImpl();
		
		String result = dao.updateFacultyIdUsingBatchId(batchId, newFacultyId);
		
		System.out.println(result);

	}

}
