// todo: Solve using graph
class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == trust.length || n > trust.length + 1) {
            return -1;
        }
        if (n == 1 && trust.length == 0) {
            return 1;
        }
        int[] trustedBy = new int[n];
        int[] trusting = new int[n];
        int i = 0;
        while (i < trust.length) {
            trusting[trust[i][0] - 1]++;
            trustedBy[trust[i][1] - 1]++;
            i++;
        }
        for (int j = 0; j < n; j++) {
            if (trustedBy[j] == n - 1 && trusting[j] == 0) {
                return j + 1;
            }
        }
        return -1;
    }
}