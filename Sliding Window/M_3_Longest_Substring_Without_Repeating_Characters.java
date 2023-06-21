class Solution {
    public int lengthOfLongestSubstring(String s) {
        return maxSlidingWindow(s);
        // return maxSlidingWindow2(s);
    }

    private int maxSlidingWindow(String s) {
        int leftMin = 0;
        // int[128] for 128 printable ASCII char
        int[] lastIndexArr = new int[128];
        Arrays.fill(lastIndexArr, -1);
        int currCharASCII = Integer.MIN_VALUE;
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            currCharASCII = (int) s.charAt(i);
            if (lastIndexArr[currCharASCII] > -1) {
                max = Math.max(i - leftMin, max);
                leftMin = Math.max(lastIndexArr[currCharASCII] + 1, leftMin);
            }
            lastIndexArr[currCharASCII] = i;
        }
        return Math.max(max, s.length() - leftMin);
    }

    private int maxSlidingWindow2(String s) {
        // int[128] for 128 printable ASCII char
        int[] lastIndexArr = new int[128];
        Arrays.fill(lastIndexArr, -1);

        int currMax = 0;
        int maxSofar = 0;
        int currCharASCII = 0;
        int i = 0;
        while (i < s.length()) {
            currCharASCII = (int) s.charAt(i);
            // duplicate found
            if (lastIndexArr[currCharASCII] >= i - currMax) {
                maxSofar = Math.max(currMax, maxSofar);
                // adjusting currMax
                currMax = i - lastIndexArr[currCharASCII] - 1;
            }
            lastIndexArr[currCharASCII] = i;
            currMax++;
            i++;
        }
        return Math.max(currMax, maxSofar);
    }
}