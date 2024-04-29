package assignment5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {
    private ArrayList<item> items = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    // Add a new member to the library
    public void addMember(String firstName, String lastName, LocalDate dateOfBirth, String city, String zipCode, String guardian) {
        boolean isChild = LocalDate.now().minusYears(18).isBefore(dateOfBirth);
        String membershipNumber = generateMembershipNumber();
        Member newMember = new Member(membershipNumber, firstName, lastName, dateOfBirth, city, zipCode, isChild, guardian);
        members.add(newMember);
        System.out.println("New member added: " + firstName + " " + lastName + " (" + membershipNumber + ")");
    }

    // Add a new item to the library
    public void additem(Scanner scanner) {
        System.out.print("Enter Item Reference Number: ");
        String referenceNumber = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Is it suitable for children? (yes/no): ");
        boolean suitableForChildren = scanner.nextLine().equalsIgnoreCase("yes");
        System.out.print("Enter Replacement Value: ");
        double replacementValue = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Location (shelf id.location): ");
        String location = scanner.nextLine();
        System.out.print("Enter Type (Book/Magazine/DVD): ");
        String type = scanner.nextLine().toLowerCase();

        item newItem;
        switch (type) {
            case "book":
                System.out.print("Enter Author: ");
                String author = scanner.nextLine();
                System.out.print("Enter ISBN: ");
                String ISBN = scanner.nextLine();
                System.out.print("Enter Number of Pages: ");
                int numberOfPages = Integer.parseInt(scanner.nextLine());
                newItem = new Book(referenceNumber, title, suitableForChildren, replacementValue, location, author, ISBN, numberOfPages);
                break;
            case "magazine":
                System.out.print("Enter Publication Date (MM/dd/yyyy): ");
                LocalDate publicationDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                System.out.print("Enter Issue Number: ");
                int issueNumber = Integer.parseInt(scanner.nextLine());
                newItem = new Magazine(referenceNumber, title, suitableForChildren, replacementValue, location, publicationDate, issueNumber);
                break;
            case "dvd":
                System.out.print("Enter Release Date (MM/dd/yyyy): ");
                LocalDate releaseDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                System.out.print("Enter Duration in minutes: ");
                int durationMinutes = Integer.parseInt(scanner.nextLine());
                newItem = new DVD(referenceNumber, title, suitableForChildren, replacementValue, location, releaseDate, durationMinutes);
                break;
            default:
                System.out.println("Invalid type. No item added.");
                return;
        }

        items.add(newItem);
        System.out.println("New " + type + " added: " + title + " (" + referenceNumber + ")");
    }
    
    // Issue an item to a member
    public void issueItem(String itemReference, String membershipNumber) {
        item item = findItemByReference(itemReference);
        if (item == null) {
            System.out.println("Item does not exist.");
            return;
        }
        if (!item.isAvailable) {
            System.out.println("Item is currently on loan.");
            return;
        }
        Member member = findMemberByNumber(membershipNumber);
        if (member == null) {
            System.out.println("Membership number does not exist.");
            return;
        }
        if (member.isChild() && !item.suitableForChildren) {
            System.out.println("This item is not suitable for children.");
            return;
        }
        item.isAvailable = false;
        item.loanedToMembershipNumber = membershipNumber;
        item.dueDate = calculateDueDate(item.type);
        System.out.println("Item issued: " + item.title + " to " + member.getFirstName() + " " + member.getLastName());
    }

    // Return an item
    public void returnItem(String itemReference) {
        item item = findItemByReference(itemReference);
        if (item != null && !item.isAvailable) {
            item.isAvailable = true;
            item.loanedToMembershipNumber = null;
            item.dueDate = null;
            System.out.println("Item returned: " + item.title);
        } else {
            System.out.println("Error: Item not found or was not on loan.");
        }
    }

    // Print inventory of all items
    public void printInventory() {
        for (item item : items) {
            String status = item.isAvailable ? "Available" : "On loan to " + item.loanedToMembershipNumber + ", due back: " + item.dueDate;
            System.out.println(item.referenceNumber + " - " + item.title + " - " + status);
        }
    }

    // Print all current loans
    public void printLoans() {
        if (items.size() == 0) {
        	System.out.println("Nothing is being loaned currently");
        }
    	for (item item : items) {
            if (!item.isAvailable) {
                Member member = findMemberByNumber(item.loanedToMembershipNumber);
                if (member != null) {
                    System.out.println("Item: " + item.referenceNumber + ", Title: " + item.title + ", Loaned to: " + member.getFirstName() + " " + member.getLastName() + " (" + member.getMembershipNumber() + "), Due: " + item.dueDate);
                }
            }
        }
    }

    // Lookup a member's details
    public void lookupMembership(String membershipNumber) {
        Member member = findMemberByNumber(membershipNumber);
        if (member != null) {
            String details = "Member: " + member.getFirstName() + " " + member.getLastName() + " - " + (member.isChild() ? "Child, Guardian: " + member.getGuardian() : "Adult");
            System.out.println(details);
        } else {
            System.out.println("Membership not found.");
        }
    }

    private item findItemByReference(String reference) {
        for (item item : items) {
            if (item.referenceNumber.equals(reference)) {
                return item;
            }
        }
        return null;
    }

    Member findMemberByNumber(String membershipNumber) {
        for (Member member : members) {
            if (member.getMembershipNumber().equals(membershipNumber)) {
                return member;
            }
        }
        return null;
    }

    private LocalDate calculateDueDate(String type) {
        LocalDate today = LocalDate.now();
        switch (type) {
            case "Book":
                return today.plusWeeks(1);
            case "Magazine":
                return today.plusDays(3);
            case "DVD":
                return today.plusDays(2);
            default:
                return today;
        }
    }

    private String generateMembershipNumber() {
        return "MEM" + (members.size() + 1);
    }
}