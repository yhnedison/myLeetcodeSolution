/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true; // end case
        if (root != null && Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) 
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }
}