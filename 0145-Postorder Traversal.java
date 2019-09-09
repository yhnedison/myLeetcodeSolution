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
        TreeNode node=root;
        while(node!=null || !stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                if(node.left!=null){
                    node=node.left;
                }
                else{
                    node=node.right;
                }
            }
            else{
                node=stack.pop();
                result.add(node.val);
                if(!stack.isEmpty() && stack.peek().left==node){
                    node=stack.peek().right;
                }
                else{
                    node=null;
                }
            }
        }
        return result;
    }
}

