class Solution {
    public int removeDuplicates(int[] nums) {
        int pointer = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[pointer - 1]) {
                nums[pointer] = nums[i];
                pointer++;
            }
        }
        return pointer;
    }
}