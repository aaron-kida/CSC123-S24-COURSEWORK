import java.util.Scanner;

public class CoinCounter {

    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;

    // Constructor
    public CoinCounter(int totalCents) {
        this.quarters = totalCents / 25;
        totalCents %= 25;

        this.dimes = totalCents / 10;
        totalCents %= 10;

        this.nickels = totalCents / 5;
        totalCents %= 5;

        this.pennies = totalCents;
    }

    // Methods
    public int getDollarAmount() {
        int totalCents = quarters * 25 + dimes * 10 + nickels * 5 + pennies;
        return totalCents / 100;  // Convert cents to dollars
    }

    public int getCentsAmount() {
        int totalCents = quarters * 25 + dimes * 10 + nickels * 5 + pennies;
        return totalCents % 100;  // Extract the remaining cents
    }
  
    //user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the total amount in cents:");
        int totalCents = scanner.nextInt();

        CoinCounter coinCounter = new CoinCounter(totalCents);

        //result
        System.out.println("Total Amount: $" + coinCounter.getDollarAmount() + "." + coinCounter.getCentsAmount());
        System.out.println("Quarters: " + coinCounter.quarters);
        System.out.println("Dimes: " + coinCounter.dimes);
        System.out.println("Nickels: " + coinCounter.nickels);
        System.out.println("Pennies: " + coinCounter.pennies);
    }
}


