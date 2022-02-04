
public class Student {
	// Instance variables
	private String ID;
	private String name;
	private String requiredLocation;
	private String requiredNumberOfBedrooms; // Some of the students have this field as "Any"
	private String requireLaundry;
	private String desiredRent;

	// Constructor
	public Student(String ID, String name, String requiredLocation, String requiredNumberOfBedrooms,
			String requireLaundry, String desiredRent) {
		this.ID = ID;
		this.name = name;
		this.requiredLocation = requiredLocation;
		this.requiredNumberOfBedrooms = requiredNumberOfBedrooms;
		this.requireLaundry = requireLaundry;
		this.desiredRent = desiredRent;
	}

	// Getters and Setters
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRequiredLocation() {
		return requiredLocation;
	}

	public void setRequiredLocation(String requiredLocation) {
		this.requiredLocation = requiredLocation;
	}

	public String getRequiredNumberOfBedrooms() {
		return requiredNumberOfBedrooms;
	}

	public void setRequiredNumberOfBedrooms(String requiredNumberOfBedrooms) {
		this.requiredNumberOfBedrooms = requiredNumberOfBedrooms;
	}

	public String isRequireLaundry() {
		return requireLaundry;
	}

	public void setRequireLaundry(String requireLaundry) {
		this.requireLaundry = requireLaundry;
	}

	public String getDesiredRent() {
		return desiredRent;
	}

	public void setDesiredRent(String desiredRent) {
		this.desiredRent = desiredRent;
	}

}
