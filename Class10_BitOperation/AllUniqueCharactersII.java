package Laicode.Class10_BitOperation;

/**
 * All Unique Characters II
 * Description
 * Determine if the characters of a given string are all unique.
 *
 * Assumptions
 * We are using ASCII charset, the value of valid characters are from 0 to 255
 * The given string is not null
 *
 * Examples
 * all the characters in "abA+\8" are unique
 * "abA+\a88" contains duplicate characters
 *
 * Time = O(n)
 * Space = O(8 * 32) = O(1)
 */
public class AllUniqueCharactersII {
	public boolean allUnique(String word) {
		if (word.length() == 0)
			return true;

		// each int value can represent 32 bit, so we need 8 ints
		// to represent 256 bits.
		int[] vec = new int[8];
		for (char c: word.toCharArray()) {
			// for a value c in the range of 0-255
			// it is actually mapped to the int value at c/32 as index,
			// and the c%32'th bit of the int value.
			int row = c / 32;
			int col = c % 32;
			if (((vec[row] >> col) & 1) != 0)
				return false;
			vec[row] |= 1 << col;
		}
		return true;
	}
}
