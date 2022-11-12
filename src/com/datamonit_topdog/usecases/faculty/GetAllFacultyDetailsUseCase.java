package com.datamonit_topdog.usecases.faculty;

import java.util.List;

import com.datamonit_topdog.dao.FacultyDao;
import com.datamonit_topdog.dao.FacultyDaoImpl;
import com.datamonit_topdog.exceptions.FacultyException;
import com.datamonit_topdog.models.Faculty;

public class GetAllFacultyDetailsUseCase {

	public static void main(String[] args) {
		
		FacultyDao dao = new FacultyDaoImpl();
		
		try {
			List<Faculty> batchList = dao.getAllFacultyDetails();
			
			batchList.forEach(c -> System.out.println(c));
			
		} catch (FacultyException e) {
			System.out.println(e.getMessage());
		}

	}

}
