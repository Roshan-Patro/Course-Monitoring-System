package com.datamonit_topdog.usecases;

import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;

public class UpdateFacultyIdUsingBatchNameUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter batch name you want to update the faculty id for:");
		String batchName = sc.nextLine();
		
		System.out.println("Enter new faculty id:");
		int newFacultyId = sc.nextInt();
		
		sc.close();
		
		BatchDao dao = new BatchDaoImpl();
		
		String result = dao.updateFacultyIdUsingBatchName(batchName, newFacultyId);
		
		System.out.println(result);

	}

}
