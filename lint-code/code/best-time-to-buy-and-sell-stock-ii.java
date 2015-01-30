class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        
        //special case
        if(prices.length<=1) return 0;
        
        //stop[i] denote the maxprofit gain by stoping the first transaction before i
        //begin[i] denote the maxprofit gain by begining the second transaction at i
        int[] stop = new int[prices.length];
        int[] begin = new int[prices.length];
        
        int min = prices[0];
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++){
            int curr = prices[i] - min;
            maxProfit = maxProfit < curr ? curr : maxProfit;
            stop[i] = maxProfit;
            min = min < prices[i] ? min :prices[i];
        }
        
        int max = prices[prices.length-1];
        maxProfit = 0;
        for(int i=prices.length-2; i>=0; i--){
            int curr = max - prices[i];
            maxProfit = maxProfit > curr ? maxProfit : curr;
            begin[i] = maxProfit;
            max = max > prices[i] ? max : prices[i];
        }
        
        int rnt = 0;
        for(int i=0; i<prices.length; i++){
            int curr = stop[i] + begin[i];
            rnt = rnt > curr? rnt : curr;
        }
        
        return rnt;
    }
};
