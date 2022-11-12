package com.datamonit_topdog.usecases.batch;

import java.util.List;
import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;
import com.datamonit_topdog.exceptions.BatchException;

public class GetAllFacultiesOfABatchUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the batch id that you want to see all faculties for:");
		int batchId = sc.nextInt();
		
		BatchDao dao = new BatchDaoImpl();
		
		try {
			List<String> facultyList = dao.getAllFacultiesOfABatch(batchId);
			
			facultyList.forEach(c -> System.out.println(c));
			
		} catch (BatchException e) {
			System.out.println(e.getMessage());
		}

	}

}
