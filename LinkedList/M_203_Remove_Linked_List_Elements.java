class Solution {

    // O(n) O(1)
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode curr = dummyHead;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummyHead.next;
    }

    // O(n) O(1)
    public ListNode removeElements2(ListNode head, int val) {
        // to handle cases at start of the head
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode curr = head;
        while (curr != null) {
            // in both cases we have to move curr fwd
            if (curr.val == val) {
                // need not to update prev
                // remove curr node > update prev.next by pointing it to curr.next
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummyHead.next;
    }

}