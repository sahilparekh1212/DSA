class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] counts = new int[101];
        int ans = 0;
        for (int num : nums) {
            counts[num]++;
        }
        for (int c : counts) {
            if (c > 0) {
                ans += (c * (c - 1) / 2);
            }
        }
        return ans;
    }
}