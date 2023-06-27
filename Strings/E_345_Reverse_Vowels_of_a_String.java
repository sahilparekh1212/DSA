class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length - 1;
        String vowels = "aeiouAEIOU";
        while (l < r) {
            while (l < arr.length && !vowels.contains(arr[l] + "")) {
                l++;
            }
            while (r > 0 && !vowels.contains(arr[r] + "")) {
                r--;
            }
            if (l < r) {
                char c = arr[l];
                arr[l] = arr[r];
                arr[r] = c;
            }
            l++;
            r--;
        }
        return String.valueOf(arr);
    }
}