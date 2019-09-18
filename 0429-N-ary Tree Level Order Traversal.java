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
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                Node curr = queue.poll();
                tempList.add(curr.val);
                if (curr.children != null) {
                    for (Node child: curr.children) {
                        queue.offer(child);
                    }
                }
            }
            result.add(tempList);
        }
        return result;
    }
}