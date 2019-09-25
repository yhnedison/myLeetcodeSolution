// Min Heap using priority queue
// O(Nlogk) O(k) 75% 26%
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2) {
                if (n1.val < n2.val) return -1;
                else if (n1.val > n2.val) return 1;
                else return 0;
            }
        });
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        
        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            if (curr.next != null) queue.offer(curr.next);
        }
        return dummy.next;
    }
}