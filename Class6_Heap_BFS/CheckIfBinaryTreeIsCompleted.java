package Laicode.Class6_Heap_BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description
 * Check if a given binary tree is completed. A complete binary tree is one in which every level of the binary tree is completely filled except possibly the last level. Furthermore, all nodes are as far left as possible.
 * 
 * Examples
 *         5
 *       /    \
 *     3        8
 *   /   \
 * 1      4
 * is completed.
 * 
 * Corner Cases
 * What if the binary tree is null? Return true in this case.
 * 
 * Time = O(n)
 * Space = O(n)
 */


public class CheckIfBinaryTreeIsCompleted {
    public boolean isCompleted(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // if the flag is set true, there should not be any child nodes afterwards.
        boolean flag = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // if any of the child is not present, set the flag to true.
            if (cur.left == null) {
                flag = true;
            } else if (flag) {
                // if flag is set but we still see cur has a left child,
                // the binary tree is not a completed one.
                return false;
            } else {
                // if flag is not set and left child is present.
                queue.offer(cur.left);
            }
            // same logic applied to the right child.
            if (cur.right == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(cur.right);
            }
        }
        return true;
    }
}