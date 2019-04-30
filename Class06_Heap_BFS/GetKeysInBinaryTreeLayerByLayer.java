package Laicode.Class06_Heap_BFS;

import Laicode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Get the list of list of keys in a given binary tree layer by layer. Each layer is represented by a list of keys and the keys are traversed from left to right.
 * Examples
 * 
 *       5
 *    /    \
 *   3        8
 * /   \        \
 * 1     4        11
 * the result is [ [5], [3, 8], [1, 4, 11] ]
 * 
 * Corner Cases
 * What if the binary tree is null? Return an empty list of list in this case.
 * 
 * Time = O(n)
 * Space = O(n)
 */

public class GetKeysInBinaryTreeLayerByLayer {
    public List<List<Integer>> layerByLayer(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // the list storing all the nodes on the current level.
            List<Integer> curLayer = new ArrayList<>();
            // the size of current level
            int size = queue.size();
            // treverse all the nodes on the current level and
            // prepare for the next level.
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                curLayer.add(cur.key);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            list.add(curLayer);
        }
        return list;
    }
}