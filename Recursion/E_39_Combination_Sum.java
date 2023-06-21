class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), candidates, target, 0);
        // helper2(ans, candidates, target, 0, new ArrayList(), 0);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> tempAns, int[] candidates, int targetRemaining,
            int startIndex) {
        if (targetRemaining < 0) {
            return;
        }
        if (targetRemaining == 0) {
            ans.add(new ArrayList<>(tempAns));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            tempAns.add(candidates[i]);
            helper(ans, tempAns, candidates, targetRemaining - candidates[i], i);
            tempAns.remove(tempAns.size() - 1);
        }
    }

    private void helper2(List<List<Integer>> ans, int[] candidates, int target, int i, List<Integer> tempAns,
            int tempTotal) {
        if (tempTotal > target || (i >= candidates.length)) {
            return;
        }
        if (tempTotal == target) {
            ans.add(new ArrayList<>(tempAns));
            return;
        }
        tempAns.add(candidates[i]);
        helper2(ans, candidates, target, i, tempAns, tempTotal + candidates[i]);
        tempAns.remove(tempAns.size() - 1);
        helper2(ans, candidates, target, i + 1, tempAns, tempTotal);
    }

}