/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

// two stack method, EASY TO UNDERSTAND
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new LinkedList<>();
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        if (root == null) return result;
        
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node curr = stack1.pop();
            stack2.push(curr);
            for (Node child: curr.children) {
                stack1.push(child);
            }
        }
        
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }
        return result;
    }
}