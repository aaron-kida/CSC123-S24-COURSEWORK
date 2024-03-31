package DMVPack;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TestDMV {
    private static DMV dmv;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        dmv = new DMV("California", new ArrayList<>(), new ArrayList<>());
        

        int choice;
        do {
            System.out.println("DMV Menu:");
            System.out.println("1 - Register Vehicle");
            System.out.println("2 - Register Citation");
            System.out.println("3 - List All Registrations");
            System.out.println("4 - List All Citations");
            System.out.println("5 - List all Registrations for a vehicle");
            System.out.println("6 - List all Registrations for a person");
            System.out.println("7 - List all Citations for a vehicle");
            System.out.println("8 - List all Citations for a person");
            System.out.println("0 - Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerVehicle(scanner);
                    break;
                case 2:
                    registerCitation(scanner);
                    break;
                case 3:
                    listAllRegistrations();
                    break;
                case 4:
                    listAllCitations();
                    break;
                case 5:
                	getRegistrationByVehicle();
                    break;
                case 6:
                	getRegistrationsByOwner();
                    break;
                case 7:
                    getCitationByVehicle();
                    break;
                case 8:
                    getCitationsByOwner();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 8.");
            }
        } while (choice != 0);
    }

    private static void registerVehicle(Scanner scanner) {
        System.out.println("--Vehicle Info--"); 
        System.out.print("Enter vehicle make: ");
        String make = scanner.nextLine();
        System.out.print("Enter vehicle model: ");
        String model = scanner.nextLine();
        System.out.print("Enter vehicle color: ");
        String color = scanner.nextLine();
        System.out.print("Enter number of doors on vehicle: ");
        int doors = scanner.nextInt();
        System.out.print("Enter VIN: ");
        String vin = scanner.nextLine();
        
        System.out.println("--Owner Info--"); 
        System.out.print("Enter owner first name: ");
        String ownerFirstName = scanner.nextLine();
        System.out.print("Enter owner last name: ");
        String ownerLastName = scanner.nextLine();
        System.out.print("Enter owner address: ");
        String ownerAddress = scanner.nextLine();
        System.out.print("Enter owner city: ");
        String ownerCity = scanner.nextLine();
        System.out.print("Enter plate number: ");
        String plateNumber = scanner.nextLine();
        
        
        // Creating owner and vehicle objects
        Owner owner = new Owner(ownerFirstName, ownerLastName,ownerAddress, ownerCity, ownerCity ,plateNumber);
        Vehicle vehicle = new Vehicle(vin, new Date(),make, model, color, doors);
        ArrayList<Owner> owners = new ArrayList<Owner>();
        owners.add(owner);
        // Registering the vehicle
        dmv.registerVehicle(owners, vehicle);
        System.out.println("Vehicle registered successfully!");
    }
    
    private static void getRegistrationByVehicle() {
	    System.out.print("Enter vehicle VIN: ");
	    String vin = scanner.nextLine();
	    dmv.listRegistrations(dmv.getRegistrationsByVehicle(dmv.getVehicleByVIN(vin)));
	    
    }
    
    private static void getRegistrationsByOwner() {
    	System.out.print("Enter Name: ");
    	String name = scanner.nextLine();
    	dmv.listRegistrations(dmv.getRegistrationByName(name));
    }
    
    private static void getCitationByVehicle() {
    	System.out.print("Enter vehicle VIN: ");
    	String vin = scanner.nextLine();
    	dmv.listCitations(dmv.getCitationsByVehicle(dmv.getVehicleByVIN(vin)));
    }
    
    private static void getCitationsByOwner() {
    	System.out.print("Enter Name: ");
    	String name = scanner.nextLine();
    	dmv.listRegistrations(dmv.getRegistrationByName(name));
    }
    
    private static void registerCitation(Scanner scanner) {
        System.out.println("Enter citation information:");
        System.out.print("Enter vehicle plate number: ");
        String plateNumber = scanner.nextLine();
        System.out.print("Enter citation details: ");
        String details = scanner.nextLine();
        
        // Search for registration using plate number
        Registration registration = dmv.searchRegistrationByPlate(plateNumber);
        if (registration == null) {
            System.out.println("Vehicle not found. Unable to register citation.");
            return;
        }
        
        // Create citation and register
        Citation citation = new Citation(registration, details);
        dmv.registerCitation(citation);
        System.out.println("Citation registered successfully!");
    }

    private static void listAllRegistrations() {
        System.out.println("List of all registrations:");
        dmv.listRegistrations();
    }

    private static void listAllCitations() {
        System.out.println("List of all citations:");
        dmv.listCitations();
    }
}
