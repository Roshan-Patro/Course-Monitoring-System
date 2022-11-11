package com.datamonit_topdog.usecases;

import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;

public class CreateABatchUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
				System.out.println("Enter batch name:");
				String batchname = sc.nextLine();
				
				System.out.println("Enter course id:");
				int courseid = sc.nextInt();
				
				System.out.println("Enter faculty id:");
				int facultyid = sc.nextInt();
				
				System.out.println("Enter number of students:");
				int numberofstudents = sc.nextInt();
				
				sc.nextLine();
				
				System.out.println("Enter batch start date:");
				String batchStartDate = sc.nextLine();
				
				System.out.println("Enter duration in months:");
				int durationInMonths = sc.nextInt();
				
				sc.close();
				
				BatchDao dao = new BatchDaoImpl();
				
				String result = dao.createBatch(batchname, courseid, facultyid, numberofstudents, batchStartDate, durationInMonths);
				
				System.out.println(result);

	}

}
