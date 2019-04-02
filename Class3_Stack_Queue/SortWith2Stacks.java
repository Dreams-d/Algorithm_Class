package Laicode.Class3_Stack_Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Sort With 2 Stacks
 * Description
 * Given an array that is initially stored in one stack, sort it with one additional stacks (total 2 stacks).
 * After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.
 *
 * Assumptions:
 * The given stack is not null.
 *
 * Requirements:
 * No additional memory, time complexity = O(n ^ 2).
 */

public class SortWith2Stacks {
	public Deque<Integer> sort(Deque<Integer> s1) {
		Deque<Integer> s2 = new LinkedList<>();
		// outer loop: control the times of iteration, i also as a count for sorted
		// elements. When there is only one element, no need to sort.
		for (int i = 0; i < s1.size() - 1; i++) {
			int localMin = Integer.MAX_VALUE;
			int count = 0;// record the total counts of localMin
			while (s1.size() > i) {
				// Each time, traverse the unsorted part, find the localMin, move the
				// rest elements from s1 to s2
				int tmp = s1.pop();
				if (localMin > tmp) {
					localMin = tmp;
					count = 1;
				} else if (localMin == tmp) {
					count++;
				}
				s2.push(tmp);
			}
			for (int j = 0; j < count; j++) {// push the localMin into s1
				s1.push(localMin);
			}

			while (!s2.isEmpty()) {
				// move the unsorted elements from s2 to s1
				int tmp = s2.pop();
				if (tmp != localMin) {
					s1.push(tmp);
				}
			}
		}
		return s1;
	}
}
