// Aaron Hoang (ahoang14@toromail.csudh.edu)

import java.util.Scanner;

public class ChangeMaker {
	public static void main(String[] args) {
	
	Scanner keyboard = new Scanner(System.in);
	
		int dollars=0;
		int quarters=0;
		int dimes=0;
		int nickels=0;
		int pennies=0;
		int cents=0;

		System.out.print("How many dollar(s): ");
		dollars = keyboard.nextInt();
		System.out.print("How many Cent(s): ");
		cents = keyboard.nextInt();


		if((dollars<0)||(cents<0)) {
			System.out.println("Negative input is invalid!\nPick a valid number");
			System.out.print("\nDollar: ");
			dollars = keyboard.nextInt();
			System.out.print("Cents: ");
			cents = keyboard.nextInt();

		}

		pennies=cents+dollars*100;
		quarters=pennies/25;
		pennies=pennies%25;
		dimes=pennies/10;
		pennies=pennies%10;
		nickels=pennies/5;
		pennies=pennies%5;

		System.out.println("\n\nYou have: "+quarters+ " quarters, "+dimes+" dimes, "+nickels+" nickels and  "+pennies+" pennies");
		
	}
}