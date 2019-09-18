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
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }
    private void traversal(Node node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        if (node.children != null) {
            for (Node curr: node.children) {
                traversal(curr, result);
            }
        }
    }
}

// Facorite
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) return result; // edge case
        stack.push(root);
        
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            result.add(curr.val);
            if (curr.children != null) {
                for (int i = curr.children.size() - 1; i >= 0; i--) {
                    stack.push(curr.children.get(i));
                }
            }
        }
        return result;
    }
}

class Solution {
    public List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null)
            return list;
        
        list.add(root.val);
        for(Node node: root.children)
            preorder(node);
                
        return list;
    }
}

//Iterative


