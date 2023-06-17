class Solution {
    public int minSubArrayLen2(int target, int[] nums) {
        int currSum = 0;
        int left = 0;
        int minWindow = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            // move left pointer to right side
            while (currSum >= target - nums[right]) {
                minWindow = Math.min(minWindow, right - left + 1);
                currSum -= nums[left];
                left++;
            }
            currSum += nums[right];
        }
        return ((minWindow != Integer.MAX_VALUE) ? minWindow : 0);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int currSum = 0;
        int left = 0;
        int minWindow = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            currSum += nums[right];
            // move left pointer to right side
            while (currSum >= target) {
                minWindow = Math.min(minWindow, right - left + 1);
                currSum -= nums[left];
                left++;
            }
        }
        return ((minWindow != Integer.MAX_VALUE) ? minWindow : 0);
    }
}