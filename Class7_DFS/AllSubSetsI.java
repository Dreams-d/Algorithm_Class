package Laicode.Class7_DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * Given a set of characters represented by a String, return a list containing all subsets of the characters.
 * 
 * Assumptions
 * There are no duplicate characters in the original set.
 * 
 *  Examples
 * Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
 * Set = "", all the subsets are [""]
 * Set = null, all the subsets are []
 * 
 * Time = O(2^n) n levels to determine whether to add the element or not
 * Space =  O(n)
 * */


public class AllSubSetsI {
    // Assumptions: there are no duplicate characters in thr given string.
    // Method1: DFS solution
    public List<String> SubSetsI(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }

        char[] arraySet = set.toCharArray();
        // record the current subset
        StringBuilder sb = new StringBuilder();
        helper(arraySet, sb, 0, result);
        return result;
    }

    // At each level, determine the character at the position “index” to be picked
    // //or not
    private void helper(char[] set, StringBuilder sb, int index, List<String> result) {
        // termination condition:
        // when we finishes determining for all the characters pick or not,
        // we have a complete subset.
        if (index == set.length) {
            // index = 2的时候，还要决定要不要加c，所以在下一层才设为base case
            result.add(sb.toString());
            return;
        }
        // 1. not pick the characters at index
        helper(set, sb, index + 1, result);
        // 2. pick the character at index
        helper(set, sb.append(set[index]), index + 1, result);
        // remember to remove the added character when back tracking to the previous
        // //level.
        sb.deleteCharAt(sb.length() - 1);
    }
}