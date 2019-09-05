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
    public boolean findTarget(TreeNode root, int k) {
        //Recursive, using hashset
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }
    private boolean find(TreeNode root, int k, Set<Integer> set) {
        // preorder traversal
        if (root == null) return false; // end case
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}