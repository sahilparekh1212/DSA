class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        String currString = "";
        for (int i = 0; i < nums.length; i++) {
            int l = i;
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            if (l != i) {
                currString = nums[l] + "->" + nums[i];
            } else {
                currString = "" + nums[i];
            }
            ans.add(currString);
        }
        return ans;
    }
}