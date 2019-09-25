// Recursive
// O(n) O(n) 100% 10%
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode first = head;
        ListNode second = head.next;
        first.next = swapPairs(second.next);
        second.next = first;
        return second;
    }
}

// Iterative with constant extra memory
// O(n) O(1) 100% 100%
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        // swap every two nodes
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            ListNode afterSecond = second.next;
            
            curr.next = second;
            first.next = afterSecond;
            second.next = first;
            
            curr = first;
        }
        
        return dummy.next;
    }
}