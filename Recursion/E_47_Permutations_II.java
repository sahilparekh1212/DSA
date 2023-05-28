class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        // List<Integer> nums = new ArrayList<>(nums);
        Arrays.sort(nums);
        helper(ans, new ArrayList(), nums, used);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> tempAns, int[] nums, boolean[] used) {
        if (tempAns.size() == nums.length) {
            ans.add(new ArrayList<>(tempAns));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // no duplicates allowed from right side of Input
                if (used[i] || (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])) {
                    continue;
                }
                used[i] = true;
                tempAns.add(nums[i]);
                helper(ans, tempAns, nums, used);
                used[i] = false;
                tempAns.remove(tempAns.size() - 1);
            }
        }
    }
}