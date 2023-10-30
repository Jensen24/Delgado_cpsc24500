package Emailer;

import java.util.Scanner;

public class Emailer {
	
	public static void printWelcome() {
		System.out.println("*" .repeat(60));
		System.out.println(" " .repeat(15) + "Welcome to TextAnalyzer V1.0");
		System.out.println("*" .repeat(60));
		System.out.print("\n");
		}
	public static int printMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Here are your options:");
		System.out.println("1. Write Email.");
		System.out.println("2. List Emails.");
		System.out.println("3. Send Emails.");
		System.out.println("4. Save Emails To File.");
		System.out.println("5. Quit");	
		System.out.println("Enter the number of your choice: ");
		if (scan.hasNextInt()) {
			return scan.nextInt();
		} else {
			System.out.println("You have to enter the number of your choice. You didn't type a number.\n");
			return printMenu();
		}
	}
	public static void main (String args[]) {
		printWelcome();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		String rEmail , Sub , Body;
		do {
			choice = printMenu();
				if (choice > 5) {
					System.out.println("That is not a valid choice\n");
				}else if  (choice == 1) {
					System.out.println("Enter recipients' email: ");
					rEmail = sc.nextLine();
					System.out.println("Enter Subject: ");
					Sub = sc.nextLine();
					System.out.println("Enter Body: ");
					Body = sc.nextLine();
					System.out.println("\n");
				}else if (choice == 2) {
					System.out.println();
				}else if (choice == 3) {
					System.out.println();
				}else if (choice == 4) {
					System.out.println();
				}else if (choice == 5) {
					System.out.println("\nThank you for using this program.");
					break;
				} 
		} while (choice != 5);
	}
}
