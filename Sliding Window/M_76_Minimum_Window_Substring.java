class Solution {
    public String minWindow(String s, String t) {
        // Note: we can Array as lookup also because we have 52 posiible char in b
        Map<Character, Integer> targetMap = new HashMap<>();
        Character currChar = new Character(' ');
        for (int i = 0; i < t.length(); i++) {
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        ;

        Map<Character, Integer> windowTarget_Map = new HashMap<>();
        int left = 0;
        int minLeft = 0;
        int minLenFromMinLeft = s.length() + 1;
        int target = targetMap.size();

        for (int right = 0; right < s.length(); right++) {
            currChar = s.charAt(right);

            if (targetMap.containsKey(currChar)) {
                windowTarget_Map.put(currChar, windowTarget_Map.getOrDefault(currChar, 0) + 1);
                // MUST USE .equals
                // == won't work
                if (windowTarget_Map.get(currChar).equals(targetMap.get(currChar))) {
                    target--;
                }
            }

            while (target == 0) {
                if ((right - left + 1) < minLenFromMinLeft) {
                    minLeft = left;
                    minLenFromMinLeft = (right - left + 1);
                }

                // update windowTarget_Map and have
                if (windowTarget_Map.containsKey(s.charAt(left))) {
                    windowTarget_Map.put(s.charAt(left), windowTarget_Map.get(s.charAt(left)) - 1);
                    if (windowTarget_Map.get(s.charAt(left)) < targetMap.get(s.charAt(left))) {
                        target++;
                    }
                }

                // remove from left;
                left++;
            }
        }
        return (minLenFromMinLeft <= s.length()) ? s.substring(minLeft, minLeft + minLenFromMinLeft) : "";

    }
}