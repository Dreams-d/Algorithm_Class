package Laicode.Class01_Sorting;

/**
 * Move 0s To The End I
 * Description
 * Given an array of integers, move all the 0s to the right end of the array.
 * The relative order of the elements in the original array does not need to be maintained.
 *
 * Assumptions:
 * The given array is not null.
 *
 * Examples:
 * {1} --> {1}
 * {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}
 */

public class Move0sToTheEndI {
	public int[] moveZero(int[] array) {
		int i = 0;
		int j = array.length - 1;
		while (i <= j) {
			if (array[i] != 0) {
				i++;
			} else if (array[j] == 0) {
				j--;
			} else {
				swap(array, i, j);
				i++;
				j--;
			}
		}
		return array;
	}

	private void swap(int[] array, int idx1, int idx2) {
		int tmp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = tmp;
	}
}