package com.datamonit_topdog.usecases.batch;

import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;
import com.datamonit_topdog.exceptions.BatchException;
import com.datamonit_topdog.models.Batch;

public class GetBatchByBatchNameUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name of the desired batch:");
		String batchName = sc.nextLine();
		
		sc.close();
		
		BatchDao dao = new BatchDaoImpl();
		
		try {
			Batch batch = dao.getBatchByBatchName(batchName);
			System.out.println(batch);
		} catch (BatchException e) {
			System.out.println(e.getMessage());
		}

	}

}
