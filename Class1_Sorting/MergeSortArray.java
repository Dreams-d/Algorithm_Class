package Laicode.Class1_Sorting;

/**
 * Merge Sort Array
 * Description
 * Given an array of integers, sort the elements in the array in ascending order. The merge sort algorithm should be used to solve this problem.
 *
 * Examples
 * {1} is sorted to {1}
 * {1, 2, 3} is sorted to {1, 2, 3}
 * {3, 2, 1} is sorted to {1, 2, 3}
 * {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
 *
 * Corner Cases
 * What if the given array is null? In this case, we do not need to do anything.
 * What if the given array is of length zero? In this case, we do not need to do anything.
 */

public class MergeSortArray {
	public int[] mergeSort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}

		int[] helper = new int[array.length];
		partition(array, helper, 0, array.length - 1);
		return array;
	}

	private void partition(int[] array, int[] helper, int left, int right) {
		if (left >= right) {
			return;
		}

		int mid = left + (right - left) / 2; // to avoid overflow
		partition(array, helper, left, mid);
		partition(array, helper, mid + 1, right);
		merge(array, helper, left, mid, right);
	}

	private void merge(int[] array, int[] helper, int left, int mid, int right) {
		for (int i = left; i <= right; i++) {
			helper[i] = array[i];
		}

		int i = left;
		int j = mid + 1;
		int idx = left;
		while (i <= mid && j <= right) {
			if (helper[i] < helper[j]) {
				array[idx] = helper[i];
				idx++;
				i++;
			} else {
				array[idx] = helper[j];
				idx++;
				j++;
			}
		}

		while (i <= mid) {
			array[idx++] = helper[i++];
		}
	}
}