package Laicode.Class09_StringII;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Right Shift By N Characters Description Right shift a given string by n
 * characters.
 * 
 * Assumptions The given string is not null. n >= 0.
 * 
 * Examples "abc", 4 -> "cab"
 * 
 * Time = O(2n) Space = O(1)
 */

public class RightShiftByNCharacters {
    // Assumption: input is not null, n >= 0
    public String rightShift(String input, int n) {
        if (input.length() <= 1 || n == 0) {
            return input;
        }

        int rightShift = n % input.length();
        char[] arr = input.toCharArray();
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, rightShift - 1);
        reverse(arr, rightShift, arr.length - 1);
        return new String(arr);
    }

    private void reverse(char[] input, int left, int right) {
        while (left < right) {
            char tmp = input[left];
            input[left] = input[right];
            input[right] = tmp;
            left++;
            right--;
        }
    }

    // Time = O(2(n+k)), Space = O(n)
    public String rightShiftByDeque(String input, int n) {
        if (input.length() <= 1 || n == 0) {
            return input;
        }

        int rightShift = n % input.length();
        char[] arr = input.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            stack.offerFirst(arr[i]);
        }

        int count = 0;
        while (count < rightShift) {
            char tmp = stack.pollFirst();
            stack.offerLast(tmp);
            count++;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pollLast();
        }

        return new String(arr);
    }
}
