package Laicode.Class5_BinaryTree_BST;

/**
 * Search In Binary Search Tree
 * Description
 * Find the target key K in the given binary search tree, return the node that contains the key if K is found, otherwise return null.
 *
 * Assumptions
 * There are no duplicate keys in the binary search tree
 *
 * time = O(logn)
 * space = O(height) / O(1)
 */

public class SearchInBinarySearchTree {
    public TreeNode search(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.key == key) {
            return root;
        } else if (root.key > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public TreeNode searchIte(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        TreeNode cur = root;
        while (cur != null) {
            if (cur.key == key) {
                return cur;
            } else if (cur.key > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return cur;
    }
}