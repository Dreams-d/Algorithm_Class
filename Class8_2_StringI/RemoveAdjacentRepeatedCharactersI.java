package Laicode.Class8_2_StringI;

/**
 * Description
 * Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.
 * 
 * Assumptions
 * Try to do it in place.
 * 
 * Examples
 * “aaaabbbc” is transferred to “abc”
 * 
 * Corner Cases
 * If the given string is null, we do not need to do anything.
 * 
 * Time = O(n), Space = O(1)
 */

 public class RemoveAdjacentRepeatedCharactersI {
    public String deDup(String input) {
        if (input == null) {
            return null;
        }
        char[] array = input.toCharArray();
        int end = 0;
        // all letters to the left-hand side of end (not including end) 
        // are processed letters that should be kept.
        for (int i = 0; i < array.length; i++) {
            // repeated characters will be ignored except
            // for the first character in the sequence
            if (i == 0 || array[i] != array[end - 1]) {
                array[end++] = array[i];
            }
        }
        return new String(array, 0, end);
    }
}
