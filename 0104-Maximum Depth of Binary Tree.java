/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


 // 100%, 94%
 // Recursive
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)  return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}

// BFS Level Order Traversal
// 11% 93%
class Solution {
    public int maxDepth(TreeNode root) {
        int max = 0;
        if (root == null) return max;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            max++; // one more level
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return max;
    }
}

// DFS 
// 11% 93%
class Solution {
    public int maxDepth(TreeNode root) {
        int max = 0;
        if (root == null) return max;
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>(); // use another stack to track and store each node's depth
        stack1.push(root);
        stack2.push(1);
        while (!stack1.isEmpty()) {
            TreeNode curr = stack1.pop();
            int currDepth = stack2.pop();
            max = Math.max(max, currDepth);
            if (curr.left != null) {
                stack1.push(curr.left);
                stack2.push(currDepth + 1);
            }
            if (curr.right != null) {
                stack1.push(curr.right);
                stack2.push(currDepth + 1);
            }
        }
        return max;
        
    }
}