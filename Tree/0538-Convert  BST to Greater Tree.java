/// Reverse of Inorder Traversal Recursive 99% 37%
class Solution {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }
}

// Reverse of Inorder Traversal 14% 37%
class Solution {
    public TreeNode convertBST(TreeNode root) {
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop();
            sum += curr.val;
            curr.val = sum;
            curr = curr.left;
        }
        return root;
    }
}

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