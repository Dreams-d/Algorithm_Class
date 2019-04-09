package Laicode.Class9_StringII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description
 * Given a string with possible duplicate characters, return a list with all permutations of the characters.
 *
 * Examples
 * Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
 * Set = "aba", all permutations are ["aab", "aba", "baa"]
 * Set = "", all permutations are [""]
 * Set = null, all permutations are []
 *
 * Time = O(n * n-1 * n-2 * ...) = O(n!)
 * Space = O(n)
 */
public class AllPermutationsII {
	public List<String> permutations(String set) {
		List<String> result = new ArrayList<>();
		if (set == null) {
			return result;
		}

		char[] arr = set.toCharArray();
		dfs(arr,result,0);
		return result;
	}

	// index: at the level of index, we are to determine for the current
	// permutation, which  element is positioned at index.
	private void dfs(char[] arr,List<String> res,int index) {
		if (index == arr.length) {
			//base case: when we have determined for all the indices of
			//current permutation which element to choose.
			res.add(new String(arr));
			return;
		}

		// Notice: the rule is just for the current level, if a certain element
		// is picked, we can not pick any of its duplicates.
		// so that we use a set to record all the distinct elements.
		Set<Character> used = new HashSet<>();
		for (int i = index; i < arr.length; i++) {
			// user.add(arr[i]) will return false  if the value of arr[i]
			// is already in the Set.
			if (used.add(arr[i])) {
				swap(arr,index,i);
				// go for the next level, index + 1
				dfs(arr,res,index+1);
				// don't forget to do the clear operation when backtracking.
				swap(arr,index,i);
			}
		}
	}

	private void swap(char[] arr,int i, int j)  {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j]  = tmp;
	}

	public static void main(String[] args) {
		AllPermutationsII sol = new AllPermutationsII();
		String s = "abacd";
		List<String> res = sol.permutations(s);
	}
}
