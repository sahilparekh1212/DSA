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