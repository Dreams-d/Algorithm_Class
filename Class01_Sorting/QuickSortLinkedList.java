package Laicode.Class01_Sorting;

import Laicode.ListNode;

/**
 * Quick Sort Linked List
 * Description
 * Given a singly-linked list, where each node contains an integer value, sort it in ascending order. The quick sort algorithm should be used to solve this problem.
 *
 * Examples
 * null, is sorted to null
 * 1 -> null, is sorted to 1 -> null
 * 1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
 * 4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6
 */

public class QuickSortLinkedList {
    public ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pivot = head;
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(1);
        partition(head, leftDummy, rightDummy);
        ListNode left = quickSort(leftDummy.next);
        ListNode right = quickSort(rightDummy.next);

        ListNode leftTail = left;
        while (leftTail != null && leftTail.next != null) {
            leftTail = leftTail.next;
        }
        if (leftTail == null) {
            left = pivot;
        } else {
            leftTail.next = pivot;
        }
        pivot.next = right;
        return left;
    }

    private void partition(ListNode head, ListNode small, ListNode large) {
        ListNode curSmall = small;
        ListNode curLarge = large;

        int value = head.value;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.value < value) {
                curSmall.next = cur;
                curSmall = curSmall.next;
            } else {
                curLarge.next = cur;
                curLarge = curLarge.next;
            }
            cur = cur.next;
        }
        curSmall.next = null;
        curLarge.next = null;
    }
}