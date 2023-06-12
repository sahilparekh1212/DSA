class Solution {
    public boolean isUgly(int n) {
        int[] primeArr= {2,3,5};
        for(int i=0; i<primeArr.length && n!=0; i++){
            while(n%primeArr[i]==0){
                n/=primeArr[i];
            }   
        }
        return n==1;
    }
}