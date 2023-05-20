/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;
        while (current != null) {
            // Assign next so that we don't lose the value after reversing
            next = current.next;
            // Reverse the link
            current.next = prev;

            // Now consider current as prev for next cycle
            prev = current;
            // Now consider next as cuurent for next cycle
            current = next;
        }
        return prev;
    }
}