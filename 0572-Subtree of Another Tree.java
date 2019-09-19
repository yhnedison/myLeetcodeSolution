// Refer to 100-Same Tree 
// check sameTree of t against every node in s
// 92% 97%
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return false;
        else if (s != null && t == null) return true;
        else if (s == null && t != null) return false;
        
        // preorder traversal
        return sameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
     }
    
    private boolean sameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null || q == null) || p.val != q.val) return false;
        return sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }
}


// Iterative preorder traversal
// 9% 8%
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return false;
        else if (s != null && t == null) return true;
        else if (s == null && t != null) return false;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (sameTree(node, t)) return true;
            if (node != null) {
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return false;
     }
    
    private boolean sameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null || q == null) || p.val != q.val) return false;
        return sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }
}