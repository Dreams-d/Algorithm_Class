package Laicode.Class07_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description
 * Given a string with no duplicate characters, return a list with all permutations of the characters.
 * 
 * Examples
 * Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
 * Set = "", all permutations are [""]
 * Set = null, all permutations are []
 * 
 * Complexity
 * Time = O(n * n-1 * n-2 * ... * 1 = n!)
 * Space = O(n)
 * Solution2 is specifically designed for lexicographically output, which prototype is All Subset I
 */

public class AllPermutationsI {
    // 1. DFS solution with swapping
    public List<String> permutation(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        DFS(array, 0, result);
        return result;
    }

    // choose the character to be at the position of “index”
    // all the already chosen positions are (0, index - 1)
    // all the candidate characters can be at position “index”
    // are in the subarray of (index, array.length - 1)
    private void DFS(char[] array, int index, List<String> result) {
        // terminate condition:
        // only when we have already chosen the characters for all the position,
        // we can have a complete permutation
        if (index == array.length) {
            result.add(new String(array));
            return;
        }
        // all the possible characters could be placed at index are the
        // characters in the subarray (index, array.length - 1)
        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            DFS(array, index + 1, result);
            swap(array, index, i);
        }
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    // 2. Solution to maintain the order of all the permutations.
    // 这个按字典序输出的时候特别好用！！！！！！！
    public List<String> permutationsWithOrder(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        Arrays.sort(array);
        // record which index has been used in the original array
        boolean[] used = new boolean[array.length];
        StringBuilder cur = new StringBuilder();
        helper(array, used, cur, result);
        return result;
    }

    private void helper(char[] array, boolean[] used, StringBuilder cur, List<String> result) {
        // termination condition:
        // when permutation contains all the characters in the original array.
        if (cur.length() == array.length) {
            result.add(cur.toString());
            return;
        }
        // when we picking the next char, always according to the order.
        for (int i = 0; i < array.length; i++) {
            // if a character is already been used, we cannot pick it
            // for a second time
            if (!used[i]) {
                used[i] = true;
                cur.append(array[i]);
                helper(array, used, cur, result);
                used[i] = false;
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}
