// DFS using stack
// modified Preorder traversal: Root -> Right -> Left
// Tracking maxDepth while traversing, add to list when currentDepth > maxDepth
// Refer to 104 Maximum Depth of Binary Tree
// O(n) O(n) 12% 100%
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        stack2.push(1);
        int max = 0;
        while (!stack1.isEmpty()) {
            TreeNode curr = stack1.pop();
            int currDepth = stack2.pop();
            
            if (currDepth > max) {
                max = currDepth;
                result.add(curr.val);
            }
            if (curr.left != null) {
                stack1.push(curr.left);
                stack2.push(currDepth + 1);
            }if (curr.right != null) {
                stack1.push(curr.right);
                stack2.push(currDepth + 1);
            }
        }
        return result;
    }
}

// BFS using queue
// level order traversal from right to left, add first element
// 100% 100%
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i == 0) result.add(node.val); // Right-most element of each level
                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
            }
            
        }
        return result;
    }
}

// DFS recursive, Root -> Right -> Left
// 100% 100%
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root ==  null) return result;
        
        visit(root, 1, result);
        return result;
    }
    
    private void visit(TreeNode node, int level, List<Integer> result) {
        if (node == null) return;
        if (level > result.size()) result.add(node.val);
        
        visit(node.right, level + 1, result);
        visit(node.left, level + 1, result);
    }
}