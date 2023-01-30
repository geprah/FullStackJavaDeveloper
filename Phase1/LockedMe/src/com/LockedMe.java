package com;

import java.io.File;
import java.util.Arrays;

import java.util.Scanner;

public class LockedMe {
	private static Scanner sc = new Scanner(System.in);

	public static Scanner getSc() {
		return sc;
	}

	public static void welcomeScreen() {
		System.out.println("Press 1 to list file names in ascending order");
		System.out.println("Press 2 to perform file operations");
		System.out.println("Press 3 to exit");
		System.out.println("");
	}

	public static void main(String[] args) {
		System.out.println("******************************");
		System.out.println("*********LockedMe.com*********");
		System.out.println("*********by George Prah*******");
		System.out.println("***george.prah@vodafone.com***");
		System.out.println("******************************");

		File[] fileList;
		int choice = 0; //assigning local variable 0 

		while (choice != 3) { //loop while user selection is not option 3 to exit
			welcomeScreen();
			System.out.print("Please select 1 - 3: ");

			try {

				choice = sc.nextInt();

				switch (choice) {
				case 1:

					System.out.println("");
					System.out.println("Listing "+System.getProperty("user.dir")+" content in ascending order!");
					System.out.println("");

					fileList = new File(System.getProperty("user.dir")).listFiles();
					Arrays.sort(fileList); //implements legacy merge sort
					for (File f : fileList) { 
						System.out.println(f.getName());
					}
					System.out.println("");
					System.out.println("File listing completed successfully");
					System.out.println("");
					break;
				case 2:
					FileOperations.fileOperationsPrompt();
					break;
				case 3:
					System.out.println("Exiting!");

					break;
				default:
					System.out.println("");
					System.out.println("");
					System.out.println("Invalid option selected!...");
					System.out.println("");
					System.out.println("");

				}
			} catch (Exception e) {
				System.out.println("Please make sure to choose a number between 1 to 3");
				getSc().next();
			}
		}
	}
}
