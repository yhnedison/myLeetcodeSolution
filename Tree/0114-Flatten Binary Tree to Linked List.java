class Solution {
    public void flatten(TreeNode root) {
        flatten(root,null);
    }
    private TreeNode flatten(TreeNode root, TreeNode pre) {
        if(root==null) return pre;
        pre=flatten(root.right,pre);    
        pre=flatten(root.left,pre);
        root.right=pre;
        root.left=null;
        pre=root;
        return pre;
    }
}


// straight
// O(n^2) NOT GOOD ENOUGH
// Right -> Left -> Root
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left, right = root.right;
        root.left = null;
        flatten(left);
        flatten(right);
        root.right = left;
        
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        
        curr.right = right;   
    }
}