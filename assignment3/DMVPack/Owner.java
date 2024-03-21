// Aaron Hoang ahoang14@toromail.csudh.edu

package DMVPack;

import java.util.Objects;

public class Owner {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	
	public Owner (String firstName , String lastName , String address , String city , String state , String zip) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		
	}
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }
    
    @Override
    public boolean equals(Object o) {
        Owner owner = (Owner) o;
        return firstName.equals(owner.firstName) &&
                lastName.equals(owner.lastName) &&
                address.equals(owner.address) &&
                city.equals(owner.city) &&
                state.equals(owner.state) &&
                zip.equals(owner.zip);
    }

    @Override
	public int hashCode() {
    	return Objects.hash(firstName, lastName, address, city, state, zip);
	}
}

