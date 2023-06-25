class Solution {
    public int tribonacci(int n) {
        int[] prev3 = new int[] { 0, 1, 1 };
        if (n < 3) {
            return prev3[n];
        }
        int temp = 2;
        for (int i = 3; i <= n; i++) {
            temp = prev3[0] + prev3[1] + prev3[2];
            prev3[0] = prev3[1];
            prev3[1] = prev3[2];
            prev3[2] = temp;
        }
        return prev3[2];
    }
}