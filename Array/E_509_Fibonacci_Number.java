class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int curr = 0;
        int ref0 = 0;
        int ref1 = 1;
        for (int i = 2; i <= n; i++) {
            int tempRef1 = ref1;
            curr = ref0 + ref1;
            ref0 = tempRef1;
            ref1 = curr;
        }
        return curr;
    }
}