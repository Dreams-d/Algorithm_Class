package Laicode.Class09_StringII;

/**
 * Description Reverse the words in a sentence.
 * 
 * Assumptions Words are separated by single space There are no heading or
 * tailing white spaces
 * 
 * Examples “I love Google” → “Google love I”
 * 
 * Corner Cases If the given string is null, we do not need to do anything.
 * 
 * Time = O(2n)
 * Space = O(1)
 */

public class ReverseWordsInASentenceI {
    // Assumptions:
    // 1). The words are separated by one space character.
    // 2). Therer are no leading or trailing spaces.
    // 3). input is not null
    public String reverseWords(String input) {
        // try to convert it to char array and
        // solve the problem in-place
        char[] array = input.toCharArray();
        // 1. reverse the whole array.
        reverse(array, 0, array.length - 1);
        int start = 0;
        // 2. reverse each of the words
        for (int i = 0; i < array.length; i++) {
            // the start index of a word
            if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
                start = i;
            }
            // the end index of a word
            if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
                reverse(array, start, i);
            }
        }
        return new String(array);
    }

    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
}
