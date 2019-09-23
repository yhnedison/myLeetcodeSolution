/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Refer to leetcode solution 1
// 100% 92%%
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode mid = findMiddleNode(head);
        
        TreeNode node = new TreeNode(mid.val);
        if (head == mid) return node; // base case, only 1 
        
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }
    
    private ListNode findMiddleNode(ListNode head) {
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) { // left part not empty, cut left part off
            prev.next = null;
        }
        return slow;
    }
}