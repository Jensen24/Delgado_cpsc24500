package Emailer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EmailPrinter {

	public  static void printToScreen (ArrayList<Email> emails) {
		for(Email email : emails) {
			System.out.println(email);
		}
	}
	
	public static void printToFile(ArrayList<Email> emails, String fileName) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName))));
			
			for(Email email : emails) {
				pw.println(email.toFileFriendlyString());
			}
			pw.close();
			System.out.println("Emails were saved successfully.\n");
		} catch (Exception ex) {
			System.out.println("There was an error");
		}
	}
}