package Laicode.Class9_StringII;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * aaaabccaaaaa -> a4b1c2a5
 *
 * Step1: from left to right, we only copy and encode those patterns that can becomes shorter or not change. (we do not deal with the pattern such b, that only appears once)
 * In the meantime, we need to count how many times the pattern that become longer appears
 * counter = 1, because there is only one place that the pattern can become longer
 * more space = (2 -1 )* counter = 1
 * a4bc2a5 -> a4b1c2a5 和string replacement一样，加place_holder
 * 只有一个字母的时候会出问题
 *
 * Step2: if the pattern has been shorten, the new pattern must be (letter * digt)
 */
public class StringEncoding {
	public String encoding(String s) {
		if (s == null || s.length() == 0)
			return s;

		char[] arr = Arrays.copyOf(s.toCharArray(),100);
		int slow = 0;
		int fast = 0;
		int count = 0;
		Set<Integer> set = new HashSet<>();
		while (fast < s.length()) {
			char cur =  s.charAt(fast);
			arr[slow++] = cur;
			while (fast < s.length() && s.charAt(fast) == cur) {
				fast++;
				count++;
			}
			if (count != 1) {
				arr[slow++] = (char)(count + '0');
			} else {
				set.add(slow - 1);
			}
			count = 0;
		}

		fast = slow - 1;
		slow = slow + set.size() - 1;
		int end = slow;
		while (fast >= 0) {
			if (set.contains(fast)) {
				arr[slow--] = '1';
			}
			arr[slow--] = arr[fast--];
		}

		return new String(arr, 0, end + 1);
	}

	public static void main(String[] args) {
		StringEncoding sol = new StringEncoding();
		String s = "aaaabccaaaaa";
		System.out.println(sol.encoding(s));
	}
}
