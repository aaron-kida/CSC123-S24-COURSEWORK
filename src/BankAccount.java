public class BankAccount {

    // Declare instance fields
    private String ownerFirstName;
    private String ownerLastName;
    private double balance;
    private boolean isOpen;

    // Constructor
    public BankAccount(String ownerFirstName, String ownerLastName, double initialDepositAmount) {
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.balance = initialDepositAmount;
        this.isOpen = true;
    }

    // Method to deposit money
    public boolean deposit(double amount) {
        if (isOpen && amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    // Method to withdraw money
    public boolean withdraw(double amount) {
        if (isOpen && amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Method to check if the account is open
    public boolean isOpen() {
        return isOpen;
    }

    // Method to close the account
    public void close() {
        isOpen = false;
    }

    // Method to get the owner's full name
    public String getOwnerFullName() {
        return ownerFirstName + " " + ownerLastName;
    }
}
