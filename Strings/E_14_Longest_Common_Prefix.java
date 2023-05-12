class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return new String("");
        }
        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder sb = new StringBuilder();
        int maxCommonLength = Integer.MAX_VALUE;

        for (String s : strs) {
            if (s.length() < maxCommonLength) {
                maxCommonLength = s.length();
            }
        }

        int i = 0;
        boolean foundDiffChar = false;

        while (i < maxCommonLength && !foundDiffChar) {

            char currentChar = strs[0].charAt(i);
            int indexOfWordInArray = 1;

            while (indexOfWordInArray < strs.length && !foundDiffChar) {
                foundDiffChar = (currentChar != strs[indexOfWordInArray++].charAt(i));
            }

            if (!foundDiffChar) {
                sb.append(currentChar);
            }
            i++;

        }
        return sb.toString();
    }
}