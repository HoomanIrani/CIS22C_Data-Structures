/**
 * Spartment.java
 * @author Homan Irani
 * @author Mahbod Mohebi
 * CIS 22C, Project 1
 */


public class Apartment {
	// Variables
	private String ID;
	private String rent;
	private String location;
	private String numberOfBedrooms;
	private String isLaundry;
	private Student student;

	// Constructor
	public Apartment(String ID, String location, String numberOfBedrooms, String isLaundry, String rent) {
		this.ID = ID;
		this.rent = rent;
		this.location = location;
		this.numberOfBedrooms = numberOfBedrooms;
		this.isLaundry = isLaundry;
		student = null;
	}

	// Getters and Setters
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNumberOfBedrooms() {
		return numberOfBedrooms;
	}

	public void setNumberOfBedrooms(String numberOfBedrooms) {
		this.numberOfBedrooms = numberOfBedrooms;
	}

	public String getIsLaundry() {
		return isLaundry;
	}

	public void setIsLaundry(String isLaundry) {
		this.isLaundry = isLaundry;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}



}
