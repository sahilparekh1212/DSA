class Solution {
    public int maxProfit(int[] prices) {
        int totalp = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                totalp += prices[i] - prices[i - 1];
            }
        }
        return totalp;
    }
}