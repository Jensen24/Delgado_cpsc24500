package XtraCredit;

import java.util.ArrayList;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;

public class WriteToFile {
	
	public void saveTxtFile(ArrayList<Encounters> animals, String filePath) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(filePath))));
			for(Encounters animal : animals) {
				pw.println(animal);
			}
			pw.close();
			System.out.println("File was saved successfully.\n");
		} catch (Exception ex) {
			System.out.println("Oops! There was an error");
		}
	}
	public static void saveXMLFile(ArrayList<Encounters> animals, String filePath) {
		try {
			XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(new File(filePath))));
			enc.writeObject(animals);
			enc.close();
			System.out.println("File was saved successfully.\n");
			
		} catch (Exception ex) {
			System.out.println("Oops! There was an error");
		
		}
	}
}

