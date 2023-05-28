class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), 1, n, k);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> tempAns, int startIndex, int n, int k) {
        if (tempAns.size() == k) {
            ans.add(new ArrayList<>(tempAns));
        } else {
            for (int i = startIndex; i <= n; i++) {
                if (tempAns.size() > 0 && tempAns.get(tempAns.size() - 1) >= i) {
                    continue;
                }
                tempAns.add(i);
                helper(ans, tempAns, startIndex + 1, n, k);
                tempAns.remove(tempAns.size() - 1);
            }
        }
    }
}