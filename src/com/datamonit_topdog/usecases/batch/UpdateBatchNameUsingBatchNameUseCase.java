package com.datamonit_topdog.usecases.batch;

import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;

public class UpdateBatchNameUsingBatchNameUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter batch name you want to update the name for:");
		String batchname = sc.nextLine();
		
		System.out.println("Enter new name:");
		String newName = sc.nextLine();
		
		sc.close();
		
		BatchDao dao = new BatchDaoImpl();
		
		String result = dao.updateBatchNameUsingBatchName(batchname, newName);
		
		System.out.println(result);

	}

}
