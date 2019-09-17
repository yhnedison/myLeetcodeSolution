/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>()
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        while(curr!=null || !stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                if(curr.left!=null){
                    curr=curr.left;
                }
                else{
                    curr=curr.right;
                }
            }
            else{
                curr=stack.pop();
                result.add(curr.val);
                if(!stack.isEmpty() && stack.peek().left==curr){
                    curr=stack.peek().right;
                }
                else{
                    curr=null;
                }
            }
        }
        return result;
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while ( curr != null || !stack.isEmpty()) {
            // find leaf nodes
            while (curr != null) {
                stack.push(curr);
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }
            TreeNode curr = stack.pop();
            result.add(curr.val);
            if (!stack.isEmpty() && stack.peek().left == curr) {
                curr = stack.peek().right;
            }
        }
        return result;
    }
    
}

