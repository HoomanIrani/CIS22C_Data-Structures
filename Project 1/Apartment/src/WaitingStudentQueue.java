/**
 * WaitingStudentQueue.java
 * @author Homan Irani
 * @author Mahbod Mohebi
 * CIS 22C, Project 1
 */


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
	int size;

	WaitingStudentQueue() {
		head = null;
		size = 0;
	}

	public void enqueue(Student item) {

		SListNode newNode = new SListNode(item, head);
		head = newNode;
		size++;

	}

	public Student dequeue() {
		if (size == 1) {

			Student dequeued = head.item;
			head = null;
			size--;
			return dequeued;
		} else if (!isEmpty()) {
			SListNode backOfQueue = head;
			while (backOfQueue.next.next != null) {
				backOfQueue = backOfQueue.next;
			}
			Student dequeued = backOfQueue.next.item;
			backOfQueue.next = null;
			size--;
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
