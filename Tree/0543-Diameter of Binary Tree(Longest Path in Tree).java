// Although the longest path doesn't have to go through the root node, it has to pass the root node of some subtree of the tree 
// So we traverse the tree, calculateing longest path passing this node(while is maxDepthLeft + maxDepthRight), and maintain the max
// Postorder traversal Calculate maxDepth while maintaining result
// Refer to 563 Binmary Tree Tilt
class Solution {
    private int result = 0; // maintain a global variable
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return result;
    }
    
    // the same as 104 maxDepth, while maintaining max
    private int maxDepth(TreeNode node) {
        if (node == null) return 0;
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        
        result = Math.max(result, left + right); // this maintains the max
        return Math.max(left, right) + 1;
    }
}

// Without GLOBAL Variable
// http://www.javacoffeebreak.com/faq/faq0066.html
// https://www.techiedelight.com/pass-integer-reference-java/
// 98% 59%
class Solution {
    public int findTilt(TreeNode root) {
        int[] result = new int[1];
        postorderSum(root, result);
        return result[0];
    }
    
    // calculate sum of tree, while maintaining sum
    private  int postorderSum(TreeNode node, int[] result) {
        if (node == null) return 0;
        int left = postorderSum(node.left, result);
        int right = postorderSum(node.right, result);
        
        result[0] += Math.abs(left- right);// maintain result
        
        return left + right + node.val;
    }
}