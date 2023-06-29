class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // List<Integer> tail = new ArrayList<>();
        // for(int j=0;j<nums.length;j++){
        // tail.add(nums[j]);
        // }
        // helper(new ArrayList<>(),tail,ans);
        // helper2(ans,new ArrayList<>(),nums);

        boolean[] used = new boolean[nums.length];
        // need not to sort as algo do not check for duplicates
        // Arrays.sort(nums);
        helper3(ans, new ArrayList(), nums, used);
        System.out.println(ans.size());
        return ans;
    }

    private void helper(List<Integer> head, List<Integer> tail, List<List<Integer>> result) {
        if (tail.size() == 0) {
            result.add(head);
        }

        int len = tail.size();
        // iterate through tail and add it's permutations
        for (int i = 0; i < len; i++) {
            List<Integer> before = new ArrayList<>(tail.subList(0, i));
            List<Integer> after = new ArrayList<>(tail.subList(i + 1, len));
            List<Integer> newHead = new ArrayList<>(head);
            newHead.add(tail.get(i));
            List<Integer> newTail = new ArrayList<>(before);
            newTail.addAll(after);
            helper(newHead, newTail, result);
        }

    }

    private void helper2(List<List<Integer>> ans, List<Integer> tempAns, int[] nums) {
        if (tempAns.size() == nums.length) {
            ans.add(new ArrayList<>(tempAns));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!tempAns.contains(nums[i])) {
                    tempAns.add(nums[i]);
                    helper2(ans, tempAns, nums);
                    tempAns.remove(tempAns.size() - 1);
                }
            }
        }
    }

    // similar to permutations II - Leetcode 70
    private void helper3(List<List<Integer>> ans, List<Integer> tempAns, int[] nums, boolean[] used) {
        if (tempAns.size() == nums.length) {
            ans.add(new ArrayList<>(tempAns));
        } else {
            // loop will generate total Math.pow(nums.length,nums.length) permutations
            // without if condition
            for (int i = 0; i < nums.length; i++) {
                // do not reuse any value
                // if(used[i]){
                // continue;
                // }
                used[i] = true;
                tempAns.add(nums[i]);
                helper3(ans, tempAns, nums, used);
                used[i] = false;
                tempAns.remove(tempAns.size() - 1);
            }
        }
    }

}