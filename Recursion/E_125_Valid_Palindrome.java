class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]+", "").toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        boolean isPali = true;
        while (left <= right && isPali) {
            isPali = s.charAt(left) == s.charAt(right);
            left++;
            right--;
        }
        return isPali;
    }
}