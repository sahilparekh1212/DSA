class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        // helper(nums,0,new ArrayList(),ans);
        helper2(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void helper(int[] nums, int startIndex, List<Integer> tempAnsList, List<List<Integer>> ans) {
        if (startIndex >= nums.length) {
            ans.add(new ArrayList(tempAnsList));
            return;
        }

        // Here if we were not allowed to have any duplicate fo any number in
        // tempAnsList, we would have removed duplicates from the subsetsWithDup()

        // Inlude the nums[startIndex] in the tempAnsList
        tempAnsList.add(nums[startIndex]);
        // As we cannot include duplicates of the self, we are using index startIndex+1
        helper(nums, startIndex + 1, tempAnsList, ans);

        // skipping through duplicates from right as ans must not have duplicates of
        // nums[startIndex]
        while (startIndex < nums.length - 1 && nums[startIndex] == nums[startIndex + 1]) {
            startIndex += 1;
        }

        // do not the nums[startIndex] in the ans
        tempAnsList.remove(tempAnsList.size() - 1);
        helper(nums, startIndex + 1, tempAnsList, ans);
    }

    private void helper2(List<List<Integer>> ans, List<Integer> tempAns, int[] nums, int startIndex) {
        ans.add(new ArrayList<>(tempAns));
        for (int i = startIndex; i < nums.length; i++) {
            // no duplicates from rhs
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            tempAns.add(nums[i]);
            helper2(ans, tempAns, nums, i + 1);
            tempAns.remove(tempAns.size() - 1);
        }
    }

}