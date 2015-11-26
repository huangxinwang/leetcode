/**
* Problem Statement: Best Time to Buy and Sell Stock with Cooldown
* Say you have an array for which the ith element is the price of a given stock on day i.
* 
* Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
* 
* You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
* After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
*
*/


/////////////////////////////////////////////
//2015/11/25
//Highlight: 1D Dynamic programming, logic
//Ref: http://www.hrwhisper.me/leetcode-best-time-to-buy-and-sell-stock-with-cooldown/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        
        //buy[i] is the maximum profit of buy at i-th day (need to consider whether buy at i-1 day)
        //sell[i] is the maximum profit of sell at i-th day (need to consider whether sell at i-1 day)
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[0] = 0;
        sell[1] = Math.max(0, prices[1]-prices[0]);
        
        for(int i=2; i<prices.length; i++){
            //sell at i-2, or buy at i-1 day (not sell at i-2 day)
            buy[i] = Math.max(sell[i-2]-prices[i], buy[i-1]);
            
            //buy before i-1, or sell at i-1
            sell[i] = Math.max(buy[i-1]+prices[i], sell[i-1]);
        }
        
        int rnt = 0;
        for(int i=0; i<sell.length; i++){
            rnt = rnt<sell[i] ? sell[i]: rnt;
        }
        
        return rnt;
    }
}
