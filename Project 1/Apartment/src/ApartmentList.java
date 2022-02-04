/**
 * ApartmentList.java
 * @author Homan Irani
 * @author Mahbod Mohebi
 * CIS 22C, Project 1
 */


public class ApartmentList {

	// Variables
	int size;
	DListNode head;

	// Constructor
	ApartmentList() {

		size = 0;
		DListNode SentinelNode = new DListNode(null, null, null);
		SentinelNode.next = SentinelNode;
		SentinelNode.prev = SentinelNode;
		head = SentinelNode;

	}

	public void insertFront(Apartment i) {

		DListNode newNode = new DListNode(i, null, null);
		if (size == 0) {
			newNode.prev = head;
			newNode.next = head;
			head.next = newNode;
			head.prev = newNode;
		} else {
			newNode.next = head.next;
			newNode.prev = head;
			head.next.prev = newNode;
			head.next = newNode;
		}
		size++;
	}

	public void remove(DListNode node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		size--;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	public int getSize() {
		return size;
	}

	public DListNode getHead() {
		return head;
	}

	public void setHead(DListNode head) {
		this.head = head;
	}
	
}
