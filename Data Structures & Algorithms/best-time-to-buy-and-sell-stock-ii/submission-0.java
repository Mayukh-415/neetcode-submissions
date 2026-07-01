class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if (n == 0 || n == 1)
            return 0;

        int i = 0;

        int profit = 0;

        while (i < n - 1) {
            while (i < n - 1 && prices[i] >= prices[i + 1]) i++;

            int valley = prices[i];

            while (i < n - 1 && prices[i] <= prices[i + 1]) i++;

            int peak = prices[i];

            profit = profit + (peak - valley);
        }

        return profit;
    }
}
