package ApartmentPainter;

// Created SOLEY By: Nicolas Delgado
// Klump Assignment

public class ApartmentPainter {
	public static void main (String[] args) {
		
		double longWidth = 32.75;
		double narrowWidth = 25.62;
		double ceilingHeight = 10;
		int unit = 8;
		
		
		double windowWidth = 14.4;
		double windowLength = 5.5;
	
		double doorWidth = 3.25;
		double doorLength = 8;
		
		int paintPerPack = 1;
		double paintCoverage = 400;
		double paintPrice = 34.99;
		
		int primerPerPack = 1;
		double primerCoverage = 300;
		double primerPrice = 24.49;
		
		
		// Calculations
		
		double wallArea = (2 * (longWidth*ceilingHeight)+ 2 * (narrowWidth*ceilingHeight));
		double windowArea = (windowWidth * windowLength);
		double doorArea = (doorWidth * doorLength);
		double ceilingArea =(longWidth * narrowWidth);
		double totalArea =((wallArea)-(windowArea)-(doorArea));
		double totalUnitArea  = (totalArea + ceilingArea) * unit;
		

		int paintGallonsNeeded = (int) Math.ceil(totalUnitArea / paintCoverage);
		int primerGallonsNeeded = (int) Math.ceil(totalUnitArea / primerCoverage);
		double primerCost = (primerGallonsNeeded * primerPrice); 
		double paintCost = (paintGallonsNeeded * paintPrice);

		double totalCost = (primerCost + paintCost);
		
		
		

	System.out.print("*******************************");
	System.out.print("\n Wall area per unit: " + String.format("%.2f",totalArea));
	System.out.print("\n Ceiling area per unit: " + String.format("%.2f",ceilingArea));
	System.out.print("\n Total area to paint and prime: " + String.format("%.2f",totalUnitArea));
	System.out.print("\n");
	System.out.print("\n You must purchase " + paintGallonsNeeded + " gallons of Paint for $" + String.format("%.2f",paintCost));
	System.out.print("\n You must purchase " + primerGallonsNeeded + " gallons of Primer for $" + String.format("%.2f",primerCost));
	System.out.print("\n");
	System.out.print("\n Your total cost to paint and prime all units is $" + String.format("%.2f",totalCost));
	System.out.print("\n ********************************");
	}
}
	
