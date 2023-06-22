class Solution {
    public int longestSubstring(String s, int k) {
        int sLength = s.length();
        if (sLength == 0 || sLength < k) {
            return 0;
        }

        if (k < 2) {
            return sLength;
        }

        int maxCount = 0;
        int i = 0;
        int[] count = new int[26];

        while (i < sLength) {
            count[s.charAt(i) - 'a']++;
            i++;
        }
        ;

        i = 0;
        int leftMax = 0;
        int rightMax = 0;

        while (i < sLength && count[s.charAt(i) - 'a'] >= k) {
            i++;
        }

        // check string end reached
        if (i >= sLength - 1) {
            return i;
        }

        leftMax = longestSubstring(s.substring(0, i), k);

        while (i < sLength && count[s.charAt(i) - 'a'] < k) {
            i++;
        }

        // check index in bound
        rightMax = ((i < sLength) ? longestSubstring(s.substring(i), k) : 0);

        return Math.max(leftMax, rightMax);
    }
}