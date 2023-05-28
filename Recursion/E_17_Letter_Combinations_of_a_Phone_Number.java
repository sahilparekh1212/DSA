class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0 || digits.length()>4 ){
            return new ArrayList<>();
        }
        String[] lookup = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans = new ArrayList<>();
        helper(ans, new String(),digits,lookup,0);
        return ans;
    }

    private void helper(List<String> ans, String tempAns, String digits, String[] lookup,int startIndex){
        if(tempAns.length()==digits.length()){
            ans.add(tempAns);
        }else{
            char[] charArr  = lookup[digits.charAt(startIndex) - '0'].toCharArray();
            for(char c:charArr){
                // shorthand backtracking
                helper(ans,tempAns + (c+""),digits,lookup,startIndex+1);
            }
        }
    }

}