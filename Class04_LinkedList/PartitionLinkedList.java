package Laicode.Class04_LinkedList;

import Laicode.ListNode;

/**
 * Partition Linked List
 * Description
 * Given a linked list and a target value T, partition it such that all nodes less than T are listed before the nodes larger than or equal to target value T. The original relative order of the nodes in each of the two partitions should be preserved.
 *
 * Examples
 * L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null
 *
 * time = O(n)
 * space = O(1)
 */

public class PartitionLinkedList {
	public ListNode partition(ListNode head, int target) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode smallDummy = new ListNode(0);
		ListNode largeDummy = new ListNode(0);
		ListNode cur = head, one = smallDummy, two = largeDummy;
		while (cur != null) {
			if (cur.value < target) {
				one.next = cur;
				one = one.next;
			} else {
				two.next = cur;
				two = two.next;
			}
			cur = cur.next;
		}
		// connect the two partitions
		one.next = largeDummy.next;
		// un-link the last node in large partition
		// otherwise, there exists a cycle, which cause deadloop
		two.next = null;
		return smallDummy.next;
	}
}