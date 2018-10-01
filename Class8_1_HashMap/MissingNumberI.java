/**
 * Description
 * Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.
 * 
 * Assumptions
 * The given array is not null, and N >= 1
 * 
 * Examples
 * A = {2, 1, 4}, the missing number is 3
 * A = {1, 2, 3}, the missing number is 4
 * A = {}, the missing number is 1
 * 
 * Method1: Time = O(n), Space = O(n)
 * Method2: Time = O(n), Space = O(1), but may overflow when n is large
 * Method3: Time = O(n), Space = O(1)
 */

public class MissingNumberI {
    // Method1: use HashSet
    // Assumption: array is not null
    public int missingI(int[] array) {
        int n = array.length + 1;
        HasheSet<Integer> set = new HashSet<Integer>();
        for (int num : array) {
            set.add(number);
        }
        for (int i = 1; i < n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return n;
    }

    // Method2: use sum.
    public int missingII(int[] array) {
        int n = array.length + 1;
        long targetSum = (n + 0L) * (n + 1) / 2;
        long actualSum = 0L;
        for (int num : array) {
            acutualSum += num;
        }
        return (int) (targetSum - actualSum);
    }

    //Method3: use bit operation
    public int missingIII(int[] array) {
        int n = array.length + 1;
        int xor = 0;
        // xor 1 to n
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        // after this operation, all the numbers from 1 to n
        // are pair xor’ed expect for the missing number.
        // since x^x = 0, the remaining number is the result.
        for (int num : array) {
            xor ^= num;
        }
        return xor;
    }
}
