package com.datamonit_topdog.usecases.faculty;

import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;
import com.datamonit_topdog.dao.FacultyDao;
import com.datamonit_topdog.dao.FacultyDaoImpl;

public class UpdateFacultyAddressUsingFacultyIdUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter faculty id you want to update the address for:");
		int facultyId = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter new address:");
		String newAddress = sc.nextLine();
		
		sc.close();
		
		FacultyDao dao = new FacultyDaoImpl();
		
		String result = dao.updateFacultyAddressUsingFacultyId(facultyId, newAddress);
		
		System.out.println(result);

	}

}
