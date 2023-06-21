class Solution {
    public int alternateDigitSum(int n) {
        int ans = 0;
        int i = 0;
        while (n != 0) {
            ans += (i % 2 == 0 ? -1 : 1) * (n % 10);
            n = n / 10;
            i++;
        }

        return (i % 2 == 0 ? 1 : -1) * ans;
    }
}