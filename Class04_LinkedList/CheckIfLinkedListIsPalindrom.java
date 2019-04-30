package Laicode.Class04_LinkedList;

import Laicode.ListNode;

/**
 * Description
 * Given a linked list, check whether it is a palindrome.
 * 
 * Examples:
 * Input:   1 -> 2 -> 3 -> 2 -> 1 -> null
 * output: true.
 * Input:   1 -> 2 -> 3 -> null  
 * output: false.
 * 
 * Requirements:
 * Space complexity must be O(1)
 * 
 * Time = O(n + n/2 + n) = O(n)
 * Space = O(1)
 */

public class CheckIfLinkedListIsPalindrom {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode mid = findMiddle(head);
        ListNode head2 = reverse(mid.next);
        mid.next = null;
        return isSame(head, head2);
    }

    private boolean isSame(ListNode h1, ListNode h2) {
        ListNode cur1 = h1;
        ListNode cur2 = h2;
        while (cur1 != null && cur2 != null) {
            if (cur1.value != cur2.value) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }

    private ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
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

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
