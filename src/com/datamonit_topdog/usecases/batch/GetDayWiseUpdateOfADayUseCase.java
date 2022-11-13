package com.datamonit_topdog.usecases.batch;

import java.util.List;
import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;

public class GetDayWiseUpdateOfADayUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the day number that you want to see all updates for:");
		int dayNumber = sc.nextInt();
		
		BatchDao dao = new BatchDaoImpl();
		
		try {
			List<String> list = dao.getDaywiseUpdateOfEveryBatch(dayNumber);
			
			list.forEach(c -> System.out.println(c));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
