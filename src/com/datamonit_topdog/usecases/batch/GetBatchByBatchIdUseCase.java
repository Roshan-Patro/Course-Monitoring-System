package com.datamonit_topdog.usecases.batch;

import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;
import com.datamonit_topdog.exceptions.BatchException;
import com.datamonit_topdog.models.Batch;

public class GetBatchByBatchIdUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter id of the desired batch:");
		int batchid = sc.nextInt();
		
		sc.close();
		
		BatchDao dao = new BatchDaoImpl();
		
		try {
			Batch batch = dao.getBatchByBatchId(batchid);
			System.out.println(batch);
		} catch (BatchException e) {
			System.out.println(e.getMessage());
		}

	}

}
