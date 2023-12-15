package XtraCredit;
import java.util.ArrayList;
import XtraCredit.Encounters;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class AnimalWriter {
	/**
	 * prints data to the screen
	 */
	public static void printToScreen(ArrayList<Encounters> animals) {
		for (Encounters animal: animals) {
			System.out.println(animal);
		}
	}
	public static boolean printToFile(ArrayList<Encounters> animals, String fileName) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName))));
			for (Encounters animal: animals) {
				pw.println(animal);
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	public static void tabulateSummary(ArrayList<Encounters> animals) {
		for (Encounters animal: animals) {
			System.out.println(animal.toSummaryString());
		}
	}
	public static boolean writeToFile(File f, ArrayList<Encounters> animals) {
		// TODO Auto-generated method stub
		return false;
	}
}
