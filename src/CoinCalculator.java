// Aaron Hoang (ahoang14@toromail.csudh.edu)

import java.util.Scanner;

public class CoinCalculator {
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter the number of pennies: ");
        int pennies = keyboard.nextInt();

        System.out.print("Please enter the number of nickels: ");
        int nickels = keyboard.nextInt();

        System.out.print("Please enter the number of dimes: ");
        int dimes = keyboard.nextInt();

        System.out.print("Please enter the number of quarters: ");
        int quarters = keyboard.nextInt();

        // Calculate total amount
        int totalCents = (pennies * 1) + (nickels * 5) + (dimes * 10) + (quarters * 25);
        int dollars = totalCents / 100;
        int cents = totalCents % 100;

        // Display the result
      
        System.out.printf("You have %d dollar(s) and %d cent(s).\n", dollars, cents);
    }
}

