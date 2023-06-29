class Solution {
    public boolean isIsomorphic(String s, String t) {
        int i = 0;
        int sLen = s.length();
        if (sLen != t.length()) {
            return false;
        }
        // printable 128 ASCII
        Character[] ref1 = new Character[128];
        Character[] ref2 = new Character[128];
        while (i < sLen) {
            if (ref1[(int) s.charAt(i)] != ref2[(int) t.charAt(i)]) {
                return false;
            }
            if (ref1[(int) s.charAt(i)] == null) {
                // note: both are getting assigned same value
                ref1[(int) s.charAt(i)] = t.charAt(i);
                ref2[(int) t.charAt(i)] = t.charAt(i);
            }
            i++;
        }
        return true;
    }
}