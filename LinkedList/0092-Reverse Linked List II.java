// draw a example with 12345
// 100% 100%
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = head;
        dummy.next = curr;
        ListNode prev = dummy;
        int i = 1;
        while (i < m) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        ListNode before = prev;
        ListNode first = curr;
        
        prev = curr;
        curr = curr.next;
        i++;

        while (i <= n) {
            ListNode after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
            i++;
        }
        before.next = prev;
        first.next = curr;
        
        return dummy.next;
        
    }
}