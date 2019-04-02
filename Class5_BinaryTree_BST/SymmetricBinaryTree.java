package Laicode.Class5_BinaryTree_BST;

import Laicode.TreeNode;

/**
 * Symmetric Binary Tree
 * Description
 * Check if a given binary tree is symmetric.
 *
 * Examples
 *
 *       5
 *
 *     /    \
 *
 *   3        3
 *
 * /   \    /   \
 *
 * 1      4  4      1
 *
 * is symmetric.
 *
 *       5
 *
 *     /    \
 *
 *   3        3
 *
 * /   \    /   \
 *
 * 1      4  1      4
 *
 * is not symmetric.
 *
 * Corner Cases
 * What if the binary tree is null? Return true in this case.
 *
 * T(n) = 2T(n/2) + O(1)
 * time = O(1+2+4+…+n/2) < O(2*n/2) = O(n)
 * space = O(height)
 */

public class SymmetricBinaryTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root.left, root.right);
	}

	private boolean helper(TreeNode one, TreeNode two) {
		if (one == null && two == null) {
			return true;
		} else if (one == null || two == null) {
			return false;
		} else if (one.key != two.key) {
			return false;
		}
		return helper(one.left, two.right) && helper(one.right, two.left);
	}
}