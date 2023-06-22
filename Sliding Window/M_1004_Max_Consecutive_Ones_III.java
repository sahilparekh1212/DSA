class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        int currZerosInWindow = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                currZerosInWindow++;
            }
            right++;
            // shift left pointer
            while (left < right && currZerosInWindow > k) {
                if (nums[left] == 0) {
                    currZerosInWindow--;
                }
                left++;
            }
            if (right - left > max) {
                max = right - left;
            }
        }
        return max;
    }
}