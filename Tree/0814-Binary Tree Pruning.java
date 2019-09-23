// Recursive
// 1. what should the function return(functionality)
// 2. what is the end case
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        
        root.left = pruneTree(root.left); // prune children first
        root.right = pruneTree(root.right);
        
        if (root.left == null && root.right == null && root.val == 0) return null; // prune current
        
        return root;
    }
}