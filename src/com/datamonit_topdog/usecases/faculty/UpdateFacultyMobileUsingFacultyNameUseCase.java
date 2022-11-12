package com.datamonit_topdog.usecases.faculty;

import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;
import com.datamonit_topdog.dao.FacultyDao;
import com.datamonit_topdog.dao.FacultyDaoImpl;

public class UpdateFacultyMobileUsingFacultyNameUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter faculty name you want to update the mobile number for:");
		String facultyname = sc.nextLine();
		
		System.out.println("Enter new mobile number:");
		long newMobile = sc.nextLong();
		
		sc.close();
		
		FacultyDao dao = new FacultyDaoImpl();
		
		String result = dao.updateFacultlyMobileUsingFacultyName(facultyname, newMobile);
		
		System.out.println(result);

	}

}
