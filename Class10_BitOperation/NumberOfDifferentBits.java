package Laicode.Class10_BitOperation;

/**
 * Number Of Different Bits
 * Description
 * Determine the number of bits that are different for two given integers.
 *
 * Examples
 * 5(“0101”) and 8(“1000”) has 3 different bits
 *
 * Time = O(#of bits)
 * Space = O(1)
 */
public class NumberOfDifferentBits {
	public int diffBits(int a, int b) {
		// after exclusive or, only the bits where a and b
		// are different will be 1.
		a ^= b;
		int res = 0;
		// In Java, notice we are using logical right shift >>>.
		// and a != 0 as the terminate condition.
		while (a != 0) {
			res += a & 1;
			a >>>= 1;
		}
		return res;
	}

	public static void main(String[] args) {
		int a = Integer.MAX_VALUE;
		int b = -1;
		NumberOfDifferentBits sol = new NumberOfDifferentBits();

		System.out.println(sol.diffBits(a,b));

	}
}
