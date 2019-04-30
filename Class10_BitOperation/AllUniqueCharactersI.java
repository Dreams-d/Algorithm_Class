package Laicode.Class10_BitOperation;

/**
 * All Unique Characters I
 * Description
 * Determine if the characters of a given string are all unique.
 *
 * Assumptions
 * The only set of possible characters used in the string are 'a' - 'z', the 26 lower case letters.
 * The given string is not null.
 *
 * Examples
 * the characters used in "abcd" are unique
 * the characters used in "aba" are not unique
 *
 * Time = O(n)
 * Space = O(32) = O(1)
 */
public class AllUniqueCharactersI {
	// Method1: Hashset
	// Method2: bucket
	// Method3: use one int to represent each char
	public boolean allUnique(String word) {
		if (word.length() == 0) return true;
		int occur = 0;
		for (char c: word.toCharArray()) {
			int k = c - 'a';
			if (((occur >> k) & 1) == 1)
				return false;
			occur |= 1 << k;
		}
		return true;
	}
}
