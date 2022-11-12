package com.datamonit_topdog.usecases.faculty;

import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;
import com.datamonit_topdog.dao.FacultyDao;
import com.datamonit_topdog.dao.FacultyDaoImpl;

public class UpdateFacultyNameUsingFacultyNameUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter faculty name you want to update the name for:");
		String facultyname = sc.nextLine();
		
		System.out.println("Enter new name:");
		String newName = sc.nextLine();
		
		sc.close();
		
		FacultyDao dao = new FacultyDaoImpl();
		
		String result = dao.updateFacultlyNameUsingFacultyName(facultyname, newName);
		
		System.out.println(result);

	}

}
