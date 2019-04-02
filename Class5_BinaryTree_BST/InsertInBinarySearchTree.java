package Laicode.Class5_BinaryTree_BST;

/**
 * Insert In Binary Search Tree
 * Description
 * Insert a key in a binary search tree if the binary search tree does not already contain the key. Return the root of the binary search tree.
 *
 * Assumptions
 * There are no duplicate keys in the binary search tree
 * If the key is already existed in the binary search tree, you do not need to do anything
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
 *  1     4
 *
 * insert 11, the tree becomes
 *
 *         5
 *
 *       /    \
 *
 *     3        8
 *
 *   /   \        \
 *
 *  1     4       11
 *
 * insert 6, the tree becomes
 *
 *         5
 *
 *       /    \
 *
 *     3        8
 *
 *   /   \     /  \
 *
 *  1     4   6    11
 *
 * time = O(height)
 * space = O(height)
 */

public class InsertInBinarySearchTree {
  public TreeNode insert(TreeNode root, int key) {
    if (root == null) {
      return new TreeNode(key);
    }
    if (root.key > key) {
      root.left = insert(root.left, key);
    } else if (root.key < key) {
      root.right = insert(root.right, key);
    }
    return root;
  }
}