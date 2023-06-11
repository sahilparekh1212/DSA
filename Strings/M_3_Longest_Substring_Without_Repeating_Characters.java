class Solution {
    public int lengthOfLongestSubstring(String s) {
        // int[128] for 128 ASCII char
        int[] lastIndexArr = new int[128];
        Arrays.fill(lastIndexArr,-1);

        int currMax = 0;
        int maxSofar = 0;
        int currCharASCII = 0;
        int i=0;
        while(i<s.length()){
            currCharASCII = (int)s.charAt(i);
            if(lastIndexArr[currCharASCII]==-1){
                lastIndexArr[currCharASCII] = i;
            }else{
                // duplicate found
                if(lastIndexArr[currCharASCII]>=i-currMax){
                    maxSofar = Math.max(currMax,maxSofar);
                    // adjusting currMax
                    currMax = i-lastIndexArr[currCharASCII]-1;
                }
            }
            lastIndexArr[currCharASCII] = i;
            currMax++;
            i++;
        }
        return Math.max(currMax,maxSofar);
    }
}