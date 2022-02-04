/**
 * DlistNoode.java
 * @author Homan Irani
 * @author Mahbod Mohebi
 * CIS 22C, Project 1
 */

public class DListNode {
		// Variables
		Apartment item;
		DListNode prev;
		DListNode next;
		// Constructor
		DListNode(Apartment item, DListNode prev, DListNode next) {
			this.item = item;
			this.prev = prev;
			this.next = next;
		}
	}