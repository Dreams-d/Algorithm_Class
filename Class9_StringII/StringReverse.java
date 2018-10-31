/**
 * Description
 * Reverse a given string.
 * 
 * Assumptions
 * The given string is not null.
 * 
 * Time = O(n)
 * Space = O(1) - iterative
 * Space = O(n) - recursive
 */

public class ReverseString {
    // Method1: iterative reverse.
    public String reverse(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCHarArray();
        for (int left = 0, right = array.length - 1; left < right; left++, right--) {
            swap(array, left, right);
        }
        return new String(array);
    }

    // Method2: recursive reverse
    public String reverseRecursive(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        reverseHelper(array, 0, array.length - 1);
        return new String(array);
    }

    private void reverseHelper(char[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(array, left, right);
        reverseHelper(array, left + 1, right - 1);
    }

    private void swap(char[] array, int a, int b) {
        char tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
