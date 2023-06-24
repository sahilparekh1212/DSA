class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for (String s : details) {
            if ((10 * (s.charAt(11) - '0')) + (s.charAt(12) - '0') > 60) {
                ans++;
            }
            // check why (((s.charAt(11)-'0')>=6) && ((s.charAt(12)-'0')>0)) is not working
            // if((((s.charAt(11)-'0')>=('6'-'0')) && ((s.charAt(12)-'0')>=('1'-'0')))){
            // ans++;
            // }
        }
        return ans;
    }
}