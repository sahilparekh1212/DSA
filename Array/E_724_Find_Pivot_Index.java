class Solution {
    public int pivotIndex(int[] nums) {
        int numsLength = nums.length;
        if (numsLength == 0) {
            return -1;
        }
        ;
        if (numsLength == 1) {
            return 0;
        }
        ;
        int rightSum = 0;
        for (int val : nums) {
            rightSum += val;
        }
        int leftSum = 0;
        int pivotIndex = -1;
        int i = 0;
        while (i < nums.length && pivotIndex == -1) {
            rightSum -= nums[i];
            if (i > 0) {
                leftSum += nums[i - 1];
            }
            if (leftSum == rightSum) {
                pivotIndex = i;
            }
            ;
            i++;
        }
        return pivotIndex;
    }
}