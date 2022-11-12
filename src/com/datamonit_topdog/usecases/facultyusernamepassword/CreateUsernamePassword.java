package com.datamonit_topdog.usecases.facultyusernamepassword;

import java.util.Scanner;

import com.datamonit_topdog.dao.CoursePlanDao;
import com.datamonit_topdog.dao.CoursePlanDaoImpl;
import com.datamonit_topdog.dao.FacultyUsernamePasswordDao;
import com.datamonit_topdog.dao.FacultyUsernamePasswordDaoImpl;

public class CreateUsernamePassword {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter faculty id:");
		int facultyid = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter username with minimum 5 characters and maximum 10 characters:");
		String username = sc.nextLine();
		
		System.out.println("Enter password with minimum 4 characters and maximum 15 characters:");
		String password = sc.nextLine();
		
		sc.close();
		
		FacultyUsernamePasswordDao dao = new FacultyUsernamePasswordDaoImpl();
		
		String result = dao.createUsernamePassword(facultyid, username, password);
		
		System.out.println(result);

	}

}
