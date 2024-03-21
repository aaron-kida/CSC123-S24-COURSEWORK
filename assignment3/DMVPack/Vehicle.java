// Aaron Hoang ahoang14@toromail.csudh.edu

package DMVPack;

import java.util.Date;
import java.util.Objects;

public class Vehicle {
	private String vin;
	private Date dateOfMfg;
	private String make;
	private String model;
	private String color;
	private int numberOfDoors;
	
	public Vehicle(String vin , Date dateOfMfg , String make , String model , String color , int numberOfDoors) {
		this.dateOfMfg = dateOfMfg;
		this.make = make;
		this.model = model;
		this.color = color;
		this.numberOfDoors = numberOfDoors;
	}
		
		 public String getVin() {
		        return vin;
		    }

		    public Date getDateOfMfg() {
		        return dateOfMfg;
		    }

		    public String getMake() {
		        return make;
		    }

		    public String getModel() {
		        return model;
		    }

		    public String getColor() {
		        return color;
		    }

		    public int getNumberOfDoors() {
		        return numberOfDoors;		    		
	}

@Override
public boolean equals(Object o) {
    Vehicle vehicle = (Vehicle) o;
    return numberOfDoors == vehicle.numberOfDoors &&
            vin.equals(vehicle.vin) &&
            dateOfMfg.equals(vehicle.dateOfMfg) &&
            make.equals(vehicle.make) &&
            model.equals(vehicle.model) &&
            color.equals(vehicle.color);
}
@Override
public int hashCode() {
    return Objects.hash(vin, dateOfMfg, make, model, color, numberOfDoors);
	}
}
