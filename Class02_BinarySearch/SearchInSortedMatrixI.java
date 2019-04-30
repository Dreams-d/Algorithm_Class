package Laicode.Class02_BinarySearch;

/**
 * Search In Sorted Matrix I
 * Description
 * Given a 2D matrix that contains integers only, which each row is sorted in an ascending order. The first element of next row is larger than (or equal to) the last element of previous row.
 * Given a target number, returning the position that the target locates within the matrix. If the target number does not exist in the matrix, return {-1, -1}.
 *
 * Assumptions:
 * The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.
 *
 * Examples:
 * matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }
 * target = 7, return {1, 2}
 * target = 6, return {-1, -1} to represent the target number does not exist in the matrix.
 *
 * time = O(log(n*m))
 * space = O(1)
 */

public class SearchInSortedMatrixI {
	public int[] matrixSearch(int[][] matrix, int target) {
		// corner case
		if (matrix.length == 0 || matrix[0].length == 0) {
			return new int[] { -1, -1 };
		}

		int rows = matrix.length;
		int cols = matrix[0].length;
		int left = 0;
		// covert the 2D array to 1D array with rows * cols elements.
		int right = rows * cols - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int row = mid / cols;
			int col = mid % cols;
			// convert the position in 1D array back to row and col in 2D array
			if (matrix[row][col] == target) {
				return new int[] { row, col };
			} else if (target < matrix[row][col]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return new int[] { -1, -1 };
	}
}