// Aaron Hoang ahoang14@toromail.csudh.edu

package DMVPack;

import java.util.ArrayList;

public class DMV {
	

	private String state;
	private ArrayList<Registration> registrations;
	private ArrayList<Citation> citations;

	
	public DMV (String state , ArrayList<Registration> registrations, ArrayList<Citation> citations)  {
		this.state = state;
		this.registrations = registrations;
		this.citations = citations;
	}

	public void registerVehicle(ArrayList<Owner> owners, Vehicle vehicle) { 
		Registration reg = new Registration(owners, vehicle, "AAAAAAAA");
		registrations.add(reg);
	}	
	public void registerCitation(Citation citation) {
		citations.add(citation);
	}
	
	public void listRegistrations() {
	    for (Registration reg : registrations) {
	        System.out.println("Registration ID: " + reg.getUniqueID());
	    }
	}
	public void listCitations() { 
		for (Citation cit : citations) {
			System.out.println("Citation: " + cit.getRegistration());
		}
	}
	public Registration searchRegistrationByPlate(String plate) {
		return null;
	}
	public Registration searchRegistrationByID(int uniqueID) {
		return null;
	}
	public Registration searchRegistrationByOwner(Owner owner) {
		for (int i = 0; i < registrations.size(); i++) {
			Registration reg = registrations.get(i);
			if (reg.findOwner(owner)) {
				return reg;
			}
		}
		return null;	
	}
	
	public Citation searchCitationByRegistration(Registration registration) {
	    for (Citation citation : citations) {
	        if (citation.getRegistration().equals(registration)) {
	            return citation;
	        }
	    }
	    return null;
	}

	public Citation searchCitationByOwner(Owner owner) {
	    for (Citation citation : citations) {
	        if (citation.getOwner().equals(owner)) {
	            return citation;
	        }
	    }
	    return null;
	}

	public Citation searchCitationByID(int ID) {
		return null;
	}

}

