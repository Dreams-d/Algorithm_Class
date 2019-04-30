package Laicode.Class05_BinaryTree_BST;

import Laicode.TreeNode;

/**
 * Tweaked Identical Binary Trees
 * Description
 * Determine whether two given binary trees are identical assuming any number of ‘tweak’s are allowed. A tweak is defined as a swap of the children of one node in the tree.
 *
 * Examples
 *
 *         5
 *
 *       /    \
 *
 *     3        8
 *
 *   /   \
 *
 * 1      4
 *
 * and
 *
 *         5
 *
 *       /    \
 *
 *     8        3
 *
 *            /   \
 *
 *           1     4
 *
 * the two binary trees are tweaked identical.
 *
 * T(n) = 4T(n/2) + O(1)
 * time = O(1 + 4 + 16 + ... + 4^logn) = O(4^logn) = O(2^(2logn)) = O(n^2) -- worst case: balanced
 * space = O(height)
 */

public class TweakedIdenticalBinaryTrees {
  public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
    if (one == null && two == null) {
      return true;
    } else if (one == null || two == null) {
      return false;
    } else if (one.key != two.key) {
      return false;
    }

    return isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)
        || isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
  }
}