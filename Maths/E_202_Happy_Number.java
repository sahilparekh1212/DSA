// https://leetcode.com/problems/happy-number/solutions/519280/java-100-using-cycle-finding-algorithm/
// https://leetcode.com/problems/happy-number/solutions/3278532/easier-than-you-think-explained/

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        int num = n;
        while (num != 1 && !s.contains(num)) {
            s.add(num);
            int newNum = 0;
            while (num != 0) {
                // ((num%10)*(num%10)) != (num%10*num%10)
                newNum += ((num % 10) * (num % 10));
                num /= 10;
            }
            num = newNum;
        }
        return num == 1;
    }
}