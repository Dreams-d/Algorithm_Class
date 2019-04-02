package Laicode.Class2_BinarySearch;

/**
 * K Closest In Sorted Array
 * Description
 * Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order, find the K closest numbers to T in A.
 *
 * Assumptions
 * A is not null
 * K is guranteed to be >= 0 and K is guranteed to be <= A.length
 *
 * Return
 * A size K integer array containing the K closest numbers(not indices) in A, sorted in ascending order by the difference between the number and T.
 *
 * Examples
 * A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
 * A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
 *
 * time = O(logn + k)
 * space = O(1)
 */

public class KClosestInSortedArray {
	public int[] kClosest(int[] array, int target, int k) {
		if (array == null || array.length == 0)
			return array;
		if (k == 0)
			return new int[0];
		// find the closest(largest smaller or equal) number to target
		int left = 0;
		int right = array.length - 1;

		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				// 如果有相等的，要找到最后一个相同的元素。
				// 也可以直接break
				// left = mid; right= mid; break;
				left = mid;
			} else if (target < array[mid]) {
				right = mid;
			} else {
				left = mid;
			}
		}
		// post-processing find the closest number
		int closeIdx = 0;
		if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
			closeIdx = left;
		} else {
			closeIdx = right;
		}

		// These two should be the closest to target
		int[] result = new int[k];
		int l = closeIdx;
		int r = closeIdx + 1;
		// this is a typical merge operation
		for (int i = 0; i < k; i++) {
			// we can advance the left pointer when:
			// 1. right pointer is already out of bound
			// 2. right pointer is not out of bound, left pointer is not out of
			// bound and array[left] is closer to target.
			if (r >= array.length) {// 可以合并成两种情况
				result[i] = array[l--];
			} else if (l < 0) {
				result[i] = array[r++];
			} else if (Math.abs(array[l] - target) <= Math.abs(array[r] - target)) {
				result[i] = array[l--];
			} else {
				result[i] = array[r++];
			}
		}
		return result;
	}
}