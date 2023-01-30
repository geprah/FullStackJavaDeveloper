package com;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class FileOperations {
	public static void fileOperationsPrompt() {

		int fileOperationChoice = 0; //initialized local variable to 0
		
		while (fileOperationChoice != 4) {
			
			System.out.println("");
			System.out.println("Press 1 to add a file");
			System.out.println("Press 2 to delete a file");
			System.out.println("Press 3 to search for a file");
			System.out.println("Press 4 to go back to main context");
			System.out.print("Please select 1 - 4: ");
			
			try {
			fileOperationChoice = LockedMe.getSc().nextInt();
			String filename;
			File myObj;

			switch (fileOperationChoice) {
			case 1:
				System.out.print("Enter the file name: ");
				filename = LockedMe.getSc().next();
				try {
					myObj = new File(filename);
					if (myObj.createNewFile()) {

						System.out.println("");
						System.out.println("File '" + myObj.getName()+"' created.");
						System.out.println("");
					} else {

						System.out.println("");
						System.out.println("File '"+myObj.getName()+"' already exists.");
						System.out.println("");
					} 
				} catch (SecurityException e) {
					System.out.println("");
					System.out.println("File cannot be created in current directory.");
					System.out.println("Please consult techncal support!.");
					System.out.println("");

				} catch (IOException e) {
					System.out.println("");
					System.out.println("File creation failed.");
					System.out.println("Please consult techncal support!.");
					System.out.println("");
				} 
				break;
			case 2:
				
				System.out.print("Enter the file name: ");
				filename = LockedMe.getSc().next();
				try {
					myObj = new File(filename);
					if (myObj.isFile()) {
						if (myObj.delete())
							System.out.println(filename + " deleted..... ");
						else
							System.out.println(filename + " not deleted..... ");
					} else {
						System.out.println("File is not a regular file or may not exit");
					}
				} catch (SecurityException e) {
					System.out.println("File cannot be deleted from current directory.");
					System.out.println("Please consult techncal support!.");
				}

				break;
			case 3:
				System.out.println("Searching file");
				System.out.println("Enter the file name");
				filename = LockedMe.getSc().next();

				myObj = new File(filename);
				File[] fileList = new File(System.getProperty("user.dir")).listFiles();
				ArrayList<String> foundList = new ArrayList<String>();

				for (File fn : fileList) { //implementing linear search
					if (fn.getName().equalsIgnoreCase(filename))
						foundList.add(fn.getName());
				}
				if (foundList.size() == 0) {
					System.out.println("No such file found!");
				} else {
					System.out.println("Files found:");
					for (String f : foundList) {
						System.out.println(f);
					}
				}
				break;
				
			case 4:
				System.out.println("");
				break;
				
			default:
				System.out.println("");
				System.out.println("");
				System.out.println("Invalid option selected!...");
				System.out.println("");
				System.out.println("");
				break;
			}
		}catch (InputMismatchException e) {
			System.out.println("");
			System.out.print("Please enter valid input from 1 - 4: ");
			//System.out.println("");
			LockedMe.getSc().next();
		}
			}
	}
}
