package Payday.java;

import java.util.Scanner;
import java.util.Random;
public class Payday {
	/**
	 * 
	 * THIS DOCUMENT IS CREATED BY NICOLAS DELGADO ONLY
	 * @param args
	 */
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		String name;
		double hoursWorked;
		double hourPay;
		String member;
		double withHold;
		
		System.out.print("\n**********************************");
		System.out.print("\n           Payday V1.0");
		System.out.print("\n**********************************");
		System.out.print("\n");
		System.out.print("\nEnter name:" );
		name = sc.nextLine();
		System.out.print("\nEnter hours worked: " );
		hoursWorked = sc.nextDouble();
		System.out.print("\nEnter hourly pay rate: ");
		hourPay = sc.nextDouble();
		System.out.print("\nAre you a union member (y or n)? ");
		member = sc.nextLine();
		sc.nextLine();
		System.out.print("\nWhat percentage do you want to withhold for your medical savings account? ");
		withHold = sc.nextDouble();
		System.out.print("\n");
		
		double grossPay = (hoursWorked * hourPay);
		double unionDues = 0;
		if (member.equals("y")) {
			unionDues = (grossPay * 0.05);
		}
		else {
			 unionDues = (0);
		}
		double holdAmount;
		holdAmount = (withHold/100);
		double medDeduct = (grossPay * holdAmount);
		
		double incidentPay;
		incidentPay = rand.nextInt(401) - 200;
		
		double adjustGross;
		adjustGross = (grossPay - unionDues) - (medDeduct) - (incidentPay);
		
		double taxes;
		if (adjustGross >= 2500) {
			taxes = (adjustGross * 0.25);
		}
		else if (adjustGross > 1500) {
			taxes = (adjustGross * 0.15);
		}
		else if (adjustGross > 500) {
			taxes = (adjustGross * 0.10);
		}
		else {
			taxes = (adjustGross * 0.05);
		}
		
		double netPay;
		netPay = (adjustGross - taxes);
		
		System.out.println("\n---------Paycheck---------");
		System.out.printf("\nGross Pay  $" + "" + String.format("%10.2f",grossPay));
		System.out.printf("\nUnion Dues  $" + "" + String.format("%10.2f",unionDues));
		System.out.printf("\nMed Deduction  $" + "" + String.format("%10.2f",medDeduct));
		System.out.printf("\nIncident Pay  $" + "" + String.format("%10.2f",incidentPay));
		System.out.printf("\nTaxes  $"+ "" + String.format("%10.2f",taxes));
		System.out.printf("\nNet Pay  $" + "" + String.format("%10.2f",netPay));
		System.out.println("\n--------------------------");
		System.out.printf("\nPrepared for " + name);
		System.out.print("\n");
		System.out.print("\n");
		System.out.printf("\nThank You For Using This Program");
	}

}
