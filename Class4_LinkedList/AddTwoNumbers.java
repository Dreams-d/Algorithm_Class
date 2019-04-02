package Laicode.Class4_LinkedList;

/**
 * Description
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.  
 * 
 * Example
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8 
 * Laicode 是 8 -> 0 -> 7
 * 
 * Time = O(n1 + n2)
 * Space = O(1)
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(1);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int number = (l1.value + l2.value + carry) % 10;
            carry = (l1.value + l2.value + carry) / 10;
            cur.next = new ListNode(number);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int number = (l1.value + carry) % 10;
            carry = (l1.value + carry) / 10;
            cur.next = new ListNode(number);
            cur = cur.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int number = (l2.value + carry) % 10;
            carry = (l2.value + carry) / 10;
            cur.next = new ListNode(number);
            cur = cur.next;
            l2 = l2.next;
        }

        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        ListNode head = dummy.next;
        dummy.next = null;
        return head;
    }
}