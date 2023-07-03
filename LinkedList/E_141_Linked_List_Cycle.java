
public class Solution {

    // O(n) O(n)
    public boolean hasCycle(ListNode inputNode) {
        ListNode head = inputNode;
        Set<ListNode> s = new Hasset<>();
        while (head != null) {
            if (s.contains(head)) {
                return true;
            }
            s.add(head);
            head = head.next;
        }
        return false;
    }

    // O(n) O(1)
    public boolean hasCycle2(ListNode inputNode) {
        ListNode head = inputNode;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}