// TC:O(n), SC:O(1)
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int[] jewelsArr = new int[128];
        for (int i = 0; i < jewels.length(); i++) {
            jewelsArr[(int) jewels.charAt(i)] = 1;
        }
        int totalJewels = 0;
        for (int i = 0; i < stones.length(); i++) {
            totalJewels += jewelsArr[(int) stones.charAt(i)];
        }
        return totalJewels;
    }
}