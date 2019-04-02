package Laicode.Class4_LinkedList;

/**
 * Cycle Node In Linked List
 * Description
 * Check if a given linked list has a cycle. Return the node where the cycle starts. Return null if there is no cycle.
 *
 * time = O(2n) = O(n)
 * space = O(1)
 */

public class CycleNodeInLinkedList {
	public ListNode cycleNode(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		ListNode meet = null;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				meet = slow;
				break;
			}
		}

		if (meet != null) {
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
		return null;
	}
}