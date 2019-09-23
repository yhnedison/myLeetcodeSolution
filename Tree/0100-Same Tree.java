// use two stack to traverse simultaneously
// O(n) O(n) 5% 100%
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(p);
        stack2.push(q);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            if (node1 != null && node2 != null) {
                if (node1.val != node2.val) return false;
                stack1.push(node1.left);
                stack1.push(node1.right);
                stack2.push(node2.left);
                stack2.push(node2.right);
            } else if (node1 == null && node2 == null) {
                continue;
            } else { // one of the two is null
                return false;
            }
        }
        return stack1.size() == stack2.size();   
    }
}

// recursive
// O(n) O(1) 100% 100%
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true; // End case, both null, also handle case with two empty tree
        if (p == null || q == null) return false; // End case, Unequal nullity
        if (p.val != q.val) return false; // Both not null, but unequal value
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}