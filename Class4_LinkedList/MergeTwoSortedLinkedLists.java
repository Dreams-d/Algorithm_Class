package Laicode.Class4_LinkedList;

import Laicode.ListNode;

/**
 * Merge Two Sorted Linked Lists
 * Description
 * Merge two sorted lists into one large sorted list.
 *
 * Examples
 * L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
 * L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2 -> null
 * L1 = null, L2 = null, merge L1 and L2 to null
 *
 * time = O(m + n)
 * space = O(1)
 */

public class MergeTwoSortedLinkedLists {
	public ListNode merge(ListNode head1, ListNode head2) {
		ListNode dummyHead = new ListNode(0);
		ListNode curr1 = head1, curr2 = head2, tail = dummyHead;
		while (curr1 != null && curr2 != null) {
			if (curr1.value < curr2.value) {
				tail.next = curr1;
				curr1 = curr1.next;
			} else {
				tail.next = curr2;
				curr2 = curr2.next;
			}
			tail = tail.next;
		}
		/*
		 * 不用写loop，因为linked list是已经接好了的，所以只要接一次就够了。 link the remaining possible nodes
		 */
		if (curr1 != null) {
			tail.next = curr1;
		}
		if (curr2 != null) {
			tail.next = curr2;
		}
		return dummyHead.next;
	}
}