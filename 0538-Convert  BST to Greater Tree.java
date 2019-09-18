/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //Two Pass, 6% 6%
class Solution {
    public TreeNode convertBST(TreeNode root) {
        // First pass calculate sum
        // Preorder Traversal
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        stack.push(curr);
        while (!stack.isEmpty()) {
            curr = stack.pop();
            if (curr != null) {
                sum += curr.val;
                stack.push(curr.right);
                stack.push(curr.left);
            }
        }
        
        // Second psss, rebuild tree value
        // Inorder traversal, calculate currentSum(includeing current node)
        // for each node, newValue = sum - currentSum
        int currentSum = 0;
        curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            currentSum += curr.val;
            curr.val = sum - currentSum + curr.val;
            curr = curr.right;
        }

        return root;
    }
}