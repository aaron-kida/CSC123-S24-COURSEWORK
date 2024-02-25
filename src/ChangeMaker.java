import java.util.Scanner;

public class ChangeMaker {

    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;

    // Constructor
    public ChangeMaker(int dollars, int cents) {
        int totalCents = dollars * 100 + cents;

        this.quarters = totalCents / 25;
        totalCents %= 25;

        this.dimes = totalCents / 10;
        totalCents %= 10;

        this.nickels = totalCents / 5;
        totalCents %= 5;

        this.pennies = totalCents;
    }

    // Method to get number of quarters
    public int getQuarters() {
        return this.quarters;
    }

    // Method to get number of dimes
    public int getDimes() {
        return this.dimes;
    }

    // Method to get number of nickels
    public int getNickels() {
        return this.nickels;
    }

    // Method to get number of pennies
    public int getPennies() {
        return this.pennies;
    }

    public static void main(String[] args) {
        // Ask for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total amount in dollars: ");
        int dollars = scanner.nextInt();
        System.out.print("Enter the total amount in cents: ");
        int cents = scanner.nextInt();

        // Create a ChangeMaker object
        ChangeMaker changeMaker = new ChangeMaker(dollars, cents);

        // Display the result
        System.out.println("Quarters: " + changeMaker.getQuarters());
        System.out.println("Dimes: " + changeMaker.getDimes());
        System.out.println("Nickels: " + changeMaker.getNickels());
        System.out.println("Pennies: " + changeMaker.getPennies());
    }
}
