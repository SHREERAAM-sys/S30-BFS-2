/*
    L.C: 993. Cousins in Binary Tree

    Approach: BFS

    Time Complexity: O(n)
    Space Complexity: O(n) - max queue size
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false; // If the tree is empty
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            boolean xFound = false, yFound = false;
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                if (current.val == x) {
                    xFound = true; // Mark x as found
                }
                if (current.val == y) {
                    yFound = true; // Mark y as found
                }

                if (current.left != null && current.right != null) {
                    int leftVal = current.left.val;
                    int rightVal = current.right.val;
                    if ((leftVal == x && rightVal == y) || (leftVal == y && rightVal == x)) {
                        return false; // x and y are siblings, not cousins
                    }
                }

                if (current.left != null) {
                    queue.add(current.left); // Add left child to the queue
                }
                if (current.right != null) {
                    queue.add(current.right); // Add right child to the queue
                }
            }

            if (xFound && yFound) {
                return true; // x and y are cousins
            }
            if (xFound || yFound) {
                return false; // Only one is found at this level, not cousins
            }
        }

        return false;
    }
}

