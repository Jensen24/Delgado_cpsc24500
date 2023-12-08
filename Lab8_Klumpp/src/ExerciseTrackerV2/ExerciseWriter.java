package ExerciseTrackerV2;

import java.util.ArrayList;

import ExerciseTrackerV2.Exercise;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class ExerciseWriter {
	/**
	 * prints data to the screen
	 */
	public static void printToScreen(ArrayList<Exercise> exercises) {
		for (Exercise exercise: exercises) {
			System.out.println(exercise);
		}
	}
	public static boolean printToFile(ArrayList<Exercise> exercises, String fileName) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName))));
			for (Exercise exercise: exercises) {
				pw.println(exercise);
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	public static void tabulateSummary(ArrayList<Exercise> exercises) {
		for (Exercise exercise: exercises) {
			System.out.println(exercise.toSummaryString());
		}
	}
	public static boolean writeToFile(File f, ArrayList<Exercise> exercises) {
		// TODO Auto-generated method stub
		return false;
	}
}
