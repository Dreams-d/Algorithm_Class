package Laicode.Class9_StringII;

import java.util.HashSet;
import java.util.Set;

/** String Replace
 * Description
 * Given an original string input, and two strings S and T, replace all occurrences of S in input with T.
 * 
 * Assumptions
 * input, S and T are not null, S is not empty string
 * 
 * Examples
 * input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
 * input = "dodododo", S = "dod", T = "a", input becomes "aoao"
 * 
 * Time = O(2n), Space = O(1)
 */
public class StringReplace {
    // Method1: Not using any String / StringBuilder utility,
    // and using char[] to do it "in-place"
    public String replace(String input, String source, String target) {
        // Assumptions: input, s, t are not null, s is not empty
        if (input.length() == 0 || source.length() == 0) {
            return input;
        }

        char[] array = input.toCharArray();
        if (source.length() >= target.length()) {
            return replaceShorter(array, source, target);
        }
        return replaceLonger(array, source, target);
    }

    private String replaceShorter(char[] input, String source, String target) {
        // We resuse the input char array, since the number of characters needed is less.
        // fast and slow pointers both from left to right direction.
        int slow = 0;
        int fast = 0;
        while (fast < input.length) {
            // when we find a match of s on the substring starting from the fast poiner,
            // we copy the t at slow pointer.
            if (fast <= input.length - source.length() && equal(input, source, fast)) {
                copySubString(input, target, slow);
                slow += target.length();
                fast += source.length();
            } else {
                input[slow++] = input[fast++];
            }
        }
        return new String(input, 0, slow);
    }

    private String replaceLonger(char[] array, String source, String target) {
        // Notice: we will need a longer array in the case, and if the requirement is "in palce"
        // usually assume you are given a long enough char array already, and the original input array 
        // resides on the part of the char array starting from index 0.
        // In this solution, we can actually allocate a larger array on demand, and the purpose 
        // of the solution is to demonstrate how to do it “in place”.

        // get all  the matches end positions in the input cha rarrat of string s.
        Set<Integer> matches = getMatches(array, source);
        // calculate the new length needed
        char[] result = new char[array.length + (target.length() - source.length()) * matches.size()];
        // fast and slow pointers both from right to left direction.
        // slow: the position when traversing the new length; the string to the right (not including slow) have been handled.
        // fast: the position when traversing the old length; 
        int slow = result.length - 1;
        int fast = array.length - 1;
        while (fast >= 0) {
            // only if we still have match and fast is the position of matching
            // end position, we should copy t.
            if (matches.contains(fast)) {
                copySubString(result, target, slow - target.length() + 1);
                slow -= target.length();
                fast -= source.length();
            } else {
                result[slow--] = array[fast--];
            }
        }
        return new String(result);
    }

    // get matches of s end position in the input
    private Set<Integer> getMatches(char[] array, String source) {
        Set<Integer> set = new HashSet<Integer>();
        int i = 0;
        while (i <= array.length - source.length()) {
            if (equal(array, source, i)) {
                // we record the match substring's end index instead of the start
                // index for later convenience.
                set.add(i + source.length() - 1);
                i += source.length();
            } else {
                i++;
            }
        }
        return set;
    }

    // check if the substring from fromIndex is the same as s
    private boolean equal(char[] array, String source, int fromIndex) {
        for (int i = 0; i < source.length(); i++) {
            if (array[fromIndex + i] != source.charAt(i))
                return false;
        }
        return true;
    }

    // copy the string t to result at fromIndex
    private void copySubString(char[] array, String target, int fromIndex) {
        for (int i = 0; i < target.length(); i++) {
            array[fromIndex + i] = target.charAt(i);
        }
    }

    // Method2: Using Java StringBuilder utility and String's indexof(),
    // not using String replace()
    public String replaceII(String input, String s, String t) {
        StringBuilder sb = new StringBuilder();
        // We check if there is a substring same as s
        // in the substring of input starting at fromIndex
        int fromIndex = 0;
        int matchIndex = input.indexOf(s,fromIndex);
        while (matchIndex != -1) {
            sb.append(input, fromIndex, matchIndex).append(t);
            // Next time we need to start from matchIndex + s.length()
            // to find if we have next matches
            fromIndex = matchIndex + s.length();
            matchIndex = input.indexOf(s, fromIndex);
        }
        sb.append(input, fromIndex, input.length());
        return sb.toString();
    }
}
