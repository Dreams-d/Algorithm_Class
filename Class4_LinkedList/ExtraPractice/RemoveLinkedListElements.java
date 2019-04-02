package Laicode.Class4_LinkedList.ExtraPractice;

import Laicode.ListNode;

/**
 * Remove Linked List Elements
 * Description
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example
 * 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6, val = 6, --> 1 -> 2 -> 3 -> 4 -> 5
 * 1 -> 1 -> 1, val = 1, --> null
 * 2 -> 1 -> 2 -> 3, val = 2, --> 1 ->3
 *
 * time = O(n)
 * space = O(1)
 */

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}

		// remove head
		if (head.value == val) {
			head = head.next;
		}

		ListNode cur = head;
		while (cur != null && cur.next != null) {
			while (cur.next != null && cur.next.value != val) {
				cur = cur.next;
			}

			if (cur.next != null) {
				cur.next = cur.next.next;
			}
		}

		// left one element, and if the value equals to val, return null
		if (cur != null && cur.value == val) {
			return null;
		}

		return head;
	}
}