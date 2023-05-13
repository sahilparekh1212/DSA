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
    public int getDecimalValue(ListNode head) {
        String binaryRef = new String();
        int intAns = 0;
        while (head != null) {
            binaryRef += String.valueOf(head.val);
            head = head.next;
        }
        int i = 0;
        int binaryRefLength = binaryRef.length();
        while (i < binaryRefLength) {
            if (binaryRef.charAt(i) == '1') {
                intAns += Math.pow(2, binaryRefLength - 1 - i);
            }
            i++;
        }
        return intAns;
    }
}