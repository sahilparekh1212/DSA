class Solution {
    public boolean validPalindrome(String s) {
        int sLength = s.length();
        if (sLength == 0 || sLength == 1) {
            return true;
        }
        int left = 0;
        int right = sLength - 1;
        int mismatch = 0;
        boolean isPali = true;
        while (left <= right && isPali) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPaliWithPara(s, left + 1, right) || isPaliWithPara(s, left, right - 1);
            }
            left++;
            right--;
        }
        return isPali;
    }

    public boolean isPaliWithPara(String s, int left, int right) {
        int sLength = s.length();
        if (sLength == 0 || sLength == 1) {
            return true;
        }
        boolean isPali = true;
        while (left <= right && isPali) {
            isPali = s.charAt(left) == s.charAt(right);
            left++;
            right--;
        }
        return isPali;
    }
}