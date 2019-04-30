package Laicode.Class04_LinkedList.ExtraPractice;

import Laicode.ListNode;

/**
 * Insert In Sorted Linked List
 * Description
 * Insert a value in a sorted linked list.
 *
 * Examples
 * L = null, insert 1, return 1 -> null
 * L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
 * L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
 * L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null
 *
 * time = O(n)
 * space = O(1)
 */

public class InsertInSortedLinkedList {
	public ListNode insert(ListNode head, int value) {
		ListNode newNode = new ListNode(value);
		// 1.determine if the inserted node is before head.
		if (head == null || head.value >= value) {
			newNode.next = head;
			return newNode;
		}
		// 2.insert the new node to the right position
		// using the previous node to traverse the linked list
		// the insert position of the new node should be between prev and prev.next
		ListNode prev = head;
		while (prev.next != null && prev.next.value < value) {
			prev = prev.next;
		}
		newNode.next = prev.next; // 位置不能换
		prev.next = newNode;
		return head;
	}

	public ListNode insertRec(ListNode head, int target) {
		ListNode newNode = new ListNode(target);
		if (head == null || target <= head.value) {
			newNode.next = head;
			return newNode;
		}
		ListNode newHead = insertRec(head.next, target);
		head.next = newHead;
		return head;
	}
}