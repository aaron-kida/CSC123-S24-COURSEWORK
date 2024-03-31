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
	
	public void listRegistrations(ArrayList<Registration> registrations) {
	    for (Registration reg : registrations) {
	        System.out.println("Registration ID: " + reg.getUniqueID());
	    }
	}
	public void listCitations() { 
		for (Citation cit : citations) {
			System.out.println("Citation: " + cit.getRegistration());
		}
	}
	public void listCitations(ArrayList<Citation> citations) { 
		for (Citation cit : citations) {
			System.out.println("Citation: " + cit.getRegistration());
		}
	}
	public Registration searchRegistrationByPlate(String plate) {
	    for (Registration registration : registrations) {
	        if (registration.getPlate().equals(plate)) {
	            return registration; 
	        } 
	    }
		return null;
	}

	public Registration searchRegistrationByID(int uniqueID) {
		for (Registration registration : registrations) {
			if (registration.getUniqueID() == (uniqueID)) {
				return registration;
			}
		}
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
	        if (citation.getRegistration().findOwner(owner)) {
	        	return citation;
	        }
	    }
	    return null;
	}

	public Citation searchCitationByID(int ID) {
		for (Citation citation : citations) {
			if (citation.getRegistration().getUniqueID() == ID){
				return citation;
	        }
	    }
	    return null;
	}
	
    public ArrayList<Registration> getRegistrationsByVehicle(Vehicle vehicle) {
        ArrayList<Registration> registrationsForVehicle = new ArrayList<>();

        for (Registration registration : registrations) {
            if (registration.getVehicle().equals(vehicle)) {
                registrationsForVehicle.add(registration); 
            }
        }
        return registrationsForVehicle;
    }

	public ArrayList<Registration> getRegistrationsByOwner(Owner owner) {
		ArrayList<Registration> registrationsForOwner = new ArrayList<>();
		
		for (Registration registration : registrations) {
			if (registration.getOwners().equals(owner)) {
				registrationsForOwner.add(registration);
			}
		}	
			return null;
	}
	
	public ArrayList<Citation> getCitationsByVehicle(Vehicle vehicle) {
		ArrayList<Citation> vehicleCitations = new ArrayList<>();
		
		for (Citation citation : citations) {
			if (citation.getRegistration().getVehicle().equals(vehicle)) {
				vehicleCitations.add(citation) ;
			}
		}
		return vehicleCitations;
	}

	
	public ArrayList<Citation> getCitationsByOwner(Owner owner) {
		ArrayList<Citation> ownerCitations = new ArrayList<>();

		for (Citation citation : citations) {
	        if (citation.getRegistration().findOwner(owner)) {
	        	ownerCitations.add(citation) ;
	        }
		}
	    return ownerCitations;
	}
	
	public Vehicle getVehicleByVIN(String vin) {
		for (Registration reg : registrations) {
			if (reg.getVehicle().getVin().equals(vin)) {
				return reg.getVehicle();
			} 
		}
		return null;
	}
	public ArrayList<Registration> getRegistrationByName(String name) {
		ArrayList<Registration> registrations = new ArrayList<>();
		
		for(Registration reg : this.registrations) {
			for (Owner owner : reg.getOwners()) {
				if(owner.getFirstName().equals(name)) {
					registrations.add(reg);
				}		
			}
		}
			
			return registrations;
	}
}

