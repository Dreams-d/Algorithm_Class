package Laicode.Class10_BitOperation;

/**
 * Determine if a given integer is power of 2.
 *
 * Examples
 * 16 is power of 2 (2 ^ 4)
 * 3 is not
 * 0 is not
 * -1 is not
 */
public class PowerOfTwo {
	/**
	 * Method1: ignore all trailing zeros.
	 * Time = O(#of trailing 0's)
	 * Space = O(1)
	 */
	public boolean isPowerOfTwoI(int number) {
		if (number <= 0) {
			return false;
		}
		//ignore all the trailing 0's.
		while ((number & 1) == 0) {
			number >>>= 1;
		}
		//check if the number is 1 at the end.
		return number == 1;
	}

	/**
	 * Method2: count the number of 1's
	 * Time = O(#of bits)
	 * Space = O(1)
	 */
	public boolean isPowerOfTwoII(int number) {
		if (number <= 0) {
			return false;
		}
		//count the number of 1's
		int count = 0;
		while (number > 0) {
			count += number & 1;
			number >>>= 1;
		}
		// for a number of power of 2, there should be only one 1.
		return count == 1;
	}


	/**
	 * Method3: count the number of 1's
	 * Time = O(#of bits)
	 * Space = O(1)
	 */
	public boolean isPowerOfTwoIII(int number) {
		if (number <= 0) {
			return false;
		}
		// use the trick of number & (number -1) will remove the rightmost 1.
		return (number & (number - 1)) == 0;
	}
}
