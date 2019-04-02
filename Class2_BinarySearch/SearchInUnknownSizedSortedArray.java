package Laicode.Class2_BinarySearch;

import java.util.Dictionary;

/**
 * Search In Unknown Sized Sorted Array
 * Description
 * Given a integer dictionary A of unknown size, where the numbers in the dictionary are sorted in ascending order, determine if a given target integer T is in the dictionary. Return the index of T in A, return -1 if T is not in A.
 *
 * Assumptions
 * dictionary A is not null
 * dictionary.get(i) will return null(Java)/INT_MIN(C++)/None(Python) if index i is out of bounds
 *
 * Examples
 * A = {1, 2, 5, 9, ......}, T = 5, return 2
 * A = {1, 2, 5, 9, 12, ......}, T = 7, return -1
 *
 * time = O(logn + log(2n))
 * space = O(1)
 */

public class SearchInUnknownSizedSortedArray {
	public int search(Dictionary dict, int target) {
		if (dict == null)
			return -1;
		int left = 0;
		int right = 1;
		// find the right bound for binary search.
		// extends until we are sure the target is within the [left, right] range.
		while (dict.get(right) != null && (int)dict.get(right) <= target) {
			// 1. move left to right
			// 2. double right index
			left = right;// target一定在[2^k-1,2^k]范围内
			right = right * 2;
		}
		return binarySearch(dict, left, right, target);
	}

	private int binarySearch(Dictionary dict, int left, int right, int target) {
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (dict.get(mid) != null || (int)dict.get(mid) > target) {// 可能中点还是out of bound, 所以先写这种情况。
				right = mid - 1;
			} else if (target > (int)dict.get(mid)) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
