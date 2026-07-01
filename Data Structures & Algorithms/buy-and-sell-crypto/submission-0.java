class Solution {
    public int maxProfit(int[] prices) {
        // Track the lowest price we've seen so far. 
        // Initialize to the maximum possible integer so the first price always becomes the new min.
        int minPrice = Integer.MAX_VALUE; 
        
        // Track the maximum profit we can make.
        int maxProfit = 0; 
        
        for (int i = 0; i < prices.length; i++) {
            // 1. Is today's price the new lowest price we've seen?
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } 
            // 2. If not, would we make a better profit selling today than our previous best?
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        
        return maxProfit;
    }
}
