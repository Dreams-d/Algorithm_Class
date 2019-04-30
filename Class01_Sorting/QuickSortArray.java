package Laicode.Class01_Sorting;

/**
 * Quick Sort Array
 * Description
 * Given an array of integers, sort the elements in the array in ascending order. The quick sort algorithm should be used to solve this problem.
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

public class QuickSortArray {
	public int[] quickSort(int[] array) {
		// corner case
		if (array == null || array.length == 0) {
			return array;
		}
		doQuickSort(array, 0, array.length - 1);
		return array;
	}

	private void doQuickSort(int[] array, int left, int right) {
		// base case：you should do left>=right, you cannot do left == right.
		if (left >= right) {
			return;
		}

		int pivotPos = partition(array, left, right);
		doQuickSort(array, left, pivotPos - 1);
		doQuickSort(array, pivotPos + 1, right);
	}

	private int partition(int[] array, int left, int right) {
		int pivotIdx = left + (int) Math.random() * (right - left + 1);
		int pivot = array[pivotIdx];
		// swap the pivot element to the rightmost position first
		swap(array, right, pivotIdx);

		int leftBound = left;
		int rightBound = right - 1;

		while (leftBound <= rightBound) {
			// [0,leftBound),(rightBound,right-1]是已探索区域，[leftBound+1,rightBound-1]是未探索区域。
			// when leftBound == rightBound, the index has not been checked.
			if (array[leftBound] < pivot) {
				leftBound++;
			} else if (array[rightBound] >= pivot) {
				rightBound--;
			} else {
				swap(array, leftBound, rightBound);
				leftBound++;
				rightBound--;
			}
		} // leftBound == rightBound + 1
			// swap back the pivot element
		swap(array, leftBound, right);
		return leftBound;
	}

	private void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
