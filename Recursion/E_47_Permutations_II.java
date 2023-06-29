// https://leetcode.com/problems/permutations-ii/solutions/18594/really-easy-java-solution-much-easier-than-the-solutions-with-very-high-vote/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        // List<Integer> nums = new ArrayList<>(nums);
        // have to sort as algo depends on sorted array
        Arrays.sort(nums);
        helper(ans, new ArrayList(), nums, used);
        System.out.println(ans.size());
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> tempAns, int[] nums, boolean[] used) {
        if (tempAns.size() == nums.length) {
            ans.add(new ArrayList<>(tempAns));
        } else {
            // loop will generate total Math.pow(nums.length,nums.length) permutations
            // without if condition
            for (int i = 0; i < nums.length; i++) {
                // no duplicates allowed from right side of Input
                // do not reuse any value
                // do not use the value if it is a duplicate and prev is not used
                // use current value, which is duplicate of prev value, only if prev is used
                // long story short: 1. Do not reuse same value 2.use/doNotUse current duplicate
                // if prev is used/isNotUsed to maintain the length of permutation.
                // index in bound check for point 2
                if (used[i] || (i > 0 && !used[i - 1] && nums[i - 1] == nums[i])) {
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