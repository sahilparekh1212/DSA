class Solution {

    // O(logn) O(1)
    public int trailingZeroes(int n) {
        // base case
        if (n == 0) {
            return 0;
        }
        // recursive descent
        return (n / 5 + trailingZeroes(n / 5));
    }
}