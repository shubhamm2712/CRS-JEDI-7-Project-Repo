/**
 * 
 */
package com.crs.flipkart.application;

import java.util.Scanner;

import com.crs.flipkart.bean.*;
import com.crs.flipkart.business.UserInterface;
import com.crs.flipkart.business.UserService;

/**
 * @author Shubham
 *
 */
public class CRSApplication {

	/**
	 * @param args
	 */

	static boolean loggedIn = false;
	UserInterface userService = new UserService();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Main screen will have 4 things

		Scanner sc = new Scanner(System.in);
		CRSApplication crsApplication = new CRSApplication();
		int choice;
		do {
			System.out.print(
					"\n\n\n---------------------WELCOME-----------------\n1. Login\n2. Student Registration\n3. Update Password\n4. Exit\nOption : ");
			choice = sc.nextInt();
			switch (choice) {
			case 1: // Login
				crsApplication.login();
				break;
			case 2: // Student registration
				crsApplication.registerStudent();
				break;
			case 3: // update password
				break;
			case 4: // exit
				break;
			default:
				System.out.print("Invalid option\n");
			}
		} while (choice != 4);
	}

	public void login() {
		Scanner sc = new Scanner(System.in);

		System.out.print("-----------------Login------------------\n");

		String email, password;
		System.out.print("Email:");
		email = sc.next();
		System.out.print("Password:");
		password = sc.next();
		User user = userService.login(email, password);
		

		if (user!=null) {
			CRSApplication.loggedIn=true;
			switch (user.getRole()) {
			case 0:
				// Admin functionality
				break;
			case 1:
				// Professor functionality
				break;
			case 2:
				String studentId = user.getUserId();
				boolean isApproved = true;// studentInterface.isApproved(studentId);
				if (isApproved) {
					CRSStudent student = new CRSStudent();
					student.create_menu(studentId);

				} else {
					System.out.print("Failed to login, you have not been approved by the administration!");
					loggedIn = false;
				}
				break;
			}

		} else {
			System.out.print("Invalid Credentials!");
		}

	}

	public void registerStudent() {
		Scanner sc = new Scanner(System.in);

		String email, name, password, branchName, batch;
		// input all the student details
		System.out.print("---------------Student Registration-------------\n");
		System.out.print("Name:");
		name = sc.nextLine();
		System.out.print("Email:");
		email = sc.next();
		System.out.print("Password:");
		password = sc.next();
		sc.nextLine();
		System.out.print("Branch:");
		branchName = sc.nextLine();
		System.out.print("Batch:");
		batch = sc.nextLine();

		System.out.println(userService.registerStudent(name,email, password, branchName, batch));

	}

}
