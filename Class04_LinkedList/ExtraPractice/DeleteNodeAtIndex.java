package Laicode.Class04_LinkedList.ExtraPractice;

import Laicode.ListNode;

/**
 * Delete Node At Index
 * Description
 * Delete the node at the given index for the given linked list.
 *
 * Examples
 * [1, 2, 3], delete at 1 --> [1, 3]
 * [1, 2, 3], delete at 4 --> [1, 2, 3]
 * [1, 2, 3], delete at 0 --> [2, 3]
 *
 * time = O(n)
 * space = O(1)
 */

public class DeleteNodeAtIndex {
	public ListNode deleteNode(ListNode head, int index) {
		if (head == null) {
			return null;
		}

		if (index == 0) {
			return head.next;
		}

		ListNode cur = head;
		while (cur.next != null && index > 1) {
			cur = cur.next;
			index--;
		}
		// if stop at the last node, no extra processing
		if (cur != null && cur.next != null) {
			cur.next = cur.next.next;
		}
		return head;
	}
}