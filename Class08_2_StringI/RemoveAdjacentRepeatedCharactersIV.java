package Laicode.Class08_2_StringI;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description
 * Repeatedly remove all adjacent, repeated characters in a given string from left to right.
 * No adjacent characters should be identified in the final string.
 * 
 * Examples
 * "abbbaaccz" → "aaaccz" → "ccz" → "z"
 * "aabccdc" → "bccdc" → "bdc"
 * 
 * Time = O(n)
 * Space = O(n) / O(1)
 */

public class RemoveAdjacentRepeatedCharactersIV {
    public String deDupI(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }

        char[] array = input.toCharArray();
        Deque<Character> stack = new LinkedList<Character>();
        int i = 0;
        while (i < array.length) {
            if (stack.isEmpty() || array[i] != stack.peek()) {
                stack.push(array[i]);
                i++;
            } else {
                while (i < array.length && array[i] == stack.peek()) {
                    i++;
                }
                stack.pop();
            }
        }
        int size = stack.size();
        int index = size - 1;
        while (!stack.isEmpty()) {
            array[index--] = stack.pop();
        }
        return new String(array, 0, size);
    }

    public String deDupII(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        // try to convert the string to char[], and do it in-place.
        char[] array = input.toCharArray();
        // instead of ysung a extra stcak explicitly, we can actually
        // reuse the left side of the original char[] as the “stack”
        // end: is where the top of the stack is.
        int end = 0;
        for (int i = 1; i < array.length; i++) {
            // if the stack is empty (when end=-1) or there is no duplicate chars,
            // we are able to push the character into the stack
            if (end == -1 || array[i] != array[end]) {
                array[++end] = array[i];
            } else {
                // otherwise, we need pop the top element by end--,
                // and ignore all the consecutive duplicate chars.
                while (i < array.length - 1 && array[i + 1] == array[end]) {
                    i++;
                }
                end--;
            }
        }
        return new String(array, 0, end + 1);
    }
}