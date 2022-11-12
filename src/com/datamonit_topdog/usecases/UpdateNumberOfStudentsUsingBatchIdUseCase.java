package com.datamonit_topdog.usecases;

import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;

public class UpdateNumberOfStudentsUsingBatchIdUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter batch id you want to update the number of students for:");
		int batchId = sc.nextInt();
		
		System.out.println("Enter new number of students:");
		int newFacultyId = sc.nextInt();
		
		sc.close();
		
		BatchDao dao = new BatchDaoImpl();
		
		String result = dao.updateNumberOfStudentsUsingBatchId(batchId, newFacultyId);
		
		System.out.println(result);

	}

}
