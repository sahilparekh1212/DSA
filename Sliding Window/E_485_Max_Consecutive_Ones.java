class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecCount = 0;
        int currCount = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                currCount = 0;
            } else {
                currCount++;
            }
            if (currCount > maxConsecCount) {
                maxConsecCount = currCount;
            }
            i++;
        }
        return maxConsecCount;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int maxConsecCount = 0;
        int currCount = 0;
        int i = 0;
        while (i < nums.length) {

            currCount = 0;
            while (i < nums.length && nums[i] == 0) {
                i++;
            }
            while (i < nums.length && nums[i] == 1) {
                i++;
                currCount++;
            }
            if (currCount > maxConsecCount) {
                maxConsecCount = currCount;
            }
        }
        return maxConsecCount;
    }
}