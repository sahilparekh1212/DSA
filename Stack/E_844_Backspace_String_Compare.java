class Solution {
    public boolean backspaceCompare(String strA, String strB) {
        int a = strA.length() - 1;
        int b = strB.length() - 1;
        int skipA = 0;
        int skipB = 0;
        // must loop until both strings are travrsed
        while (a >= 0 || b >= 0) {
            while (a >= 0) {
                if (strA.charAt(a) == '#') {
                    skipA++;
                    a--;
                } else if (skipA > 0) {
                    skipA--;
                    a--;
                } else {
                    break;
                }
            }
            while (b >= 0) {
                if (strB.charAt(b) == '#') {
                    skipB++;
                    b--;
                } else if (skipB > 0) {
                    skipB--;
                    b--;
                } else {
                    break;
                }
            }
            // if mismatch found or one string ends earlier
            if ((a >= 0 && b >= 0 && strA.charAt(a) != strB.charAt(b)
                    ||
                    ((a >= 0) && (b < 0))
                    ||
                    ((b >= 0) && (a < 0)))) {
                return false;
            }
            a--;
            b--;
        }
        return true;
    }
}