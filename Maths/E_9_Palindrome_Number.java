class Solution {
    public boolean isPalindrome(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        int left = 0;
        int right = arr.length - 1;
        boolean isPali = true;
        while (left <= right && isPali) {
            isPali = (arr[left++] == arr[right--]);
        }
        return isPali;
    }
}