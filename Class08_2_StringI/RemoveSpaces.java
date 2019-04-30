package Laicode.Class08_2_StringI;

/**
 * Remove Spaces
 * Description
 * Given a string, remove all leading/trailing/duplicated empty spaces.
 *
 * Assumptions
 * The given string is not null.
 *
 * Examples
 * “  a” --> “a”
 * “   I     love MTV ” --> “I love MTV”
 *
 * Time = O(n)
 * Space = O(1)
 */

public class RemoveSpaces {
	// Assumption: input is not null
	public String removeSpacesI(String input) {
		if (input.isEmpty()) {
			return input;
		}
		char[] array = input.toCharArray();
		int end = 0;
		for (int i = 0; i < array.length; i++) {
			// when we would ignore the current space character:
			// 1. we ignore all the space characters followed by
			// another space character, so that if there are several
			// consecutive space characters, only the first one will
			// be remained.
			// 2. we ignore also the space character if it is the
			// first character of the input string.

			if (array[i] == ' ' && (i == 0 || array[i - 1] == ' ')) {
				continue;
			}
			array[end++] = array[i];
		}
		// Post-processing: it is possible we still have one trailing
		// space character at the end.
		// input = "   "(more than 1 space) -> ""
		if (end > 0 && array[end - 1] == ' ') {
			return new String(array, 0, end - 1);
		}
		//String(char[] value, int offset, int count)
		return new String(array, 0, end);
	}

	// More easy to understand
	public String removeSpacesII(String input) {
		if (input.length() == 0) {
			return input;
		}

		char[] arr = input.toCharArray();
		int fast = 0;
		// avoid leading spaces
		while (fast < arr.length && arr[fast] == ' ') {
			fast++;
		}

		int slow = 0;
		while (fast < arr.length) {
			// avoid trailing spaces at the same time, because we copy the last valid space
			if (arr[fast] != ' ' || (fast < arr.length - 1 && arr[fast + 1] != ' ')) {
				arr[slow++] = arr[fast];
			}
			fast++;
		}
		return new String(arr, 0, slow);
	}
}