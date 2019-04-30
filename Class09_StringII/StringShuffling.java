package Laicode.Class09_StringII;

/**
 * Advance Topic of Merge Sort
 * 'A1B2C3D4E5' -> 'ABCDE12345'
 */
public class StringShuffling {
	/**
	 * Same as merge sort
	 * Time = O(nlogn)
	 * Space = O(n) for helper array
	 */
	public char[] shuffle(char[] array) {
		if (array == null || array.length == 0) return array;
		char[] helper = new char[array.length];
		shuffle(array, helper,0, array.length - 1);
		return array;
	}

	private void shuffle(char[] array, char[] helper, int left, int right) {
		if (left >= right) {
			return;
		}

		int mid = left + (right - left) / 2;
		shuffle(array, helper, left, mid);
		shuffle(array, helper, mid + 1, right);
		merge(array,helper,left,mid,right);
	}

	private void merge(char[] array, char[] helper, int start, int mid, int end) {
		for (int i = start; i <= end; i++) {
			helper[i] = array[i];
		}

		int left = start;
		int right = mid + 1;
		int idx = start;
		while (left <= mid && right <= end) {
			if (Character.isDigit(helper[left]) && Character.isDigit(helper[right]) ||
					Character.isLetter(helper[left]) && Character.isLetter(helper[right])) {
				if (helper[left] < helper[right]) {
					array[idx++] = helper[left++];
				} else {
					array[idx++]  = helper[right++];
				}
			} else if (Character.isDigit(helper[left]) && Character.isLetter(helper[right])){
				array[idx++]  = helper[right++];
			} else {
				array[idx++]  = helper[left++];
			}
		}

		while (left <= mid) {
			array[idx++]  = helper[left++];
		}
	}

	public static void main (String[] args) {
		StringShuffling sol = new StringShuffling();
		char[] array = new char[]{'A','1','B','2','C','3','D','4','E','5'};
		char[] res = sol.shuffle(array);
		for (char ele: res) {
			System.out.println(ele);
		}
	}
}
