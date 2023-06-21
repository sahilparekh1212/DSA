class Solution {
    public int myAtoi(String s) {
        int sLength = s.length();
        int i=0;
        int zero = (int) '0' - '0';
        int nine = (int) '9' - '0';
        int currNum = -1;
        // currently a double to avoid overflow
        double ans=0;
        boolean isNegative = false;

        // skip leading spaces
        while(i<sLength && s.charAt(i)==' '){
            i++;
        }
        
        // identify number sign
        if(i<sLength){
            if(s.charAt(i)=='-' || s.charAt(i)=='+'){
                isNegative = (s.charAt(i)=='-');
                i++;
            }
        }
        
        if(i<sLength){
            currNum = (int) s.charAt(i) - '0';
        }

        // loop until non-num is found in the string
        while(i<sLength && currNum>=zero && currNum<=nine){
            ans= ((ans*10) + (s.charAt(i)-'0'));
            i++;
            if(i<sLength){
                currNum = (int) s.charAt(i) - '0';
            }
        }
        
        if(isNegative){
            ans*=-1;
        }
    
        return (int)ans;

    }
}