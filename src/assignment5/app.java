package assignment5;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class app {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        boolean looper = true;
        while (looper) {
            System.out.println("\n1 – New Membership");
            System.out.println("2 – Add Material");
            System.out.println("3 – Issue(Rent) Item");
            System.out.println("4 – Return Item");
            System.out.println("5 – Report Inventory");
            System.out.println("6 – Report Loans");
            System.out.println("7 – Lookup Membership");
            System.out.println("8 – Exit");
            System.out.print("Please enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:  // New Membership
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Date of Birth (MM/dd/yyyy): ");
                    LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine(), formatter);
                    System.out.print("Enter City: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter Zip Code: ");
                    String zipCode = scanner.nextLine();

                    String guardian = null;
                    if (dateOfBirth.plusYears(18).isAfter(LocalDate.now())) {
                        System.out.print("Enter Guardian's Name: ");
                        guardian = scanner.nextLine();
                    }

                    library.addMember(firstName, lastName, dateOfBirth, city, zipCode, guardian);
                    break;

                case 2:  // Add Material
                    library.additem(scanner);
                    break;

                case 3:  // Issue Item
                    System.out.print("Enter Item Reference Number: ");
                    String itemReference = scanner.nextLine();
                    System.out.print("Enter Membership Number: ");
                    String membershipNumber = scanner.nextLine();
                    library.issueItem(itemReference, membershipNumber);
                    break;

                case 4:  // Return Item
                    System.out.print("Enter Item Reference Number: ");
                    String returnItemReference = scanner.nextLine();
                    library.returnItem(returnItemReference);
                    break;

                case 5:  // Report Inventory
                    library.printInventory();
                    break;

                case 6:  // Report Loans
                    library.printLoans();
                    break;

                case 7:  // Lookup Membership
                    System.out.print("Enter Membership Number: ");
                    String lookupMembershipNumber = scanner.nextLine();
                    library.lookupMembership(lookupMembershipNumber);
                    break;

                case 8:  // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    looper = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
