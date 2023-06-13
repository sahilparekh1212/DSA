class Solution {
    public int commonFactors(int a, int b) {
        int ans = 0;
        int i = 1;
        int min = Math.min(a, b);
        while (i <= min) {
            if (a % i == 0 && b % i == 0) {
                ans++;
            }
            i++;
        }
        return ans;
    }
}