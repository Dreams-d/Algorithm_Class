package Laicode.Class4_LinkedList.ExtraPractice;

import Laicode.ListNode;

/**
 * Linked List Insert At Index
 * Description
 * Insert a new element at a specific index in the given linked list. The index is 0 based, and if the index is out of the list's scope, you do not need to do anything.
 *
 * Examples:
 * 1 -> 2 -> 3 -> null, insert 4 at index 3, --> 1 -> 2 -> 3 -> 4 -> null
 * 1 -> 2 -> null, insert 4 at index 0, --> 4 -> 1 -> 2 -> null
 *
 * time = O(n)
 * space = O(1)
 */

public class LinkedListInsertAtIndex {
	public ListNode insert(ListNode head, int index, int value) {
		ListNode node = new ListNode(value);
		if (head == null || index == 0) {
			node.next = head;
			return node;
		}

		ListNode cur = head;
		while (cur != null && index > 1) {
			cur = cur.next;
			index--;
		}

		if (cur != null) {
			node.next = cur.next;
			cur.next = node;
		}

		return head;
	}
}