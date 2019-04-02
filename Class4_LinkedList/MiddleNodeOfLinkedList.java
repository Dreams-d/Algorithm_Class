package Laicode.Class4_LinkedList;

/**
 * Middle Node Of Linked List
 * Description
 * Find the middle node of a given linked list.
 *
 * Examples
 * L = null, return null
 * L = 1 -> null, return 1
 * L = 1 -> 2 -> null, return 1
 * L = 1 -> 2 -> 3 -> null, return 2
 * L = 1 -> 2 -> 3 -> 4 -> null, return 2
 *
 * time = O(n)
 * space = O(1)
 */

public class MiddleNodeOfLinkedList {
	public ListNode findMiddle(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			// fast.next != NULL不可以删
			// 会NPE，首先保证后面的next不为空，才能fast.next.next
			// 偶数取N4,条件换为fast != null && fast.next != null
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}