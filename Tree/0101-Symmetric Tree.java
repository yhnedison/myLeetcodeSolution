// Recursive
// 100% 61%
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;
        if (left.val != right.val) return false;

        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}

// Iterative
// 44% 44%
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();
            if (n1 == null && n2 == null) continue;
            if ((n1 == null || n2 == null) || n1.val != n2.val) return false;
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }
}