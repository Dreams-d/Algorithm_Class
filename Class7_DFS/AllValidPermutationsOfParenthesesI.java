package Laicode.Class7_DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * Given N pairs of parentheses “()”, return a list with all the valid permutations.
 * 
 * Assumptions
 * N >= 0
 * 
 * Examples
 * N = 1, all valid permutations are ["()"]
 * N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
 * N = 0, all valid permutations are [""]
 * 
 * Time = O(2^(2n))
 * Space = O(2n)
 */

public class AllValidPermutationsOfParenthesesI {
    public List<String> validParenthesis(int k) {
        List<String> result = new ArrayList<>();
        // the final string contains 2k characters.
        char[] cur = new char[k * 2];
        DFS(cur, k, k, 0, result);
        return result;
    }

    // left: how many ‘(’ we still have
    // right: how many ‘)’ we still have
    // index: the current position in cur we want to fill in with either ‘(’ or ‘)’
    public void DFS(char[] cur, int left, int right, int index, List<String> result) {
        // terminate condition:
        // when we do not have any parenthesis left
        if (left == 0 && right == 0) {
            result.add(new String(cur));
            return;
        }
        // when can we add a ‘(‘? whenever there is some ‘(‘ we can still use.
        if (left > 0) {
            cur[index] = '(';
            DFS(cur, left - 1, right, index + 1, result);
            // NOTICE: it looks like we donot do anything when back tracking to
            // the previous level.
            // the code is still correct because:
            // 1. we are setting the character at index and when back tracking,
            // what we need is just 1) remove the character at index and 2) add
            // a different character at index.
            // 2. only when we fill in all the position in cur, we have a complete
            // solution.
            // thec code itself actually already suffices the above two points and
            // it already does the currect removing operation when back tracked to //the
            // previous level.
        }
        // when can we add a ‘)’? when there is more ‘(‘ than ‘)’ used.
        // because each ‘)’ should be associated with a previous ‘(‘
        if (right > left) {
            cur[index] = ')';
            DFS(cur, left, right - 1, index + 1, result);
        }
    }
}