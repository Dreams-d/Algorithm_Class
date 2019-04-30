package Laicode.Class09_StringII;

/**
 * Description
 * Given an array of elements, reorder it as follow:
 *
 * { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }
 * { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }
 *
 * Try to do it in place.
 *
 * Assumptions
 * The given array is not null
 * Examples
 *
 * { 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }
 * { 1, 2, 3, 4, 5, 6, 7, 8 } → { 1, 5, 2, 6, 3, 7, 4, 8 }
 * { 1, 2, 3, 4, 5, 6, 7 } → { 1, 4, 2, 5, 3, 6, 7 }
 *
 * Time = O(nlogn)
 * Space = O(logn)
 */
public class ReOrderArray {
    public int[] reorder(int[] array) {
        if (array.length % 2 == 0) {
            reorder(array, 0, array.length - 1);
        } else  {
            // if array has odd number of elements, we ignore the last one
            // when we  do reordering;
            reorder(array, 0, array.length - 2);
        }
        return array;
    }

    private void reorder(int[] array, int left, int right) {
        int length = right - left + 1;
        // if the subarray has 2 or 0 elements, we can just return
        // as this should be the base case
        if  (length <= 2) {  //left >= right - 1
            return;
        }

        //Calculate the important mid points:
        // 0    1   2   3   4   5   6   7
        //lm:2, m:4, rm:6
        // 0    1   2   3   4   5   6   7   8   9
        //lm:2,     m:5,    rm:7
        int mid = left + length / 2;
        int lmid = left + length / 4;
        int rmid = left + length * 3 / 4;
        reverse(array, lmid, mid - 1);
        reverse(array, mid, rmid - 1);
        reverse(array, lmid, rmid - 1);
        // half of the left partition's size = lmid - left.
        reorder(array, left, left + (lmid - left) * 2 - 1);
        reorder(array, left + (lmid - left) * 2, right);
    }

    private void reverse(int[] array, int left, int right) {
        while (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main (String[] args) {
        ReOrderArray sol = new ReOrderArray();
        int[] array = new int[]{100,101,102,103,104,1,2,3,4,5};
        int[] res = sol.reorder(array);
        for (Integer ele: res) {
            System.out.println(ele);
        }
    }
}