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
    public List<Integer> preorderTraversal(TreeNode root) {
        //Recursive
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }
    private void traversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        traversal(root.left, result);
        traversal(root.right, result);
    }
}

// Easy to Understand
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // iterative using stack 
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = null;
        stack.push(root);
        while(!stack.isEmpty()) {
            curr = stack.pop();
            if (curr != null) {
                result.add(curr.val);
                stack.push(curr.right); // FILO, push right first to pop left first
                stack.push(curr.left);
            }
        }
        return result;
    }
}


class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // iterative, one loop
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.empty()) {
            if (curr != null) { // keep push left to null, while adding val to result
                result.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                curr = curr.right;
            }
        }
        return result;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // iterative, different loop
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.empty()) {
            while (curr != null) { // keep push left to null, while adding val to result
                result.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return result;
    }
}


