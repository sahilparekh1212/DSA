class Solution {

    // O(n) O(1)
    public int getDecimalValue(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum = sum * 2 + head.val;
            head = head.next;
        }
        return sum;
    }

    // O(n) O(1)
    public int getDecimalValue2(ListNode head) {
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