// Postorder traversal Calculate sum while maintaining result
// Refer 543 Diameter of Binary Tree
class Solution {
    private int result = 0;
    public int findTilt(TreeNode root) {
        postorderSum(root);
        return result;
    }
    
    // calculate sum of tree, while maintaining sum
    private  int postorderSum(TreeNode node) {
        if (node == null) return 0;
        int left = postorderSum(node.left);
        int right = postorderSum(node.right);
        
        result += Math.abs(left- right);// maintain result
        
        return left + right + node.val;
    }
}