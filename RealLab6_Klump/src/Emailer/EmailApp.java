package Emailer;
import java.util.ArrayList;
import java.util.Scanner;

public class EmailApp {
	// This is where the Welcome banner is displayed 
	public static void printWelcome() {
		System.out.println("*" .repeat(60));
		System.out.println(" " .repeat(15) + "Welcome to TextAnalyzer V1.0");
		System.out.println("*" .repeat(60));
		System.out.print("\n");
		}
	//This is where the Menu banner is displayed
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
	// this is where the main string where all the banners will be displayed
	public static void main (String args[]) {
		printWelcome();
		Scanner sc = new Scanner(System.in);
		ArrayList<Email> emails = new ArrayList<Email>();
		int choice = 0;
		// This do statement makes sure to repeatedly ask the user for a correct input and properly breaks away when needed
		do {
			choice = printMenu();
				if (choice > 5) {
					System.out.println("That is not a valid choice\n");
				}else if  (choice == 1) {
					System.out.println("Enter recipients' email: ");
					String[] recipientsArray = sc.nextLine().split(",");
					ArrayList<String> recipients = new ArrayList<String>();
					for(String recipient : recipientsArray) {
						recipients.add(recipient);
					}
					System.out.print("Enter Subject: ");
					String subject = sc.nextLine();
					System.out.print("Enter Body: ");
					String body = sc.nextLine();
					Email email = new Email(subject,body,recipients);
					emails.add(email);
					System.out.println("\n");
				}else if (choice == 2) {
					EmailPrinter.printToScreen(emails);
				}else if (choice == 3) {
					for(Email email : emails) {
						email.send();
					}
					System.out.println("All emails have been sent.\n");
				}else if (choice == 4) {
					System.out.println("Enter the name of the file to save: ");
					String fileName = sc.next();
					EmailPrinter.printToFile(emails,fileName);
					
				}else if (choice == 5) {
					System.out.println("\nThank you for using this program.");
					break;
				} 
		} while (choice != 5);
	}
}
