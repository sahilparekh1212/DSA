class Solution {
    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), 1, k, target);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> tempAns, int currInt, int k, int target) {
        if (target < 0 || tempAns.size() > k) {
            return;
        } else if (target == 0 && tempAns.size() == k) {
            ans.add(new ArrayList<>(tempAns));
        } else {
            for (int i = currInt; i <= 9; i++) {
                // same as Combinations 77
                if (tempAns.size() > 0 && tempAns.get(tempAns.size() - 1) >= i) {
                    continue;
                }
                tempAns.add(i);
                helper(ans, tempAns, currInt + 1, k, target - i);
                tempAns.remove(tempAns.size() - 1);
            }
        }

    }
}