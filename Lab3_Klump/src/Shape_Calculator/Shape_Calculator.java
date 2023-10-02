package Shape_Calculator;
import java.util.Scanner;

/**
 * Shape Calculator
 * Math calculation that are suported: Rectangle, Circle, Triangle.
 * Created By: Nicolas Delgado
 */


public class Shape_Calculator {
	public static void printWelcome() {
		System.out.println("*" .repeat(60));
		System.out.println(" " .repeat(22) + "Shape Calculator");
		System.out.println("*" .repeat(60));
		System.out.print("\n");
		/**
		 * This is the welcome banner function that plays at the beginning of the main string
		 */
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		String rec = "R";
		String cir = "C";
		String tri = "T";
		String qui = "Q";
		double radius, areaC, circum;
		double length, width, areaR, perimeterR;
		double num1, num2, num3, areaT, perimeterT;
		printWelcome();
		/**
		 * All the functions below ask the user for what they want their variables to be and which shape they would like to use.
		 */
		do {
			System.out.printf("Enter C for circle, R for rectangle, or T for triangle: ");
			input = sc.next().toUpperCase();
			if (input.equals("C")) {
				System.out.println("Enter the Radius: ");
				radius = sc.nextDouble();
				mathCir(radius);
			} else if (input.equals("R")) {
				System.out.println("Enter the Length and Width: ");
				length = sc.nextDouble();
				width = sc.nextDouble();
				mathRec(width, length);
			} else if (input.equals("T")) {
				System.out.println("Enter the lengths of the three sides: ");
				num1 = sc.nextDouble();
				num2 = sc.nextDouble();
				num3 = sc.nextDouble();
				mathTri(num1, num2, num3);
			} else if (input.equals("Q")) {
				System.out.println("Thank you for using Shape Calculator!");
				return;
			}
			} while (input != "Q"); {
				System.out.println("That is not a recognized shape.");
		}
	}
	/**
	 * All the functions underneath are related to their respective shapes.
	 */
	public static void mathCir(double radius) {
			double areaC = (Math.PI * Math.pow(radius, 2));
			double circum = (2 * Math.PI * radius);
			System.out.println("The area of the circle is " + String.format("%.2f",areaC) + ", and the circumference is " + String.format("%.2f",circum) + ".");
		}
	
	public static void mathRec(double width, double length) {
			double areaR = (width * length);
			double perimeterR = 2 * (length + width);
			System.out.println("The area of the rectangle is " + String.format("%.2f",areaR) + ", and the perimeter is " + String.format("%.2f",perimeterR) + ".");
	}
	public static void mathTri(double num1, double num2, double num3) {
			double sum = (num1 + num2 + num3) / 2;
			double areaT = (Math.sqrt(sum * (sum - num1) * (sum - num2) * (sum - num3)));
			double perimeterT = (num1 + num2 + num3);
			System.out.println("The area of the triangle is " + String.format("%.2f",areaT) + ", and the perimeter is " + String.format("%.2f",perimeterT) + ".");
	}
}