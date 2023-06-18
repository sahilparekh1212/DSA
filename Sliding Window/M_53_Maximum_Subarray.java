class Solution {
    public int maxSubArray(int[] nums) {
        int i = 0;
        final int REFERENCE = 0;
        int currSum = REFERENCE;
        int max = Integer.MIN_VALUE;

        while (i < nums.length) {
            currSum += nums[i];
            max = Math.max(currSum - REFERENCE, max);
            // adding nums[i] has made result less than REFERENCE. i.e. it cannot be used to
            // count max
            // i.e. Reset window
            if (currSum < REFERENCE) {
                currSum = REFERENCE;
            }
            i++;
        }
        return max;
    }
}