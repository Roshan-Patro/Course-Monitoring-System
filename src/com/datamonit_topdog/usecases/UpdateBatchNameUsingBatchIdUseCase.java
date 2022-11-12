package com.datamonit_topdog.usecases;

import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;

public class UpdateBatchNameUsingBatchIdUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter batch id you want to update the name for:");
		int batchId = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter new name:");
		String newName = sc.nextLine();
		
		sc.close();
		
		BatchDao dao = new BatchDaoImpl();
		
		String result = dao.updateBatchNameUsingBatchId(batchId, newName);
		
		System.out.println(result);

	}

}
