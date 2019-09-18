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
    public List<Integer> inorderTraversal(TreeNode root) {
        //Recursive
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }
    private void traversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        traversal(root.left, result);
        result.add(root.val);
        traversal(root.right, result);
    }
}


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // iterative dfs using stack
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.empty()) {
            while (curr != null) { // this block keep push left node to stack
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop(); // pop left-most node
            result.add(curr.val); // do the operation, either printing or adding to list
            curr = curr.right;
        }
        return result;
    }
}


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // iterative, one loop
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                result.add(curr.val);  // Add after all left children
                curr = curr.right;   
            }
        }
        return result;
    }
}

