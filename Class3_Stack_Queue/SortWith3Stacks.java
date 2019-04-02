package Laicode.Class3_Stack_Queue;

import java.util.LinkedList;

/**
 * Sort With 3 Stacks
 * Description
 * Given one stack with integers, sort it with two additional stacks (total 3 stacks).
 * After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.
 *
 * Assumptions:
 * The given stack is not null.
 *
 * Requirements:
 * No additional memory, time complexity = O(nlog(n)).
 * space = O(n)
 */

//Assumptions: s1 is not null

public class SortWith3Stacks {
  public void sort(LinkedList<Integer> s1) {
    LinkedList<Integer> s2 = new LinkedList<Integer>();
    LinkedList<Integer> s3 = new LinkedList<Integer>();

    sort(s1, s2, s3, s1.size());
  }

  private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int length) {
    if (length <= 1) {
      return;
    }
    int len1 = length / 2;
    int len2 = length - length / 2;
    for (int i = 0; i < len2; i++) {
      s2.offerFirst(s1.pollFirst());
    }
    // use the other stacks to sort s1/s2
    // after sorting the numbers in s1/s2 are in ascending order from top
    // to bottom in the two stacks
    sort(s1, s3, s2, len1);
    sort(s2, s3, s1, len2);

    int i = 0;
    int j = 0;
    while (i < len1 && j < len2) {
      if (s1.peekFirst() < s2.peekFirst()) {
        s3.offerFirst(s1.pollFirst());
        i++;
      } else {
        s3.offerFirst(s2.pollFirst());
        j++;
      }
    }

    while (i < len1) {
      s3.offerFirst(s1.pollFirst());
      i++;
    }

    while (j < len2) {
      s3.offerFirst(s2.pollFirst());
      j++;
    }
    // after merging, the numbers are in descending order from top to bottom
    // in s3, we need to push back to s1 so that they are in ascending order
    for (int index = 0; index < length; index++) {
      // 不是poll所有的元素！！！是poll当前层的元素
      s1.offerFirst(s3.pollFirst());
    }
  }
}