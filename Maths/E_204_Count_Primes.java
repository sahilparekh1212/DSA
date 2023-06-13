class Solution {
    public int countPrimes(int n) {
        boolean[] primesArr = new boolean[n + 1];

        Arrays.fill(primesArr, true);
        int i = 2;
        while (i * i <= n) {
            int ref = i + i;
            while (ref <= n) {
                if (primesArr[ref]) {
                    primesArr[ref] = false;
                }
                ref += i;
            }
            i++;
        }
        int ans = 0;
        for (int j = 2; j < n; j++) {
            if (primesArr[j] == true) {
                ans++;
            }
        }
        return ans;
    }
}