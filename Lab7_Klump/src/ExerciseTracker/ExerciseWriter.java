package ExerciseTracker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ExerciseWriter {

	public static void printToScreen (ArrayList<Exercise> exercises) {
		for(Exercise exercise : exercises) {
			System.out.println(exercise);
		}
	}
	
	public static void printToFile(ArrayList<Exercise> exercises, String fileName) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName))));
			
			for(Exercise exercise : exercises) {
				pw.println(exercise);
			}
			pw.close();
			System.out.println("Exercises were saved successfully.\n");
		} catch (Exception ex) {
			System.out.println("There was an error");
		}
	}
	/**
	 * This displays the top portion of the summary list and columns
	 * @param exercises
	 */
	 public static void tabulateSummary(List<Exercise> exercises) {

	        System.out.printf("\n|%5s|%5s|%5s|%5s\n","Type","Name","Date","Calories");
	        System.out.println("-----------------------------------------------------------------------------");

	        for (Exercise ex : exercises) {
	        	System.out.print(ex);
	           
	        }

	    }
	}

