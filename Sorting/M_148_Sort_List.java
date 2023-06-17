class Solution {

    public ListNode sortList(ListNode mainHead) {
        return mergeSortList(mainHead);
    }

    private ListNode mergeSortList(ListNode mainHead) {

        if (mainHead == null || mainHead.next == null) {
            return mainHead;
        }
        // divide in 2
        ListNode slowHead = mainHead, fast = mainHead, slowPrev = null;

        // find middle of linked list by slow pointer
        while (fast != null && fast.next != null) {
            slowPrev = slowHead;
            slowHead = slowHead.next;
            fast = fast.next.next;
        }

        // to avoid StackOverflowError by ending mainHead just before slowHead
        slowPrev.next = null;

        // left half
        mainHead = mergeSortList(mainHead);

        // right half
        slowHead = mergeSortList(slowHead);

        return mergeTwoSortedList(mainHead, slowHead);
    }

    private ListNode mergeTwoSortedList(ListNode left, ListNode right) {
        // dummyHead is the entire LinkedList
        // curr is the last node of the list
        ListNode dummyHead = new ListNode(0), curr = dummyHead;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        if (left != null) {
            curr.next = left;
            // Can loop but need not to loop as it is a linked list
            // left = left.next;
            // prev = prev.next;
        }

        if (right != null) {
            curr.next = right;
            // Can loop but need not to loop as it is a linked list
            // right = right.next;
            // prev = prev.next;
        }

        return dummyHead.next;
    }

}