package ExerciseTracker;

import java.util.ArrayList;
import java.util.Scanner;

public class ExerciseApp {
	// This is where the Welcome banner is displayed 
		public static void printWelcome() {
			System.out.println("*" .repeat(60));
			System.out.println(" " .repeat(15) + "Welcome to Exercise Tracker V1.0");
			System.out.println("*" .repeat(60));
			System.out.print("\n");
			}
		//This is where the Menu banner is displayed
		public static int printMenu() {
			Scanner scan = new Scanner(System.in);
			System.out.println("Here are your options:");
			System.out.println("1. Add an exercise");
			System.out.println("2. Print exercises to file.");
			System.out.println("3. List sorted by date");
			System.out.println("4. List sorted by calories burned");
			System.out.println("5. Quit");	
			System.out.println("Enter the number of your choice: ");
			if (scan.hasNextInt()) {
				return scan.nextInt();
			} else {
				System.out.println("You have to enter the number of your choice. You didn't type a number.\n");
				return printMenu();
			}
		}
		// this is where the main string where all the banners will be displayed
		public static void main (String args[]) {
			printWelcome();
			Scanner sc = new Scanner(System.in);
			int choice = 0;
			// This do statement makes sure to repeatedly ask the user for a correct input and properly breaks away when needed
			do {
				choice = printMenu();
					if (choice > 5) {
						System.out.println("That is not a valid choice\n");
					}else if  (choice == 1) {
					}else if (choice == 2) {
					}else if (choice == 3) {
					}else if (choice == 4) {
					}else if (choice == 5) {
						System.out.println("Thank you for using this program and Stay Healthy!");
						break;
					} 
			} while (choice != 5);
		}
	}
