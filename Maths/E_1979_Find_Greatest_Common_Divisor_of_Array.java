class Solution {
    public int findGCD(int[] nums) {
        int max = -1;
        int min = 1001;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        int tempMin = 0;
        while (min != 0) {
            tempMin = min;
            min = max % min;
            max = tempMin;
        }
        return max;
    }

    private int gcd(int max, int min) {
        if (min == 0) {
            return max;
        }
        return gcd(min, max % min);
    }
}