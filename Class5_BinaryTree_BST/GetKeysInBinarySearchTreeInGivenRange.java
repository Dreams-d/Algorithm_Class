package Laicode.Class5_BinaryTree_BST;

import Laicode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Get Keys In Binary Search Tree In Given Range
 * Description
 * Get the list of keys in a given binary search tree in a given range[min, max] in ascending order, both min and max are inclusive.
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
 *  1     4        11
 *
 * get the keys in [2, 5] in ascending order, result is  [3, 4, 5]
 *
 * Corner Cases
 * What if there are no keys in the given range? Return an empty list in this case.
 *
 * time = O(n)	//O(height + logk)
 * space = O(height)
 */

public class GetKeysInBinarySearchTreeInGivenRange {
	public List<Integer> getRange(TreeNode root, int min, int max) {
		List<Integer> list = new ArrayList<>();
		getRange(root, min, max, list);
		return list;
	}

	private void getRange(TreeNode root, int min, int max, List<Integer> list) {
		if (root == null) {
			return;
		}
		// 1. determine if left subtree should be traversed, only when root.key >
		// min, we should traverse the left subtree
		if (root.key > min) {
			getRange(root.left, min, max, list);
		}
		// 2. determine if root should be traversed
		if (root.key >= min && root.key <= max) {
			list.add(root.key);
		}
		// 3. determine if right subtree should be traversed, only when
		// root.key < max, we should traverse the right subtree
		if (root.key < max) {
			getRange(root.right, min, max, list);
		}
	}
}