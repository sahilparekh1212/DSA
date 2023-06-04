public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            // Why does n%2 not work
            ans += n & 1;
            // why does n>>1 is giving 'Time Limit Exceeds' error?
            n = n >>> 1;
        }
        return ans;
    }
}