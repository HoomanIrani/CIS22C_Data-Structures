
public class DListNode {
		// Instance variables of DListNode
		Apartment item;
		DListNode prev;
		DListNode next;
		// Constructor of DListNode
		DListNode(Apartment item, DListNode prev, DListNode next) {
			this.item = item;
			this.prev = prev;
			this.next = next;
		}
	}