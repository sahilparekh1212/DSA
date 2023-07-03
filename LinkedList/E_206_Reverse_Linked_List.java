class Solution {
    // O(n) O(n)
    public ListNode reverseList(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode dummyHead = head;
        while (dummyHead != null) {
            st.add(dummyHead.val);
            dummyHead = dummyHead.next;
        }
        ListNode current = head;
        while (!st.isEmpty()) {
            current.val = st.pop();
            current = current.next;
        }
        return head;
    }

    // O(n) O(1)
    public ListNode reverseList2(ListNode head) {
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