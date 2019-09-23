// Recursive
// O(n^2) O(n) 99% 97%
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;
        return build(nums, 0, nums.length - 1);
    }
    
    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) return null; // End Case
        
        int maxIndex = findMaxIndex(nums, start, end);
        TreeNode node = new TreeNode(nums[maxIndex]);
        
        node.left = build(nums, start, maxIndex -1);
        node.right = build(nums, maxIndex + 1, end);
        return node;
    }
    
    private int findMaxIndex(int[] nums, int start, int end) {
        int max = start;
        for (int i = start+ 1; i <= end; i++) {
            if (nums[i] > nums[max]) max = i;
        }
        return max;
    }
}

// O(n) solution 12% 78%
// Heap is slower than stack
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while(!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            if(!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            stack.push(curr);
        }
        
        return stack.isEmpty() ? null : stack.removeLast();
    }
}