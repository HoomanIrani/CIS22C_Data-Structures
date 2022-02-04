import java.io.*;
import java.util.StringTokenizer;

public class Driver {
	public static void main(String[] args) {
		// Create a doubly linked list with sentinel node
		ApartmentList apartments = new ApartmentList();
		readApartmentFile("InputApartmentFile.txt", apartments);
		// Read file, create apartments, and add them to list
		WaitingStudentQueue students = new WaitingStudentQueue();
		readStudentFile("InputStudentFile.txt", students);
		// for (int i = 0; i < )
		match(apartments, students);

	}

	public static void readApartmentFile(String filename, ApartmentList apartments) {
		// This function reads in a file, parses it, and
		// creates a doubly linked list of apartments
		System.out.println("\n----- Printing out Apartments -----");
		try {
			// Create a BufferedReader
			BufferedReader buff = new BufferedReader(new FileReader(filename));
			// Keeps record of line being read
			String line;
			// While line is not null (null signifies end of file), do ...
			while ((line = buff.readLine()) != null) {
				// Prints data out (prints out each line)
				System.out.printf("%s\n", line);
				// Create a StringTokenizer to tokenize the strings in each line
				StringTokenizer str = new StringTokenizer(line);
				// Read the string, extract info, and make an apartment
				Apartment newApartment = new Apartment(str.nextToken(), str.nextToken(), str.nextToken(),
						str.nextToken(), str.nextToken());
				// Add newly created apartment to the list
				apartments.insertFront(newApartment);
			}
			// Close the BufferedReader
			buff.close();
		} catch (IOException e) {
			// If filename is incorrect, catch the exception
			System.out.println("Error -- " + e.toString());
		}
	}

	public static void readStudentFile(String filename, WaitingStudentQueue students) {
		// This function reads in a file, parses it, and
		// creates a singly linked list of students (implements a queue)
		System.out.println("\n----- Printing out Students -----");
		try {
			// Create a BufferedReader
			BufferedReader buff = new BufferedReader(new FileReader(filename));
			// Keeps record of line being read
			String line;
			// While line is not null (null signifies end of file), do ...
			while ((line = buff.readLine()) != null) {
				// Prints data out (prints out each line)
				System.out.printf("%s\n", line);
				// Create a StringTokenizer to tokenize the strings in each line
				StringTokenizer str = new StringTokenizer(line);
				// Read the string, extract info, and create a student
				Student newStudent = new Student(str.nextToken(), str.nextToken(), str.nextToken(), str.nextToken(),
						str.nextToken(), str.nextToken());
				// Add newly created student to the queue
				students.enqueue(newStudent);
			}
			// Close the BufferedReader
			buff.close();
		} catch (IOException e) {
			// If filename is incorrect, catch the exception
			System.out.println("Error -- " + e.toString());
		}
	}

	public static void match(ApartmentList apartments, WaitingStudentQueue students) {
		System.out.println("\n----- Printing out Assignments -----");
		// This string will be compared in the if statements below
		String any = "Any";
		// Get the head of the apartment list
		DListNode dlistnode = apartments.getHead();
		// Once queue is empty, stop the assignment
		while (!students.isEmpty()) {
			// Dequeue a student
			Student student = students.dequeue();
			// i keeps track of the number of iterations.
			// i also checks at the end if all the apartments have been searched
			int i;
			// Iterate the loop until all the apartments have been searched
			for (i = 0; i < apartments.getSize(); i++) {
				// Get next node's apartment in list head<--apt1<--apt2<--apt3...
				dlistnode = dlistnode.prev;
				// Extract the apartment from the node
				Apartment apartment = dlistnode.item;
				// Check to see if the locations are the same or if "Any"
				if (student.getRequiredLocation().equalsIgnoreCase(apartment.getLocation())
						|| any.equalsIgnoreCase(student.getRequiredLocation())) {
					// Check to see if the number of bedrooms are the same or if "Any"
					if (student.getRequiredNumberOfBedrooms().equalsIgnoreCase(apartment.getNumberOfBedrooms())
							|| any.equalsIgnoreCase(student.getRequiredNumberOfBedrooms())) {
						// Check to see if laundry is required or if "Any"
						if (student.isRequireLaundry().equalsIgnoreCase(apartment.getIsLaundry())
								|| any.equalsIgnoreCase(student.isRequireLaundry())) {
							// Check to see if the rent is lesser or equal to the student's desired rent
							if (Integer.parseInt(student.getDesiredRent()) >= Integer.parseInt(apartment.getRent())
									|| any.equalsIgnoreCase(student.getDesiredRent())) {
								// Match the student to the appropriate apartment
								apartment.setStudent(student);
								// Print out the assignment
								System.out.printf("Student %s (ID: %s) matched to apartment %s\n", student.getName(),
										student.getID(), apartment.getID());
								// Remove apartment from list after matching
								apartments.remove(dlistnode);
								// Reset apartment searching list.
								// Restart the apartment search algorithm from apartment 1 (first apartment in
								// list)
								dlistnode = apartments.getHead();
								// Reset the count of the loop so we can rescan the apartments for the next
								// student
								//i = 0;
								break;
							}
						}
					}
				}
			}

			// If we search all the apartments, then there is no match
			// i = # of apartments if all the apartments have been searched
			if (i == apartments.getSize()) {
				// If all apartments have been scanned and non matched, print this message
				System.out.printf("(!!!)Student %s (ID: %s) cannot be matched to an apartment\n", student.getName(),
						student.getID());
				// Reset apartment searching list. Restart the apartment search algorithm from
				// apartment 1 (first apartment)
				dlistnode = apartments.getHead();
			}
		}
		// Below prints the unused apartments
		dlistnode = apartments.getHead();
		for (int j = 0; j < apartments.getSize(); j++) {
			dlistnode = dlistnode.prev;
			Apartment apartment = dlistnode.item;
			System.out.printf("Unused Apartment: %s %s %s %s %s %s\n", apartment.getID(), apartment.getLocation(),
					apartment.getNumberOfBedrooms(), apartment.getIsLaundry(), apartment.getIsLaundry(),
					apartment.getRent());
		}
	}
}