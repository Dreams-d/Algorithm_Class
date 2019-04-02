package Laicode.Class1_Sorting;

/**
 * Selection Sort Array
 * Description
 * Given an array of integers, sort the elements in the array in ascending order. The selection sort algorithm should be used to solve this problem.
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

public class SelectionSortArray {
  public int[] doSelectionSort(int[] array) {
    if (array == null || array.length == 0) {
      return array;
    }
    // outer loop: how many iterations
    for (int i = 0; i < array.length - 1; i++) {
      int min = i;
      // inner loop: find the global min from the rest elements
      for (int j = i + 1; j < array.length; j++) {
        if (array[min] > array[j]) {
          min = j;
        }
      }
      swap(array, i, min);
    }
    return array;
  }

  private void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}