class Solution {
    public void moveZeroes(int[] nums) {
        int totalNZ = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[totalNZ] = nums[i];
                totalNZ++;
            }
        }

        for (int i = totalNZ; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}