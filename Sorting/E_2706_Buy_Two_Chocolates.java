// can use partial quick sort also : similar to "215. Kth Largest Element in an Array"
class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        return (money - prices[0] - prices[1] >= 0) ? (money - prices[0] - prices[1]) : money;
    }
}