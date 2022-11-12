package com.datamonit_topdog.usecases.facultyusernamepassword;

import java.util.Scanner;

import com.datamonit_topdog.dao.FacultyUsernamePasswordDao;
import com.datamonit_topdog.dao.FacultyUsernamePasswordDaoImpl;
import com.datamonit_topdog.exceptions.FacultyUserNamePasswordException;

public class UserLogin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the username:");
		String userName = sc.nextLine();
		
		System.out.println("Enter the password:");
		String password = sc.nextLine();
		
		sc.close();
		
		FacultyUsernamePasswordDao dao = new FacultyUsernamePasswordDaoImpl();
		
		try {
			String result = dao.userLogin(userName, password);
			System.out.println(result);
		} catch (FacultyUserNamePasswordException e) {
			System.out.println(e.getMessage());
		}

	}

}
