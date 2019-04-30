package Laicode.Class04_LinkedList;

import Laicode.ListNode;

/**
 * ReOrder Linked List
 * Description
 * Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null
 *
 * Examples
 * L = null, is reordered to null
 * L = 1 -> null, is reordered to 1 -> null
 * L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
 * L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null
 *
 * time = O(n + n + n) = O(n)
 * space = O(1)
 */

public class ReOrderLinkedList {
	public ListNode reorder(ListNode head) {
		ListNode one = head;
		// 1.find the middle node
		ListNode mid = middle(head);
		ListNode two = mid.next;
		// de-link the second half from the list
		// 一定要断掉，不然的话第一半还是整条链表
		mid.next = null;

		// 2.reverse the second half
		two = reverse(two);
		// 3. merge the two halves
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (one != null && two != null) {
			// 顺序不能换，如果吧cur.next.next换到第二行，当前指针会把one的next也改掉。
			cur.next = one;
			one = one.next;
			cur.next.next = two;
			two = two.next;
			cur = cur.next.next;
		}
		if (one != null) {// 奇数个结点，要将没有组成pair的挂在后面
			cur.next = one;
		} else {
			cur.next = two;
		}
		return dummy.next;
	}

	private ListNode middle(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null, cur = head, next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
}