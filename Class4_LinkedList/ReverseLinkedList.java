package Laicode.Class4_LinkedList;

/**
 * Reverse Linked List
 * Description
 * Reverse a singly-linked list.
 *
 * Examples
 * L = null, return null
 * L = 1 -> null, return 1 -> null
 * L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null
 *
 * time = O(n)
 * space = O(1) - iterative
 * space = O(n) - recursive
 */

public class ReverseLinkedList {
	public ListNode reverseIte(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode curr = head, prev = null;
		while (curr != null) {
			ListNode next = curr.next; // store the new head of sub-list
			curr.next = prev; // step2 reverse happens here!
			prev = curr; // step3 move 1 step to the right
			curr = next;
			// next = next.next; NPE
		}
		return prev;
	}

	public ListNode reverseRec(ListNode head) {
		// base case
		if (head == null || head.next == null) {
			return head;
		}
		// smaller size problem, newHead is NodeN
		ListNode newHead = reverseRec(head.next);
		// 每次传上来的head就是base case的尾巴。
		// tail指针每次有两个node指向它，head和后一个。tail指向null
		ListNode tail = head.next;
		tail.next = head;
		head.next = null;
		return newHead;
	}
}
