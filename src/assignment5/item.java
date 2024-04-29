package assignment5;

import java.time.LocalDate;
import java.util.ArrayList;

public class item {
    public String referenceNumber;
    public String title;
    public boolean suitableForChildren;
    public double replacementValue;
    public String location;
    public boolean isAvailable;
    public String loanedToMembershipNumber;
    public LocalDate dueDate;
	public String type;

    public item(String referenceNumber, String title, boolean suitableForChildren, double replacementValue, String location) {
        this.referenceNumber = referenceNumber;
        this.title = title;
        this.suitableForChildren = suitableForChildren;
        this.replacementValue = replacementValue;
        this.location = location;
        this.isAvailable = true;
        this.type = "";
    }
}

class Book extends item {
    private String author;
    private String ISBN;
    private int numberOfPages;

    public Book(String referenceNumber, String title, boolean suitableForChildren, double replacementValue, String location, String author, String ISBN, int numberOfPages) {
        super(referenceNumber, title, suitableForChildren, replacementValue, location);
        this.author = author;
        this.ISBN = ISBN;
        this.numberOfPages = numberOfPages;
        this.type = "Book";
    }
}

class Magazine extends item {
    private LocalDate publicationDate;
    private int issueNumber;

    public Magazine(String referenceNumber, String title, boolean suitableForChildren, double replacementValue, String location, LocalDate publicationDate, int issueNumber) {
        super(referenceNumber, title, suitableForChildren, replacementValue, location);
        this.publicationDate = publicationDate;
        this.issueNumber = issueNumber;
        this.type = "Magazine";
    }
}
class DVD extends item {
    private LocalDate releaseDate;
    private int durationMinutes;

    public DVD(String referenceNumber, String title, boolean suitableForChildren, double replacementValue, String location, LocalDate releaseDate, int durationMinutes) {
        super(referenceNumber, title, suitableForChildren, replacementValue, location);
        this.releaseDate = releaseDate;
        this.durationMinutes = durationMinutes;
        this.type = "DVD";
    }
}

class Member {
    private String membershipNumber;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String city;
    private String zipCode;
    private boolean isChild;
    private String guardian;

    public Member(String membershipNumber, String firstName, String lastName, LocalDate dateOfBirth, String city, String zipCode, boolean isChild, String guardian) {
        this.setMembershipNumber(membershipNumber);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.zipCode = zipCode;
        this.setChild(isChild);
        this.guardian = guardian;
    }

	public String getMembershipNumber() {
		return membershipNumber;
	}

	public void setMembershipNumber(String membershipNumber) {
		this.membershipNumber = membershipNumber;
	}

	public boolean isChild() {
		return isChild;
	}

	public void setChild(boolean isChild) {
		this.isChild = isChild;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGuardian() {
		return guardian;
	}

	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}
}
