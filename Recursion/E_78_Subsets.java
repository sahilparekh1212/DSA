class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        helper(nums, 0, new ArrayList(), ans);
        return ans;
    }

    private void helper(int[] nums, int startIndex, List<Integer> tempAns, List<List<Integer>> ans) {
        if (startIndex >= nums.length) {
            ans.add(new ArrayList(tempAns));
            return;
        }

        // choice 1 > Include element at startIndex
        tempAns.add(nums[startIndex]);
        helper(nums, startIndex + 1, tempAns, ans);

        // choice 2 > Do not include element at startIndex
        tempAns.remove(tempAns.size() - 1);
        helper(nums, startIndex + 1, tempAns, ans);

    }
}