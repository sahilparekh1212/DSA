class Solution {
    public int getSum(int a, int b) {
        int temp = 0;
        while(b!=0){
            temp = (a & b)<<1;
            a = a^b;
            b=temp;
        }
        return a;
    }
}