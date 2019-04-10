package Laicode.Class9_StringII;

/**
 * Given a string in compressed form, decompress it to the original string. The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences.
 *
 * Assumptions
 * The string is not null
 * The characters used in the original string are guaranteed to be ‘a’ - ‘z’
 * There are no adjacent repeated characters with length > 9
 *
 * Examples
 * “a1c0b2c4” → “abbcccc”
 */
public class DecompressingII {
	// Method1: "in place"
	// When we say in place, it usually means the input is a long enough
	// char array, and the original String only occupies part of the array
	// starting from index 0, and usually the length to represent the origin
	// string is given.
	public String decompressI(String input) {
		if (input.isEmpty()) return input;

		char[] array = input.toCharArray();
		// We need to handle the
		// "a0","a1","a2" case (the decoded string  is shorter) and
		// "a3","a4" ... case (the decoded string is longer)
		// in two pass to avoid conflict, since the encoding of the two cases
		// require different directions.
		return decodeLong(array,decodeShort(array));
	}

	// return the length of the decoded string,
	// only cares about "a0","a1","a2", A.K.A
	// the decoded string is shorter
	private int decodeShort(char[] input) {
		// since the decoded string is shorter, we should
		// do the decoding work from left to right direction.
		int end = 0;
		for (int i = 0; i < input.length; i += 2) {
			int digit =  getDigit(input[i + 1]);
			if (digit >= 0 && digit <= 2) {
				for (int j = 0; j < digit; j++) {
					input[end++] = input[i];
				}
			} else {
				// we don't handle the longer decoded string here.
				input[end++] = input[i];
				input[end++] = input[i + 1];
			}
		}
		return end;
	}

	// take care of "a3","a4","a5", ...
	// the decoded string is longer
	// length: the length of the valid partition starting from index 0.
	private String decodeLong(char[] input, int length) {
		// we need to calculate the new required length.
		int newLength = length;
		for (int i = 0; i < length; i++) {
			int digit = getDigit(input[i]);
			if (digit > 2 && digit <= 9) {
				newLength += digit - 2;
			}
		}
		// Notice: if it is required to do this in place, usually the input
		// array is a sufficient large one, you will not need to
		// allocate a new array. This solution is only for demonstration.
		char[] res = new char[newLength];
		int end = newLength - 1;
		for (int i = length - 1; i >= 0; i--) {
			int digit =  getDigit(input[i]);
			if (digit > 2 && digit <= 9) {
				i--;
				for (int j = 0; j < digit; j++) {
					res[end--] = input[i];
				}
			} else {
				// we already take care the shorter cases, "a1" in previous pass.
				// we can leave as it is. e.g. the input could be "abc2".
				res[end--] = input[i];
			}
		}
		return new String(res);
	}

	private int getDigit(char digit) {
		return digit - '0';
	}

	// Method2: using StringBuilder to help
	public String decompressII(String input) {
		char[] array = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			char ch = array[i++];
			int count = array[i] - '0';
			for (int c = 0; c < count; c++) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
}
