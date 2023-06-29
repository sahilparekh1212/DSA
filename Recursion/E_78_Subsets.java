class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        // helper(nums,0,new ArrayList(),ans);
        helper2(ans, new ArrayList<>(), nums, 0);
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

    private void helper2(List<List<Integer>> ans, List<Integer> tempAns, int[] nums, int startIndex) {
        ans.add(new ArrayList<>(tempAns));
        for (int i = startIndex; i < nums.length; i++) {
            tempAns.add(nums[i]);
            helper2(ans, tempAns, nums, i + 1);
            tempAns.remove(tempAns.size() - 1);
        }
    }
}