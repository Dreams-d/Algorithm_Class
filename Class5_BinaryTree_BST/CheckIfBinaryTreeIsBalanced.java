package Laicode.Class5_BinaryTree_BST;

import Laicode.TreeNode;

/**
 * Check If Binary Tree Is Balanced
 * Description
 * Check if a given binary tree is balanced. A balanced binary tree is one in which the depths of every node’s left and right subtree differ by at most 1.
 *
 * Examples
 *
 *         5
 *
 *       /    \
 *
 *     3        8
 *
 *   /   \        \
 *
 * 1      4        11
 *
 * is balanced binary tree,
 *
 *         5
 *
 *       /
 *
 *     3
 *
 *   /   \
 *
 * 1      4
 *
 * is not balanced binary tree.
 *
 * Corner Cases
 * What if the binary tree is null? Return true in this case.
 *
 * T(n) = 2T(n/2) + O(n)
 * time = O(nlogn) -- worst case: balanced tree
 * space = O(height)
 */

public class CheckIfBinaryTreeIsBalanced {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if (Math.abs(left - right) > 1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}

	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
}