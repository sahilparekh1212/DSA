class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder("");
        int num = columnNumber;
        String ref = "ZABCDEFGHIJKLMNOPQRSTUVWXY";
        while (num != 0) {
            if (num < 26) {
                ans.append(ref.charAt(num) + "");
                num = 0;
            } else {
                ans.append(ref.charAt(num % 26) + "");
                if (num % 26 == 0) {
                    num = (num / 26) - 1;
                } else {
                    num = (num / 26);
                }
            }
        }
        return ans.reverse() + "";
    }
}