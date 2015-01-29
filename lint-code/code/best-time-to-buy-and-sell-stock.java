public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices.length<=1) return 0;
        
        int min = prices[0];
       
        int rnt = 0;
        
        for(int i=1; i<prices.length; i++){
            int curr = prices[i] - min;
            rnt = rnt<curr ? curr: rnt;
            min = min<prices[i] ? min: prices[i];
        }
        
        return rnt;
    }
}
