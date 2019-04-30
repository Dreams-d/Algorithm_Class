package Laicode.Class09_StringII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description
 * Find all occurrence of anagrams of a given string s in a given string l.
 * Return the list of starting indices.
 *
 * Assumptions
 * s is not null or empty.
 * l is not null.
 * Examples
 * l = "abcbac", s = "ab", return [0, 3] since the substring with length 2
 * starting from index 0/3 are all anagrams of "ab" ("ab", "ba").
 */
public class AllAnagrams {
	// Find all anagrams of String s in String l, return all the starting indices.
	// Assumptions: s,l are not null, s is not empty
	public List<Integer> allAnagrams(String s, String l) {
		List<Integer> res = new ArrayList<>();
		if (l.length() == 0) {
			return res;
		}

		//This map records for each of the distinct character in s,
		//how many characters are needed.
		//e.g. s = "abbc", map = {'a':1,'b':2,'c':1}
		//when we get an instance of 'a' in l, we let count of 'a' decremented by 1,
		//and only when the count if from 1 to 0, we have 'a' totally matched.
		Map<Character, Integer> map = countMap(s);

		//Record how many distinct characters have been matched.
		//only when all the distinct characters are matched, A.K.A.
		//match == map.size(), we find an anagram.
		int match = 0;
		//We have a sliding window of size s.length(), and since the size is fixed,
		//we only need to record the end index of the sliding  window.
		//Also, when move the sliding window by one step from left to right,
		//what we only need to change is
		//1. remove the leftmost character at the previous sliding window
		//2. add the rightmost character at the current sliding window.
		for (int i =  0; i < l.length(); i++) {
			//handle the new added character(rightmost) at the current sliding window.
			char c = l.charAt(i);
			Integer count =  map.get(c);
			if (count != null) {
				// the number of needed count should be --.
				// and only when the count is from 1 to 0, we find an additional
				// match of distinct character.
				map.put(c, count - 1);
				if (count == 1) {
					match++;
				}
			}
			//handle the leftmost character at the previous sliding window
			if (i >= s.length()) {
				c = l.charAt(i - s.length());
				count = map.get(c);
				if (count != null) {
					// the number of needed count should be ++.
					// and only when the count is from 1 to 0, we are short for one
					// match of distinct character.
					map.put(c, count + 1);
					if (count == 0) {
						match--;
					}
				}
			}

			//for the current sliding window, if all the distinct characters are matched
			//(the count are all zero).
			if (match == map.size()) {
				res.add(i - s.length() + 1);
			}
		}
		return res;
	}

	private Map<Character, Integer> countMap(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch: s.toCharArray()) {
			Integer count = map.get(ch);
			if (count == null) {
				map.put(ch,1);
			} else {
				map.put(ch, count + 1);
			}
		}
		return map;
	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if(p.length()> s.length())
			return result;

		Map<Character, Integer> map = new HashMap<>();
		for(char c : p.toCharArray()){
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int match = map.size();
		int left = 0, right = 0;

		while(right < s.length()){
			char c = s.charAt(right);
			if( map.containsKey(c) ){
				map.put(c, map.get(c)-1);
				if(map.get(c) == 0) {
					match--;
				}
			}

			// Only when we find all letters are matched, we move the left point to position
			// where we can find the substring that is as long as pattern
			while(match == 0){
				if(right - left + 1 == p.length()){
					result.add(left);
				}

				char tempc = s.charAt(left);
				if(map.containsKey(tempc)){
					map.put(tempc, map.get(tempc) + 1);
					if(map.get(tempc) > 0){
						match++;
					}
				}

				left++;
			}
			right++;
		}
		return result;
	}

	public static void main (String[] args) {
		AllAnagrams sol = new AllAnagrams();
		String l = "abcbac", s = "ab";
		List<Integer> res  = sol.allAnagrams(s,l);
		for (Integer idx:res)
			System.out.println(idx);
	}
}
