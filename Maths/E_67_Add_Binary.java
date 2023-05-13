class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        String ans = new String();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i < 0) {
                sum += b.charAt(j) - '0';
            } else if (j < 0) {
                sum += a.charAt(i) - '0';
            } else {
                sum += a.charAt(i) - '0' + b.charAt(j) - '0';
            }
            carry = sum / 2;
            sum = sum % 2;
            i--;
            j--;
            ans += String.valueOf(sum);
        }
        if (carry == 1) {
            ans += String.valueOf(carry);
        }
        String revAns = new String();
        for (int k = ans.length() - 1; k >= 0; k--) {
            revAns += ans.charAt(k);
        }
        return revAns;
    }
}