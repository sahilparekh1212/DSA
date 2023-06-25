class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for(String s:details ){
            // way1
            // if((10*(s.charAt(11)-'0')) + (s.charAt(12)-'0') > 60){
            //     ans++;
            // }

            // way2
            if((s.charAt(11)-'0')>=6){
                if((s.charAt(11)-'0')==6 && ((s.charAt(12)-'0')==0)){
                    continue;
                }
                ans++;
            }
        }
        return ans;
    }
}