package com.datamonit_topdog.usecases.faculty;

import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;
import com.datamonit_topdog.dao.FacultyDao;
import com.datamonit_topdog.dao.FacultyDaoImpl;

public class UpdateFacultyEmailUsingFacultyIdUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter faculty id you want to update the email for:");
		int facultyId = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter new email:");
		String newEmail = sc.nextLine();
		
		sc.close();
		
		FacultyDao dao = new FacultyDaoImpl();
		
		String result = dao.updateFacultyEmailUsingFacultyId(facultyId, newEmail);
		
		System.out.println(result);

	}

}
