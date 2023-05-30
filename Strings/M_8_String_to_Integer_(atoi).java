class Solution {
    public int myAtoi(String s) {
        char[] charArr = s.toCharArray();
        int i = charArr.length - 1;
        long ans = 0;
        int charVal = 0;
        int power = 0;
        while (i >= 0) {
            charVal = charArr[i] - '0';
            if (charVal > -1 && charVal < 10) {
                ans += charVal * Math.pow(10, power++);
            }

            if (charArr.length > 0 && charArr[i] == ' ' && charArr[i + 1] != ('+') && ans > 0) {
                ans = 0;
                break;
            }

            if (charArr[i] == '-') {
                ans *= -1;
                if (i > 0 && charArr[i - 1] != ' ') {
                    ans = 0;
                }
                break;
            }

            i--;
        }
        return (int) ans;
    }
}