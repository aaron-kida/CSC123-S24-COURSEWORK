// Aaron Hoang ahoang14@toromail.csudh.edu

package DMVPack;

import java.util.Date;
import java.util.Objects;


public class Citation {
    private Date date;
    private int offenceCode;
    private double amount;
    private String status;
    private Registration registration;

    public Citation(Date date, int offenceCode, double amount, String status, Registration registration) {
        this.date = date;
        this.offenceCode = offenceCode;
        this.amount = amount;
        this.status = status;
        this.registration = registration;
    }

    public Date getDate() {
        return date;
    }

    public int getOffenceCode() {
        return offenceCode;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public Registration getRegistration() {
        return registration;
    }

@Override
public boolean equals(Object o) {
    Citation citation = (Citation) o;
    return offenceCode == citation.offenceCode &&
            Double.compare(citation.amount, amount) == 0 &&
            date.equals(citation.date) &&
            status.equals(citation.status) &&
            registration.equals(citation.registration);
	}

@Override
public int hashCode() {
    return Objects.hash(date, offenceCode, amount, status, registration);
    
	}

public Object getOwner() {
	return null;
	}
}

