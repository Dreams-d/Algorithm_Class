package Laicode.Class10_BitOperation;

/**
 * Hexadecimal Representation
 * Description
 * Generate the hexadecimal representation for a given non-negative integer number as a string. The hex representation should start with "0x".
 * There should not be extra zeros on the left side.
 *
 * Examples
 * 0's hex representation is "0x0"
 * 255's hex representation is "0xFF"
 *
 * Time = O(32)
 * Space = O(1)
 */
public class HexadecimalRepresentation {
	//Method1: divide by 16, cannot avoid leading 0's.
	public String hexI(int number) {
		// Assumption: for non-negative input
		if (number == 0) {
			return "0x0";
		}

		// using StringBuilder so append operation is more efficient.
		StringBuilder sb = new StringBuilder();
		String prefix = "0x";
		while (number > 0) {
			int rem = number % 16;
			if (rem < 10) {
				sb.append((char) ('0' + rem));
			} else {
				sb.append((char) (rem - 10 + 'A'));
			}
			number >>>= 4;
		}
		//reverse it at last so in all complexity is O(n).
		return prefix + sb.reverse().toString();
	}

	// Method2: represent by binary
	public String hexII(int number) {
		if (number == 0) {
			return "0x0";
		}

		char[] base = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		StringBuilder sb = new StringBuilder("0x");
		boolean isLeading = true;
		for (int end = 28; end >= 0; end -= 4) {
			char cur = base[(number >> end) & 0xF];
			if (cur != '0' || !isLeading) {
				sb.append(cur);
				isLeading = false;
			}
		}

		return sb.toString();
	}
}
