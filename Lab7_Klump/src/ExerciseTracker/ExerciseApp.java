package ExerciseTracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ExerciseApp {
	/**
	 * This is where the print welcome is
	 */
		public static void printWelcome() {
			System.out.println("*" .repeat(60));
			System.out.println(" " .repeat(15) + "Welcome to Exercise Tracker V1.0");
			System.out.println("*" .repeat(60));
			System.out.print("\n");
			}
	/**
	 * This is where the options are listed and be chosen
	 * @return
	 */
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
		/**
		 * Here is all the functions and variables which will be asked to the user
		 * @param sc
		 * @return This returns the questions and stores the answers
		 */
		public static Exercise createNewExercise(Scanner sc) {
			
			Exercise exercise = null;
			System.out.print("Describe you workout:\n");
			System.out.println("Enter R for run/walk, W for weightlifting, or C for rock climbing");
			String workout = sc.nextLine();
			if(workout.equalsIgnoreCase("R")) {
				System.out.println("Enter a name for the workout: ");
				String runName = sc.nextLine();
				System.out.println("Enter a date for the workout (MM/DD/YYYY): ");
				String runDate = sc.nextLine();
				System.out.println("How long did you work out for in minutes: ");
				int runMin = sc.nextInt();
				System.out.println("Enter a distance you ran in miles: ");
				Double runDist = sc.nextDouble();
				System.out.println("Enter a comment about the workout: \n");
				String runCom = sc.next();
				exercise = new RunWalk(runName , runDate , runMin , runDist , runCom);
			} else if (workout.equalsIgnoreCase("W")) {
				System.out.println("Enter a name for the workout: ");
				String weightName = sc.nextLine();
				System.out.println("Enter a date for the workout (MM/DD/YYYY): ");
				String weightDate = sc.nextLine();
				System.out.println("How long did you work out for in minutes: ");
				int weightMin = sc.nextInt();
				System.out.println("Enter a total weight lifted in pounds: ");
				Double weightPound = sc.nextDouble();
				System.out.println("Enter a comment about the workout: \n");
				String weightCom = sc.next();
				exercise = new WeightLifting(weightName , weightDate , weightMin , weightPound , weightCom);
			} else if(workout.equalsIgnoreCase("C")) {
				System.out.println("Enter a name for the workout: ");
				String rockName = sc.nextLine();
				System.out.println("Enter a date for the workout (MM/DD/YYYY): ");
				String rockDate = sc.nextLine();
				System.out.println("How long did you work out for in minutes: ");
				int rockMin = sc.nextInt();
				System.out.println("Enter the height of the wall in feet: ");
				Double rockHeight = sc.nextDouble();
				System.out.println("Enter the number of times you climbed it: ");
				int rockReps = sc.nextInt();
				System.out.println("Enter a comment about the workout: \n");
				String rockCom = sc.next();
				exercise = new RockClimbing(rockName , rockDate , rockMin , rockHeight , rockReps , rockCom);
			} else {
				System.out.print("Enter a valid choice");
				}
			return exercise;
		}
		
		/**
		 * These are where the effects of the options you select will happen. i.e 5 will quit the function and 1 will add an exercise.
		 * @param args
		 */
		public static void main (String args[]) {
			ArrayList<Exercise> exercises = new ArrayList<Exercise>();
			printWelcome();
			Scanner sc = new Scanner(System.in);
			int choice = 0;
			
			do {
				choice = printMenu();
					if (choice > 5) {
						System.out.println("That is not a valid choice\n");
					}else if  (choice == 1) {
						Exercise exercise = createNewExercise(sc);
						exercises.add(exercise);
					}else if (choice == 2) {
						System.out.println("Enter the name of the file to save: ");
						String fileName = sc.next();
						ExerciseWriter.printToFile(exercises,fileName);
					}else if (choice == 3) {
						Collections.sort(exercises);
						ExerciseWriter.tabulateSummary(exercises);
					}else if (choice == 4) {
						Collections.sort(exercises, new CompareExerciseByCalories());
						ExerciseWriter.tabulateSummary(exercises);
					}else if (choice == 5) {
						System.out.println("Thank you for using this program and Stay Healthy!");
						break;
					} 
			} while (choice != 5);
		}
	}
