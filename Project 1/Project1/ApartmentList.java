
public class ApartmentList {

	// Instance variables of ApartmentList
	int size;
	DListNode head;

	// Constructor of ApartmentList (Equivalent to DListSent as mentioned in class)
	ApartmentList() {
		// Creates a doubly linked list with a sentinel node
		size = 0;
		DListNode SentinelNode = new DListNode(null, null, null);
		SentinelNode.next = SentinelNode;
		SentinelNode.prev = SentinelNode;
		head = SentinelNode;

	}

	public void insertFront(Apartment i) {
		// Inserts item to the front of the list
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
		size++; // Increment size after adding node
	}
	/*public void removeFront() {
		// Removes item in front of the list
		if (size != 0) {
			if (size == 1) {
				head.next = head;
				head.prev = head;
			} else {
				head.next.next.prev = head;
				head.next = head.next.next;
			}
			size--; // Decrement size after removing
		}
	}*/
	public void remove(DListNode node) {
		// Set the next of the previous node to the one after the node being removed
		node.prev.next = node.next;
		// Set the next node's previous setting to the node before the one being removed
		node.next.prev = node.prev;
		size--;
	}
	
	public boolean isEmpty() {
		// Returns if list is empty
		return (size == 0);
	}
	public int getSize() {
		// Returns the size of list
		return size;
	}

	public DListNode getHead() {
		return head;
	}

	public void setHead(DListNode head) {
		this.head = head;
	}
	
}
