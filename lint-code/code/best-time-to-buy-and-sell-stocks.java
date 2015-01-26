class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int sum = 0;
        if(prices.length<=1) return 0;
        
        int curr = prices[0];
        for(int i=1; i<prices.length; i++){
            if(curr<prices[i])
                sum += (prices[i] - curr);
            curr = prices[i];
        }
        
        return sum;
    }
};
