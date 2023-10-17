package MadLibs;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class MadLibs {
	private static ArrayList<Strings> adjs, advs, pastVerbs, pluNouns, pluVerbs, singNouns, singVerbs;
	private Random rnd;
	public static void createWordLists() {
		singNouns = new arrayList<Strings>();
	}
	public static boolean loadWordLists(String Folder) {
		try {
			Scanner fsc;
			fsc = new Scanner(new File(folder,"story" + storyNum + ".txt"));	
		}catch (Exception ex) {
			return null;
		}
	} 
	public static void printWelcome() {
		System.out.println("*" .repeat(60));
		System.out.println(" " .repeat(15) + "Welcome to MadLibs V1.0");
		System.out.println("*" .repeat(60));
		System.out.print("\n");
}
	public static void main(String[] args) {
		rnd = new Random();
		printWelcome();
		System.out.println("Enter the name of the folder where the stories and wordslists are.");
	}
}
