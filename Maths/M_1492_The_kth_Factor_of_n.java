class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>();
        int i = 1;
        while (i <= n / 2) {
            if (n % i == 0) {
                factors.add(i);
            }
            i++;
        }
        if (n >= 1) {
            factors.add(n);
        }
        if (factors.size() < k) {
            return -1;
        }
        return factors.get(k - 1);
    }
}