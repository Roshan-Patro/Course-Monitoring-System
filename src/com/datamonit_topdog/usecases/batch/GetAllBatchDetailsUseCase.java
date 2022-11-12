package com.datamonit_topdog.usecases.batch;

import java.util.List;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;
import com.datamonit_topdog.exceptions.BatchException;
import com.datamonit_topdog.models.Batch;

public class GetAllBatchDetailsUseCase {

	public static void main(String[] args) {
		
		BatchDao dao = new BatchDaoImpl();
		
		try {
			List<Batch> batchList = dao.getAllBatchDetails();
			
			batchList.forEach(c -> System.out.println(c));
			
		} catch (BatchException e) {
			System.out.println(e.getMessage());
		}

	}

}
