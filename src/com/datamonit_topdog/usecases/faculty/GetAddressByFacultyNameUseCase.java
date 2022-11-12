package com.datamonit_topdog.usecases.faculty;

import java.util.Scanner;

import com.datamonit_topdog.dao.FacultyDao;
import com.datamonit_topdog.dao.FacultyDaoImpl;
import com.datamonit_topdog.exceptions.FacultyException;

public class GetAddressByFacultyNameUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name of the desired faculty:");
		String facultyName = sc.nextLine();
		
		sc.close();
		
		FacultyDao dao = new FacultyDaoImpl();
		
		try {
			String result = dao.getAddressByFacultyName(facultyName);
			System.out.println(result);
		} catch (FacultyException e) {
			System.out.println(e.getMessage());
		}

	}

}
