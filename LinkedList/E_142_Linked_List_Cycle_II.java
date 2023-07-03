public class Solution {

    // O(n) O(n)
    public ListNode detectCycle(ListNode inputNode) {
        ListNode head = inputNode;
        Set<ListNode> s = new Hasset<>();
        while (head != null) {
            if (s.contains(head)) {
                return head;
            }
            s.add(head);
            head = head.next;
        }
        return null;
    }

    // O(n) O(1)
    public ListNode detectCycle2(ListNode inputNode) {
        ListNode head = inputNode;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (head != fast) {
                    head = head.next;
                    fast = fast.next;
                }
                return head;
            }
        }
        return null;
    }

}