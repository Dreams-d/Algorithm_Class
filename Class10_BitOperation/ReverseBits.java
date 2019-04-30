package Laicode.Class10_BitOperation;

/**
 * Reverse all bits of a number
 * Assumption:
 * The string is in ASCII representation
 *
 * e.g. 1010 0010 ->  0100 0101
 *
 * Time = O(n)
 * Space = O(1)
 */
public class ReverseBits {
	public int reverseI(int num) {
		for (int offset = 0; offset < 16; offset++) {
			int rihgt = (num >> offset) & 1;
			int left = (num >> (31 - offset)) & 1;
			if (left != rihgt) {
				int mask = (1 << left) | (1 << rihgt);
				num ^= mask;
			}
		}
		return  num;
	}
}
