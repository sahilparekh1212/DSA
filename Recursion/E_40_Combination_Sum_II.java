class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        helper(ans, new ArrayList<>(), nums, 0, target, 0, used);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> tempAns, int[] nums, int startIndex, int target,
            int currSum, boolean[] used) {
        if (currSum > target) {
            return;
        }
        if (currSum == target) {
            ans.add(new ArrayList<>(tempAns));
        } else {
            for (int i = startIndex; i < nums.length; i++) {
                // 1. No reuse
                // 2. No duplicates
                // 3. Follow a direction
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                        || (tempAns.size() > 0 && tempAns.get(tempAns.size() - 1) > nums[i])) {
                    continue;
                }
                used[i] = true;
                tempAns.add(nums[i]);
                helper(ans, tempAns, nums, startIndex + 1, target, currSum + nums[i], used);
                used[i] = false;
                tempAns.remove(tempAns.size() - 1);
            }
        }
    }
}