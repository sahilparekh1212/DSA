class Solution {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        int n = grid[0].length;
        int i = n - 1;
        for (int[] row : grid) {
            while (i > -1 && row[i] < 0) {
                i--;
            }
            ans += (n - (i + 1));
        }
        return ans;
    }
}