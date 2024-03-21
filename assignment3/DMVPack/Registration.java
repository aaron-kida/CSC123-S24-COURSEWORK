// Aaron Hoang ahoang14@toromail.csudh.edu

package DMVPack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class Registration {
	private int uniqueID;
	private Date startDate;
	private Date endDate;
	private ArrayList<Owner>  owners;
	private Vehicle vehicle;
	private String plate;
	
	public Registration(ArrayList<Owner> owners, Vehicle Vehicle, String plate) {
        Random random = new Random();
        this.uniqueID = 1000000 + random.nextInt(9000000);

        // Set the start date to today
        this.startDate = new Date();

        // Set the end date to 5 years after today
        long fiveYearsInMillis = 5L * 365 * 24 * 60 * 60 * 1000; // 5 years in milliseconds
        this.endDate = new Date(System.currentTimeMillis() + fiveYearsInMillis);
        
		this.owners = owners;
		this.vehicle = Vehicle;
		this.plate = plate;
	}
	
	public boolean findOwner(Owner owner) {
		for (int j = 0; j < owners.size(); j++) {
			if (owner.equals(owners.get(j))) {
				return true;
			}
		}
		return false;
	}
	
    public int getUniqueID() {
        return uniqueID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public ArrayList<Owner> getOwners() {
        return owners;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getPlate() {
        return plate;
    }

@Override
public boolean equals(Object o) {
    Registration that = (Registration) o;
    return uniqueID == that.uniqueID &&
            startDate.equals(that.startDate) &&
            endDate.equals(that.endDate) &&
            owners.equals(that.owners) &&
            vehicle.equals(that.vehicle) &&
            plate.equals(that.plate);
}

@Override
public int hashCode() {
    return Objects.hash(uniqueID, startDate, endDate, owners, vehicle, plate);
    
	}
}
	