class Solution {
    public int strStr(String haystack, String needle) {
        int foundAtIndex = -1;
        int i = 0;
        int needleLength = needle.length();
        int haystackLength = haystack.length();
        char startChar = needle.charAt(0);
        while (i < haystackLength - needleLength + 1 && foundAtIndex == -1) {
            if (haystack.charAt(i) == startChar
                    && haystack.substring(i, i + needleLength).equals(needle)) {
                foundAtIndex = i;
            }
            i++;
        }
        return foundAtIndex;
    }
}