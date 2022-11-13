package com.datamonit_topdog.mainclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.datamonit_topdog.dao.BatchDao;
import com.datamonit_topdog.dao.BatchDaoImpl;
import com.datamonit_topdog.dao.CourseDao;
import com.datamonit_topdog.dao.CourseDaoImpl;
import com.datamonit_topdog.exceptions.BatchException;
import com.datamonit_topdog.exceptions.CourseException;
import com.datamonit_topdog.models.Batch;
import com.datamonit_topdog.models.Course;
import com.datamonit_topdog.usecases.CreateACourse;
import com.datamonit_topdog.utility.DBUtil;

public class Main {
	static int inCasesOfAdminCourseMenuChoice = 0;
	static int adminCourseMenuChoice = 0;
	public static void main(String[] args) {
		welcomeMessage(); // Calling function to print welcome message first.
		int choiceCourseMenu = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("You are an Admin or an User?");
		System.out.println("If admin, press a.");
		System.out.println("If user, press u.");
		String userChoice = sc.next();
		
		switch(userChoice) { // admin or user
		
		case "a": // for admin
			System.out.println("Please login with your admin credentials!");
			System.out.println("Enter your username:");
			String aUsername = sc.next();
			sc.nextLine();
			System.out.println("Enter your password:");
			String aPassword = sc.nextLine();
			
			if((aUsername.equals("admin")) && (aPassword.equals("admin@123"))) {
				System.out.println("Login successful.");
			}
			
			else {
				System.out.println("Invalid Credentials.");
			}
			
			adminMenu();
			
			int adminMenuchoice = sc.nextInt();
			sc.nextLine();
			
			switch(adminMenuchoice) { // all admin menu
			
			case 1: // admin course
				System.out.println("Welcome to admin course menu.");
				adminCourseMenu();
				choiceCourseMenu = sc.nextInt();
				sc.nextLine();
				CourseDao dao = new CourseDaoImpl();
				boolean flag = true;
				while(choiceCourseMenu!=-1) {
					switch (choiceCourseMenu) {
					case 1: // create a course
						System.out.println("Enter course name:");
						String coursename = sc.nextLine();
						System.out.println("Enter the fee:");
						int fee = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter course description:");
						String coursedescription = sc.nextLine();
						String result = dao.createCourse(coursename, fee, coursedescription);
						System.out.println(result);
						adminCourseMenu();
					    break;
				    case 2: // get all course details
						try {
							List<Course> courseList = dao.getAllCourseDetails();
							
							courseList.forEach(c -> System.out.println(c));
							
						} catch (CourseException e) {
							System.out.println(e.getMessage());
						}
						adminCourseMenu();
						break;
				    case 3: // get course details by course id
				    	System.out.println("Enter id of the desired course:");
						int courseid = sc.nextInt();
						sc.nextLine();
						try {
							Course course = dao.getCourseByCourseId(courseid);
							System.out.println(course);
						} catch (CourseException e) {
							System.out.println(e.getMessage());
						}
						adminCourseMenu();
				    	break;
				    case 4: // get course details by course name
				    	System.out.println("Enter name of the desired course:");
						String courseName = sc.nextLine();
						try {
							Course course = dao.getCourseByCourseName(courseName);
							System.out.println(course);
						} catch (CourseException e) {
							System.out.println(e.getMessage());
						}
						adminCourseMenu();
				    	break;
//				    case 12: // go to admin menu
//				    	adminMenu();
//				    	break;
				    case 11: // to log out
				    	exit();
				    	flag=false;
				    	break;
				    
					default:
						System.out.println("Invalid input.");
						adminCourseMenu();
					}
					if(flag==false) {
						break;
					}
					choiceCourseMenu = sc.nextInt();
					if(choiceCourseMenu!=12) {
						flag = true;
					}
				}
				break;
				
			case 2: // batch related operations
				System.out.println("Welcome to batch course menu.");
				adminBatchMenu();
				int choiceBatchMenu = sc.nextInt();
				sc.nextLine();
				BatchDao daob = new BatchDaoImpl();
				boolean flagb = true;
				while(choiceBatchMenu!=-1) {
					switch (choiceBatchMenu) {
					case 1: // create a batch
						System.out.println("Enter batch name:");
						String batchname = sc.nextLine();
						
						System.out.println("Enter course id:");
						int courseid = sc.nextInt();
						
						System.out.println("Enter faculty id:");
						int facultyid = sc.nextInt();
						
						System.out.println("Enter number of students:");
						int numberofstudents = sc.nextInt();
						
						sc.nextLine();
						
						System.out.println("Enter batch start date:");
						String batchStartDate = sc.nextLine();
						
						System.out.println("Enter duration in months:");
						int durationInMonths = sc.nextInt();

						sc.nextLine();
						
						String result = daob.createBatch(batchname, courseid, facultyid, numberofstudents, batchStartDate, durationInMonths);
						
						System.out.println(result);
						adminBatchMenu();
					    break;
				    case 2: // get all batch details
				    	try {
							List<Batch> batchList = daob.getAllBatchDetails();
							
							batchList.forEach(c -> System.out.println(c));
							
						} catch (BatchException e) {
							System.out.println(e.getMessage());
						}
						adminBatchMenu();
						break;
				    case 3: // get all batches ids by faculty id
				    	System.out.println("Enter the faculty id that you want to see all batches Ids for:");
						int facultyId = sc.nextInt();
						
						try {
							List<Integer> batchList = daob.getAllBatchesIdsOfAFaculty(facultyId);
							
							batchList.forEach(c -> System.out.println(c));
							
						} catch (BatchException e) {
							System.out.println(e.getMessage());
						}
						adminBatchMenu();
				    	break;
				    case 4: // get all batches namess by faculty id
				    	System.out.println("Enter the faculty id that you want to see all batches for:");
						int facultyId2 = sc.nextInt();
						
						try {
							List<String> batchList = daob.getAllBatchesNamesOfAFaculty(facultyId2);
							
							batchList.forEach(c -> System.out.println(c));
							
						} catch (BatchException e) {
							System.out.println(e.getMessage());
						}
						adminBatchMenu();
				    	break;
				    case 9: // get day wise update of a day
				    	System.out.println("Enter the day number that you want to see all updates for:");
						int dayNumber = sc.nextInt();
						sc.nextLine();
						
						try {
							List<String> list = daob.getDaywiseUpdateOfEveryBatch(dayNumber);
							
							list.forEach(c -> System.out.println(c));
							
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						adminBatchMenu();
				    	break;
//				    case 12: // go to admin menu
//				    	adminMenu();
//				    	break;
				    case 11: // to log out
				    	exit();
				    	flagb=false;
				    	break;
				    
					default:
						System.out.println("Invalid input.");
						adminBatchMenu();
					}
					if(flagb==false) {
						break;
					}
					choiceCourseMenu = sc.nextInt();
					if(choiceCourseMenu!=12) {
						flag = true;
					}
				}
				break;
			}
			break;
			
		case "u":
			System.out.println("Please login with your login credentials!");
			System.out.println("Enter your username:");
			String username = sc.next();
			System.out.println("Enter your password:");
			String password = sc.next();
			
			Connection conn = DBUtil.provideConnection();
			try {
				PreparedStatement ps = conn.prepareStatement("select * from facultyusernamepassword where username = ? AND password = ?");
				ps.setString(1, username);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					System.out.println("Login successful.");
				}
				else {
					System.out.println("Invalid credentials.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			break;
		
		default: 
			System.out.println("Invalid choice.");
			break;
			
		}
		
		
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// function 1
	public static void welcomeMessage() {
		System.out.println("+=====================================================+");
		System.out.println("|                                                     |");
		System.out.println("|                      Welcome to                     |");
		System.out.println("|                                                     |");
		System.out.println("|                   DataMonit TOPDOG                  |");
		System.out.println("|                                                     |");
		System.out.println("+=====================================================+");
	}
	
	
	public static void exit() {
		System.out.println("Logged out.");
	}
	// function 2
	public static void adminMenu() {
		System.out.println("Welcome to admin menu.");
		System.out.println("Press 1 & enter for course related operations.");
		System.out.println("Press 2 & enter for batch related operations.");
		System.out.println("Press 3 & enter for faculty related operations.");
		System.out.println("Press 4 & enter for coursePlan related operations.");
	}
	
	// function 3
	public static void adminCourseMenu() {		
		System.out.println("Press 1 & enter to create a course.");
		System.out.println("Press 2 & enter to get all course details.");
		System.out.println("Press 3 & enter to get course details by course id.");
		System.out.println("Press 4 & enter to get course details by course name.");
		System.out.println("Press 5 & enter to get course description by course name.");
		System.out.println("Press 6 & enter to get course fee by course name.");
		System.out.println("Press 7 & enter to update course name by course name.");
		System.out.println("Press 8 & enter to update course name by course id.");
		System.out.println("Press 9 & enter to update course description by course name.");
		System.out.println("Press 10 & enter to update course fee by course name.");
//		System.out.println("Press 12 & enter to go to admin menu.");
		System.out.println("Press 11 & enter to log out.");
	}
	
	
	public static void adminBatchMenu() {		
		System.out.println("Press 1 & enter to create a batch.");
		System.out.println("Press 2 & enter to get all batch details.");
		System.out.println("Press 3 & enter to get all batches ids by faculty id.");
		System.out.println("Press 4 & enter to get all batches namess by faculty id.");
		System.out.println("Press 5 & enter to get all batches of a course.");
		System.out.println("Press 6 & enter to get all faculties of a batch.");
		System.out.println("Press 7 & enter to get batch by batchid.");
		System.out.println("Press 8 & enter to get batch by batch name.");
		System.out.println("Press 9 & enter to get day wise update of a day.");
		System.out.println("Press 10 & enter to update batchname by batch id.");
//		System.out.println("Press 12 & enter to go to admin menu.");
		System.out.println("Press 11 & enter to log out.");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// function 4
//	public static void switchCasesForCourseMenu() {
//		Scanner sc = new Scanner(System.in);
//		
//		int choice = sc.nextInt();
//		sc.nextLine();
//		
//		switch(choice){
//			case 1:
//				CreateACourse.createC();
//				break;
//				
//		}
//	}
	
	
	
	
	
	
	
	
	
	
	
	// function 5
//	public static void inCasesOfAdminCourseMenu() {
//		Scanner sc = new Scanner(System.in);
////		int inCasesOfAdminCourseMenuChoice = 0;
//		System.out.println("Press 1 & enter to go to course admin menu.");
//		System.out.println("Press 2 & enter to go to admin menu.");
//		System.out.println("Press 3 & enter to log out.");
//		
//		inCasesOfAdminCourseMenuChoice = sc.nextInt();
//		sc.nextLine();
//		
//		switch(inCasesOfAdminCourseMenuChoice) {
//		case 1:
//			adminCourseMenu();
//			break;
//		case 2:
//			adminMenu();
//			break;
//		case 3:
//			System.out.println("Logged out successfully.");
//		}
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
