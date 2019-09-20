// Draw the graph
// For normal graph, keep dividing label by 2 till 1 will get the sequence
// For zigzag graph, each divide will give you the mirror node of previous level
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> result = new LinkedList<>();
        while(label > 0) {
            result.addFirst(label);
            label = findReverseNode(label/2);
        }
        return result;
    }
    
    private int findReverseNode(int n) {
        int i = 1;
        int level = 0;
        while (i <= n) {
            i = i<<1;
            level++;
        }
        return (1<<level) - 1 + (1<<(level-1)) - n;
    }
}