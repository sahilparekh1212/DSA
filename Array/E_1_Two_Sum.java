class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> lookup = new ArrayList<Integer>();
        int[] ans = new int[2];
        for(int i=nums.length -1; i>=0; i--){
            lookup.add(nums[i]);
        }
        for(int value:nums){
            int firstIndex = lookup.indexOf(value);
            int secondIndex = lookup.indexOf(target-value);
            if(firstIndex != secondIndex )
                {
                    ans[1] = nums.length -1 - firstIndex;
                    ans[0] = nums.length -1 - secondIndex;
                    return ans; 
                }
        }
        return ans;
    }
}