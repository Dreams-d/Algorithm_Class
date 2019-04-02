package Laicode.Class5_BinaryTree_BST;

/**
 * Description
 * Find the height of binary tree.
 * Examples:
 *         5
 *       /    \
 *     3        8
 *   /   \        \
 * 1      4        11
 * 
 * The height of above binary tree is 3.
 * 
 * Time = O(n)
 * Space = O(height)
 */

public class HeightofBinaryTree {
    public int findHeight(TreeNode root) {
      if (root == null) {
        return 0;
      }
      
      int leftHeight = findHeight(root.left);
      int rightHeight = findHeight(root.right);
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }
  