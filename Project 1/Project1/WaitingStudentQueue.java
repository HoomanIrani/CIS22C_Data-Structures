
public class WaitingStudentQueue {

	public class SListNode {
		Student item;
		SListNode next;

		SListNode(Student item, SListNode next) {
			this.item = item;
			this.next = next;
		}

	}

	SListNode head;
	int size; // number of nodes in list

	WaitingStudentQueue() {
		head = null;
		size = 0;
	}

	public void enqueue(Student item) {

		// Put a student in a node
		SListNode newNode = new SListNode(item, head); // head --> node2 --> node 1 --> null
		// Add node to the front of the queue
		head = newNode;
		// Increment size of queue
		size++;

	}

	public Student dequeue() {
		if (size == 1) {
			// Put the last student in variable dequeued
			Student dequeued = head.item;
			// Remove last student in queue
			head = null;
			size--;
			// Return that student
			return dequeued;
		} else if (!isEmpty()) {
			SListNode backOfQueue = head;
			while (backOfQueue.next.next != null) {
				// Traverse through the queue until reach the 2nd last from the back
				backOfQueue = backOfQueue.next;
			}
			// Put the last student in variable dequeued
			Student dequeued = backOfQueue.next.item;
			// Remove last student in queue
			backOfQueue.next = null;
			size--;
			// Return that student
			return dequeued;
		} else {
			System.out.printf("\nList is empty");
			return null;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

}
