class Solution {
    public int numberOfMatches(int n) {
        int matchesSoFar = 0;
        while(n>1){
            if(n%2==0){
                matchesSoFar += n/2;
                n = n/2;
            }else{
                matchesSoFar += (n-1)/2;
                n = (n-1)/2 +1;
            }
        }
        return matchesSoFar;
    }
}