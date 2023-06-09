class Solution {
    public int maximumProduct(int[] nums) {
        int numsLength = nums.length;
        if (numsLength < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int ansR = 1;
        for (int i = numsLength - 1; i > numsLength - 4; i--) {
            ansR *= nums[i];
        }
        // ansLR product of num at index 0*1*(len-1) if index1 is negative
        int ansLR = 0;
        if (nums[1] < 0) {
            ansLR = nums[0] * nums[1] * nums[numsLength - 1];
        }
        // return max of ansR ansLR
        return Math.max(ansLR, ansR);
    }
}