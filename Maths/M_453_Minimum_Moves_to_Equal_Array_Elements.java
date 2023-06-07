// https://leetcode.com/problems/minimum-moves-to-equal-array-elements/solutions/2217846/java-maths-explained/
class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            sum += nums[i];
        }
        return (sum - (min * nums.length));
    }
}