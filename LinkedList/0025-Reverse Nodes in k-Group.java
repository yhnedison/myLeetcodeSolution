// Iterative with constant memory
//O(n) O(1) 100% 24%
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        
        ListNode end = traverseK(curr, k);
        while (end != null) {
            ListNode first = curr.next;
            ListNode afterEnd = end.next;
            end.next = null;
            
            this.reverseList(first);
            
            curr.next = end;
            first.next = afterEnd;
            curr = first;
            end = traverseK(curr, k);
        }
        return dummy.next;
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    private ListNode traverseK(ListNode node, int k) {
        int count = 0;
        while (node.next != null) {
            node = node.next;
            count++;
            if (count == k) break;
        }
        
        if (count == k) return node;
        else return null;
    }
}