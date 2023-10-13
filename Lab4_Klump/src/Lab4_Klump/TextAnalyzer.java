package Lab4_Klump;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 
 * Listed below are the print statements that are for the welcome and menu
 * The I have the main string where all the magic happens
 * Finally at the bottom is where the functions that are to be called are waiting patiently
 * Created Soley By: Nick Delgado
 *
 */

public class TextAnalyzer {
	public static void printWelcome() {
		System.out.println("*" .repeat(60));
		System.out.println(" " .repeat(15) + "Welcome to TextAnalyzer V1.0");
		System.out.println("*" .repeat(60));
		System.out.print("\n");
}
	public static int printMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Here are your options:");
		System.out.println("1. Count the number of vowels.");
		System.out.println("2. Count the number of consonats.");
		System.out.println("3. Count the number of words.");
		System.out.println("4. Print a summary to a file.");
		System.out.println("5. Quit");	
		System.out.println("Enter the number of your choice: ");
		if (scan.hasNextInt()) {
			return scan.nextInt();
		} else {
			System.out.println("You have to enter the number of your choice. You didn't type a number.\n");
			return printMenu();
		}
	
		
	}
	public static void  main(String args[]) {
		printWelcome();
		Scanner sc = new Scanner(System.in);
		System.out.println("What text file would you like to analyze? ");
		String file = sc.next().toLowerCase();
		String story = readFile(file);
		boolean summaryPrinted = false;
		System.out.print("\n");
		System.out.print("\n");
		int choice = 0;
		String name;
		String vowels;
		do {
				choice = printMenu();
					if (choice > 5) {
						System.out.println("That is not a valid choice\n");
					}else if  (choice == 1) {
						System.out.println("There are " + countVowels(story) + " vowels\n");
					}else if (choice == 2) {
						System.out.println("There are " + countConsonants(story) + " consonants\n");
					}else if (choice == 3) {
						System.out.println("There are " + countWords(story)+ " words\n");
					}else if (choice == 4) {
						System.out.println("Enter the name of the file to write the summary: ");
						story = sc.next();
						System.out.println("The summary was written to a file \n");
					}else if (choice == 5) {
						System.out.println("Thank you for using this program.");
						break;
					} 

			} while (choice != 5);
}
	public static int countVowels(String story) {
		int countVowels = 0;
		String lowerStory = story.toLowerCase();
		for (int i = 0 ; i < lowerStory.length(); i++) {
			char ch = lowerStory.charAt(i);
				if (lowerStory.charAt(i) == 'a' | lowerStory.charAt(i) == 'e' | lowerStory.charAt(i) == 'i' | lowerStory.charAt(i) == 'o' | lowerStory.charAt(i) == 'u') {
					countVowels += 1;
				}
		}return countVowels;
	}
	public static int countConsonants(String story) {
		int countConsonants = 0;
		String lowerStory = story.toLowerCase();
		for (int i = 0 ; i < lowerStory.length() ; i++) {
			if (lowerStory.charAt(i) != 'a' && lowerStory.charAt(i) != 'e' && lowerStory.charAt(i) != 'i' && lowerStory.charAt(i) != 'o' && lowerStory.charAt(i) != 'u' && lowerStory.charAt(i) != ' ' && lowerStory.charAt(i) != '.' && lowerStory.charAt(i) != ',' && lowerStory.charAt(i) != '"' && lowerStory.charAt(i) != '\'') {
				countConsonants += 1;
			}
		}return countConsonants;
		
	}
	public static int countWords(String story) {
		String[] words = story.split("\\W+");
		return words.length;
	}
//	public static void writeSummaryToFile() {
		
	//}
	public static String readFile(String file) {
		String story = " ";
		try {
			try (Scanner fsc = new Scanner(new File(file))){
				while (fsc.hasNextLine()) {
					story = story + fsc.nextLine() + "";
				}
				return story;
			}
		}catch (FileNotFoundException ex) {
			System.out.println("Something went Wrong");
			System.out.println(ex);
			return null;
		}
	}
}
