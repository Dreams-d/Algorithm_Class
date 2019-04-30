package Laicode.Class04_LinkedList;

import Laicode.ListNode;

/**
 * Check If Linked List Has A Cycle
 * Description
 * Check if a given linked list has a cycle. Return true if it does, otherwise return false.
 *
 * time = O(n)
 * space = O(1)
 */

public class CheckIfLinkedListHasACycle {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			// 终止条件和上一题一样，fast指针要确保奇偶都不NPE
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
}