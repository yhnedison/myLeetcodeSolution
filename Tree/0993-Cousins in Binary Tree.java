// Recursive 100% 100%
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        return (findDepth(root, x, 1) == findDepth(root, y, 1)) && !isSibling(root, x, y);
    }
    
    // Preorder traversal
    private int findDepth(TreeNode node, int val, int height) {
        if (node == null) return 0;
        if (node.val == val) return height;
        return findDepth(node.left, val, height+1)|findDepth(node.right, val, height+1);
    }
    
    private boolean isSibling(TreeNode node, int x, int y) {
        if (node == null) return false;
        boolean current = false;
        if (node.left != null && node.right != null) {
            current = (node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x);
        }
        return current || isSibling(node.left, x, y) || isSibling(node.right, x, y);
    }
}

// BFS, level order traversal, 
// check isSibling and isSameLevel on different level
// 69% 100%
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return false;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false, foundY= false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val == x) foundX = true;
                if (node.val == y) foundY = true;
                
                // check next level for sibling, if so return false
                // so that on each level, make sure isSibling doesn't exist
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) || node.left.val == y && node.right.val == x)
                        return false;
                }
                
                // previous level checked not isSibling
                // current level check isSameLevel
                if (foundX && foundY) return true;
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
        }
        return false;
    }
}

// check isSibling and isSameLevel on same level, ignore root. Easier to understand
// 69% 100%
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return false;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false, foundY= false, isSibling = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    if (node.left.val ==  x) foundX = true;
                    if (node.left.val == y) foundY = true;
                }
                if (node.right != null) {
                    if (node.right.val ==  x) foundX = true;
                    if (node.right.val == y) foundY = true;
                }
                

                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) || node.left.val == y && node.right.val == x)
                        isSibling = true;
                }
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            // end of each level
            if (foundX && foundY && !isSibling) return true;
            
        }
        return false;
    }
}