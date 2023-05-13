class Solution {
    public int reverse(int input) {
        try{
        String ansString = new String(
        int div = x;
        while(x != 0){
            ansString += String.valueOf(x%10);
            x = x/10;
        }
        return (input < 0 ? -1 : 1) * Integer.valueOf(ansString);
        } catch(Exception e) {
            return 0;
        }
    }
}z