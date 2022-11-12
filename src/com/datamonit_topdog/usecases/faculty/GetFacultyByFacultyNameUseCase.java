package com.datamonit_topdog.usecases.faculty;

import java.util.Scanner;

import com.datamonit_topdog.dao.FacultyDao;
import com.datamonit_topdog.dao.FacultyDaoImpl;
import com.datamonit_topdog.exceptions.FacultyException;
import com.datamonit_topdog.models.Faculty;

public class GetFacultyByFacultyNameUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name of the desired faculty:");
		String facultyName = sc.nextLine();
		
		sc.close();
		
		FacultyDao dao = new FacultyDaoImpl();
		
		try {
			Faculty faculty = dao.getFacultyByFacultyName(facultyName);
			System.out.println(faculty);
		} catch (FacultyException e) {
			System.out.println(e.getMessage());
		}

	}

}
