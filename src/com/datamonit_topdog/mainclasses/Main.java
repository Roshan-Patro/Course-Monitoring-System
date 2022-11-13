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
import com.datamonit_topdog.dao.CoursePlanDao;
import com.datamonit_topdog.dao.CoursePlanDaoImpl;
import com.datamonit_topdog.dao.FacultyDao;
import com.datamonit_topdog.dao.FacultyDaoImpl;
import com.datamonit_topdog.exceptions.BatchException;
import com.datamonit_topdog.exceptions.CourseException;
import com.datamonit_topdog.exceptions.CoursePlanException;
import com.datamonit_topdog.exceptions.FacultyException;
import com.datamonit_topdog.models.Batch;
import com.datamonit_topdog.models.Course;
import com.datamonit_topdog.models.CoursePlan;
import com.datamonit_topdog.models.Faculty;
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
			boolean flagMain = true;
			int logInSuccessVal = 1;
			while(flagMain==true) {
			if((aUsername.equals("admin")) && (aPassword.equals("admin@123"))) {
				if(logInSuccessVal == 1) {
					System.out.println("Login successful.");
					logInSuccessVal++;
				}
				adminMenu();
				int adminMenuchoice = sc.nextInt();
				sc.nextLine();
				
				switch(adminMenuchoice) { // all admin menu
				
				case 1: // admin course related operations
					System.out.println("Welcome to admin course menu.");
					adminCourseMenu();
					choiceCourseMenu = sc.nextInt();
					sc.nextLine();
					CourseDao dao = new CourseDaoImpl();
					boolean flag = true;
					boolean flagA = true;
					String courseName = null;
					int fee = Integer.MIN_VALUE;
					String resultc = null;
					int courseidc = 0;
					while(choiceCourseMenu!=-1) {
						switch (choiceCourseMenu) {
						case 1: // create a course
							System.out.println("Enter course name:");
							String coursename = sc.nextLine();
							System.out.println("Enter the fee:");
							fee = sc.nextInt();
							sc.nextLine();
							System.out.println("Enter course description:");
							String coursedescription = sc.nextLine();
							resultc = dao.createCourse(coursename, fee, coursedescription);
							System.out.println(resultc);
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
							courseidc = sc.nextInt();
							sc.nextLine();
							try {
								Course course = dao.getCourseByCourseId(courseidc);
								System.out.println(course);
							} catch (CourseException e) {
								System.out.println(e.getMessage());
							}
							adminCourseMenu();
					    	break;
					    case 4: // get course details by course name
					    	System.out.println("Enter name of the desired course:");
							courseName = sc.nextLine();
							try {
								Course course = dao.getCourseByCourseName(courseName);
								System.out.println(course);
							} catch (CourseException e) {
								System.out.println(e.getMessage());
							}
							adminCourseMenu();
					    	break;
					    case 5: // get course desc by course name
					    	System.out.println("Enter name of the course to see the description of:");
							courseName = sc.nextLine();
							
							try {
								String desc = dao.getCourseDescriptionByCourseName(courseName);
								System.out.println("Description of the course "+courseName+" is: "+desc);
							} catch (CourseException e) {
								System.out.println(e.getMessage());
							}
							adminCourseMenu();
					    	break;
					    case 6: // get course fee by course name
					    	System.out.println("Enter name of the course to see the fee of:");
							courseName = sc.nextLine();
							
							try {
								fee = dao.getCourseFeeByCourseName(courseName);
								System.out.println("Fee for the course "+courseName+" is: "+fee);
							} catch (CourseException e) {
								System.out.println(e.getMessage());
							}
							adminCourseMenu();
					    	break;
					    case 7: // update course name by course name
					    	System.out.println("Enter course name you want to update the name for:");
							coursename = sc.nextLine();
							
							System.out.println("Enter new name:");
							String newName = sc.nextLine();
							
							resultc = dao.updateCourseNameUsingCourseName(coursename, newName);
							
							System.out.println(resultc);
							adminCourseMenu();
					    	break;
					    case 8: // update course desc by course name
					    	System.out.println("Enter course name you want to update the description for:");
							coursename = sc.nextLine();
							
							System.out.println("Enter new description:");
							String newDescription = sc.nextLine();
							
							resultc = dao.updateCourseDescription(coursename, newDescription);
							
							System.out.println(resultc);
							adminCourseMenu();
					    	break;
					    case 9: // update course name by course id
					    	System.out.println("Enter course id you want to update the name for:");
							courseidc = sc.nextInt();
							
							sc.nextLine();
							
							System.out.println("Enter new name:");
							String name = sc.nextLine();
							
							resultc = dao.updateCourseNameUsingCourseId(courseidc, name);
							
							System.out.println(resultc);
							adminCourseMenu();
					    	break;
					    case 10: // update course fee by course name
					    	System.out.println("Enter course name you want to update the fee for:");
							coursename = sc.nextLine();
							
							System.out.println("Enter new fee:");
							fee = sc.nextInt();
							sc.nextLine();
							
							resultc = dao.updateCourseFee(coursename, fee);
							
							System.out.println(resultc);
							adminCourseMenu();
					    	break;
					    case 11: // to log out
					    	exit();
					    	flag=false;
					    	break;
					    case 12: // go to admin menu
					    	flagA = false;
					    	break;
						default:
							System.out.println("Invalid input.");
							adminCourseMenu();
							break;
						}
						if(flag==false) {
							break;
						}
						if(flagA == true) {
							choiceCourseMenu = sc.nextInt();
							sc.nextLine();
						}
						if(choiceCourseMenu!=11) {
							flag = true;
						}
					}
					if(flag==false) {
						flagMain=false;
					}
					break;
					
				case 2: // batch related operations
					System.out.println("Welcome to admin batch menu.");
					adminBatchMenu();
					int choiceBatchMenu = sc.nextInt();
					sc.nextLine();
					BatchDao daob = new BatchDaoImpl();
					boolean flagb = true;
					boolean flagbA = true;
					while(flagb == true && flagbA == true) {
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
					    case 4: // get all batches names by faculty id
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
					    case 11: // to log out
					    	exit();
					    	flagb=false;
					    	break;
					    case 12: // go to admin menu
					    	flagbA = false;
					    	break;
						default:
							System.out.println("Invalid input.");
							adminBatchMenu();
							break;
						}
						if(flagb==false) {
							break;
						}
						if(flagbA == true) {
							choiceBatchMenu = sc.nextInt();
							sc.nextLine();
						}
						if(choiceBatchMenu!=11) {
							flagb = true;
						}
					}
					if(flagb==false) {
					flagMain = false;
					}
					break;
					
				case 3: // faculty related operations 
					System.out.println("Welcome to admin faculty menu.");
					adminFacultyMenu();
					int choiceFacultyMenu = sc.nextInt();
					sc.nextLine();
					FacultyDao daof = new FacultyDaoImpl();
					boolean flagf = true;
					boolean flagfA = true;
					String result = null;
					String facultyName = null; 
					int facultyId = 0;
					String newAddress = null;
					String newEmail = null;
					long newMobile = 0;
					String newName = null;
					while(flagf == true && flagfA == true) {
						switch (choiceFacultyMenu) {
						case 1: // register a faculty
							System.out.println("Enter faculty name:");
							String facultyname = sc.nextLine();
							
							System.out.println("Enter faculty address:");
							String facultyaddress = sc.nextLine();
							
							System.out.println("Enter mobile number:");
							long mobile = sc.nextLong();
							
							sc.nextLine();
							
							System.out.println("Enter email address:");
							String email = sc.nextLine();
							
							result = daof.registerFaculty(facultyname, facultyaddress, mobile, email);
							
							System.out.println(result);
							adminFacultyMenu();
						    break;
					    case 2: // get address by name
					    	System.out.println("Enter name of the desired faculty:");
							facultyName = sc.nextLine();
							try {
								result = daof.getAddressByFacultyName(facultyName);
								System.out.println(result);
							} catch (FacultyException e) {
								System.out.println(e.getMessage());
							}
							adminFacultyMenu();
							break;
					    case 3: // get all faculty details
					    	try {
								List<Faculty> batchList = daof.getAllFacultyDetails();
								
								batchList.forEach(c -> System.out.println(c));
								
							} catch (FacultyException e) {
								System.out.println(e.getMessage());
							}
							adminFacultyMenu();
					    	break;
					    case 4: // get faculty by faculty id
					    	System.out.println("Enter id of the desired faculty:");
							facultyId = sc.nextInt();
							sc.nextLine();
							try {
								Faculty faculty = daof.getFacultyByFacultyId(facultyId);
								System.out.println(faculty);
							} catch (FacultyException e) {
								System.out.println(e.getMessage());
							}
							adminFacultyMenu();
					    	break;
					    case 5: // get faculty by faculty name
					    	System.out.println("Enter name of the desired faculty:");
							facultyName = sc.nextLine();
							
							try {
								Faculty faculty = daof.getFacultyByFacultyName(facultyName);
								System.out.println(faculty);
							} catch (FacultyException e) {
								System.out.println(e.getMessage());
							}
							adminFacultyMenu();
					    	break;
					    case 6: // update address using faculty id
					    	System.out.println("Enter faculty id you want to update the address for:");
							facultyId = sc.nextInt();
							
							sc.nextLine();
							
							System.out.println("Enter new address:");
							newAddress = sc.nextLine();
							
							result = daof.updateFacultyAddressUsingFacultyId(facultyId, newAddress);
							
							System.out.println(result);
							adminFacultyMenu();
					    	break;
					    case 7: // update address using faculty name
					    	System.out.println("Enter faculty name you want to update the address for:");
							facultyname = sc.nextLine();
							
							System.out.println("Enter new address:");
							newAddress = sc.nextLine();

							result = daof.updateFacultlyAddressUsingFacultyName(facultyname, newAddress);
							
							System.out.println(result);
							adminFacultyMenu();
					    	break;
					    case 8: // update email using faculty id
					    	System.out.println("Enter faculty id you want to update the email for:");
							facultyId = sc.nextInt();
							
							sc.nextLine();
							
							System.out.println("Enter new email:");
							newEmail = sc.nextLine();
							
							result = daof.updateFacultyEmailUsingFacultyId(facultyId, newEmail);
							
							System.out.println(result);
							adminFacultyMenu();
					    	break;
					    case 9: // update email using faculty name
					    	System.out.println("Enter faculty name you want to update the email for:");
							facultyname = sc.nextLine();
							
							System.out.println("Enter new email:");
							newEmail = sc.nextLine();
							
							result = daof.updateFacultlyEmailUsingFacultyName(facultyname, newEmail);
							
							System.out.println(result);
							adminFacultyMenu();
					    	break;
					    case 10: // update mobile using faculty id
					    	System.out.println("Enter faculty id you want to update the mobile number for:");
							facultyId = sc.nextInt();
							
							System.out.println("Enter new mobile number:");
							newMobile = sc.nextLong();
							
							result = daof.updateFacultyMobileUsingFacultyId(facultyId, newMobile);
							
							System.out.println(result);
							adminFacultyMenu();
					    	break;
					    case 11: // update mobile using faculty name
					    	System.out.println("Enter faculty name you want to update the mobile number for:");
							facultyname = sc.nextLine();
							
							System.out.println("Enter new mobile number:");
							newMobile = sc.nextLong();
							
							result = daof.updateFacultlyMobileUsingFacultyName(facultyname, newMobile);
							
							System.out.println(result);
							adminFacultyMenu();
					    	break;
					    case 12: // update name using faculty id
					    	System.out.println("Enter faculty id you want to update the name for:");
							facultyId = sc.nextInt();
							
							sc.nextLine();
							
							System.out.println("Enter new name:");
							newName = sc.nextLine();
							
							result = daof.updateFacultyNameUsingFacultyId(facultyId, newName);
							
							System.out.println(result);
							adminFacultyMenu();
					    	break;
					    case 13: // update name using faculty name
					    	System.out.println("Enter faculty name you want to update the name for:");
							facultyname = sc.nextLine();
							
							System.out.println("Enter new name:");
							newName = sc.nextLine();
							
							result = daof.updateFacultlyNameUsingFacultyName(facultyname, newName);
							
							System.out.println(result);
							adminFacultyMenu();
					    	break;
					    case 14: // to log out
					    	exit();
					    	flagf=false;
					    	break;
					    case 15: // go to admin menu
					    	flagfA = false;
					    	break;
						default:
							System.out.println("Invalid input.");
							adminFacultyMenu();
							break;
						}
						if(flagf==false) {
							break;
						}
						if(flagfA == true) {
							choiceFacultyMenu = sc.nextInt();
							sc.nextLine();
						}
						if(choiceFacultyMenu!=14) {
							flagf = true;
						}
					}
					if(flagf==false) {
					flagMain = false;
					}
					break;
					
				case 4: // admin course plan related operations
					System.out.println("Welcome to admin course plan menu.");
					adminCoursePlanMenu();
					int choiceCoursePlanMenu = sc.nextInt();
					sc.nextLine();
					CoursePlanDao daocp = new CoursePlanDaoImpl();
					boolean flagcp = true;
					boolean flagcpA = true;
					String result1 = null;
					String status = null; 
					int planId = 0;
					int courseId = 0;
					int daynumber = 0;
					while(flagcp == true && flagcpA == true) {
						switch (choiceCoursePlanMenu) {
						case 1: // create a course plan
							System.out.println("Enter course id:");
							int courseid = sc.nextInt();
							
							System.out.println("Enter batch id:");
							int batchid = sc.nextInt();
							
							System.out.println("Enter day number:");
							daynumber = sc.nextInt();
							
							sc.nextLine();
							
							System.out.println("Enter topic:");
							String topic = sc.nextLine();
							
							System.out.println("Enter status:");
							status = sc.nextLine();
							
							result1 = daocp.createCoursePlan(courseid, batchid, daynumber, topic, status);
							
							System.out.println(result1);
							adminCoursePlanMenu();
						    break;
					    case 2: // get cp by pid
					    	System.out.println("Enter the desires plan id to get the course plan:");
							planId = sc.nextInt();
							sc.nextLine();
							
							try {
								CoursePlan cp = daocp.getACoursePlanByPlanId(planId);
								
								System.out.println(cp);
								
							} catch (CoursePlanException e) {
								System.out.println(e.getMessage());
							}
							adminCoursePlanMenu();
							break;
					    case 3: // get all cp details							
							try {
								List<CoursePlan> coursePlanList = daocp.getAllCoursePlanDetails();
								
								coursePlanList.forEach(c -> System.out.println(c));
								
							} catch (CoursePlanException e) {
								System.out.println(e.getMessage());
							}
							adminCoursePlanMenu();
					    	break;
					    case 4: // get all cp by status
					    	System.out.println("Enter the status you want to find courses for:");
							status = sc.nextLine();
							
							try {
								List<CoursePlan> cplist = daocp.getAllCoursePlansByStatus(status);
								
								cplist.forEach(cp -> System.out.println(cp));
								
							} catch (CoursePlanException e) {
								System.out.println(e.getMessage());
							}
							adminCoursePlanMenu();
					    	break;
					    case 5: // get cp of a course
					    	System.out.println("Enter the desires course id to get course plans:");
							courseId = sc.nextInt();
							sc.nextLine();
							
							try {
								List<CoursePlan> cplist = daocp.getAllCoursePlansOfACourse(courseId);
								
								cplist.forEach(cp -> System.out.println(cp));
								
							} catch (CoursePlanException e) {
								System.out.println(e.getMessage());
							}
							adminCoursePlanMenu();
					    	break;
					    case 6: // update batchid by planid
					    	System.out.println("Enter plan id you want to update the batch id for:");
					    	planId = sc.nextInt();
							
							System.out.println("Enter new batch id:");
							int batchId = sc.nextInt();
							sc.nextLine();
							
							result1 = daocp.updateBatchIdUsingPlanId(planId, batchId);
							
							System.out.println(result1);
							adminCoursePlanMenu();
					    	break;
					    case 7: // update courseid by planid
					    	System.out.println("Enter plan id you want to update the course id for:");
							planId = sc.nextInt();
							
							System.out.println("Enter new course id:");
							courseId = sc.nextInt();
							sc.nextLine();
							
							result1 = daocp.updateCourseIdUsingPlanId(planId, courseId);
							
							System.out.println(result1);
							adminCoursePlanMenu();
					    	break;
					    case 8: // update dayno. by pid
					    	System.out.println("Enter plan id you want to update the day number for:");
							planId = sc.nextInt();
							
							System.out.println("Enter new day number:");
							daynumber = sc.nextInt();
							
							sc.nextLine();
							
							result1 = daocp.updateDayNumberUsingPlanId(planId, daynumber);
							
							System.out.println(result1);
							adminCoursePlanMenu();
					    	break;
					    case 9: // update statsu using pid
					    	System.out.println("Enter plan id you want to update the status for:");
							planId = sc.nextInt();
							
							sc.nextLine();
							
							System.out.println("Enter new status:");
							status = sc.nextLine();
							
							result1 = daocp.updateStatusUsingPlanId(planId, status);
							
							System.out.println(result1);
							adminCoursePlanMenu();
					    	break;
					    case 10: // update topic using pid
					    	System.out.println("Enter plan id you want to update the topic for:");
							planId = sc.nextInt();
							
							sc.nextLine();
							
							System.out.println("Enter new topic:");
							topic = sc.nextLine();
							
							result1 = daocp.updateTopicUsingPlanId(planId, topic);
							
							System.out.println(result1);
							adminCourseMenu();
					    	break;
					    case 11: // to log out
					    	exit();
					    	flagcp=false;
					    	break;
					    case 12: // go to admin menu
					    	flagcpA = false;
					    	break;
						default:
							System.out.println("Invalid input.");
							adminCoursePlanMenu();
							break;
						}
						if(flagcp==false) {
							break;
						}
						if(flagcpA == true) {
							choiceCoursePlanMenu = sc.nextInt();
							sc.nextLine();
						}
						if(choiceCoursePlanMenu!=11) {
							flagcp = true;
						}
					}
					if(flagcp==false) {
					flagMain = false;
					}
					break;
				case 5:
					exit();
					flagMain=false;
					break;
				}
			}
			
			else {
				System.out.println("Invalid Credentials.");
				System.out.println("Enter your username:");
				aUsername = sc.next();
				sc.nextLine();
				System.out.println("Enter your password:");
				aPassword = sc.nextLine();
			}
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
		System.out.println("Press 5 & enter to log out.");
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
		System.out.println("Press 8 & enter to update course description by course name.");
		System.out.println("Press 9 & enter to update course name by course id.");
		System.out.println("Press 10 & enter to update course fee by course name.");
		System.out.println("Press 11 & enter to log out.");
		System.out.println("Press 12 & enter to go to admin menu.");
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
		System.out.println("Press 11 & enter to log out.");
		System.out.println("Press 12 & enter to go to admin menu.");
	}
	
	public static void adminFacultyMenu() {		
		System.out.println("Press 1 & enter to register a faculty.");
		System.out.println("Press 2 & enter to get address by faculty name.");
		System.out.println("Press 3 & enter to get all faculty details.");
		System.out.println("Press 4 & enter to get faculty by faculty id.");
		System.out.println("Press 5 & enter to get faculty by faculty name.");
		System.out.println("Press 6 & enter to update faculty address by faculty id.");
		System.out.println("Press 7 & enter to update faculty address by faculty name.");
		System.out.println("Press 8 & enter to update faculty email by faculty id.");
		System.out.println("Press 9 & enter to update faculty email by faculty name.");
		System.out.println("Press 10 & enter to update faculty mobile by faculty id.");
		System.out.println("Press 11 & enter to update faculty mobile by faculty name.");
		System.out.println("Press 12 & enter to update faculty name by faculty id.");
		System.out.println("Press 13 & enter to update faculty name by faculty name.");
		System.out.println("Press 14 & enter to log out.");
		System.out.println("Press 15 & enter to go to admin menu.");
	}
	
	public static void adminCoursePlanMenu() {		
		System.out.println("Press 1 & enter to create a course plan.");
		System.out.println("Press 2 & enter to get course plan by plan id.");
		System.out.println("Press 3 & enter to get all course plan details.");
		System.out.println("Press 4 & enter to get all course plans by status.");
		System.out.println("Press 5 & enter to get all course plans of a course.");
		System.out.println("Press 6 & enter to update batch id by plan id.");
		System.out.println("Press 7 & enter to update course id by plan id.");
		System.out.println("Press 8 & enter to update day number by plan id.");
		System.out.println("Press 9 & enter to update status by plan id.");
		System.out.println("Press 10 & enter to update topic by plan id.");
		System.out.println("Press 11 & enter to log out.");
		System.out.println("Press 12 & enter to go to admin menu.");
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
