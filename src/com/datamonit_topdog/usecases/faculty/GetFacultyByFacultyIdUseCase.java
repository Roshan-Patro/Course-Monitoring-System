package com.datamonit_topdog.usecases.faculty;

import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;
import com.datamonit_topdog.dao.FacultyDao;
import com.datamonit_topdog.dao.FacultyDaoImpl;
import com.datamonit_topdog.exceptions.BatchException;
import com.datamonit_topdog.exceptions.FacultyException;
import com.datamonit_topdog.models.Batch;
import com.datamonit_topdog.models.Faculty;

public class GetFacultyByFacultyIdUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter id of the desired faculty:");
		int facultyId = sc.nextInt();
		
		sc.close();
		
		FacultyDao dao = new FacultyDaoImpl();
		
		try {
			Faculty faculty = dao.getFacultyByFacultyId(facultyId);
			System.out.println(faculty);
		} catch (FacultyException e) {
			System.out.println(e.getMessage());
		}


	}

}
