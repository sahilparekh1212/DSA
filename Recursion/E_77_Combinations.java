class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        helper1(ans, new ArrayList<>(), 1, n, k);
        // helper2(ans,new ArrayList<>(),n,n,k);

        return ans;
    }

    private void helper1(List<List<Integer>> ans, List<Integer> tempAns, int startIndex, int n, int k) {
        if (tempAns.size() == k) {
            ans.add(new ArrayList<>(tempAns));
        } else {
            for (int i = startIndex; i <= n; i++) {
                // Not accepting value<i to keep combinations in range in a direction
                if (tempAns.size() > 0 && tempAns.get(tempAns.size() - 1) >= i) {
                    continue;
                }
                tempAns.add(i);
                helper1(ans, tempAns, startIndex + 1, n, k);
                tempAns.remove(tempAns.size() - 1);
            }
        }
    }

    private void helper2(List<List<Integer>> ans, List<Integer> tempAns, int startIndex, int n, int k) {
        if (tempAns.size() == k) {
            ans.add(new ArrayList<>(tempAns));
        } else {
            for (int i = startIndex; i > 0; i--) {
                // Not accepting value<1 to keep combinations in range in a direction
                if (tempAns.size() > 0 && tempAns.get(tempAns.size() - 1) <= i) {
                    continue;
                }
                tempAns.add(i);
                helper2(ans, tempAns, startIndex - 1, n, k);
                tempAns.remove(tempAns.size() - 1);
            }
        }
    }
}