/**
 * Problem Statement: Best Time to Buy and Sell Stock
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 */

/////////////////////////////////////
// 2015/12/28
// Highlight: keep track of min value

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;
        int rnt = 0;
        int min = prices[0];
        
        for(int i=1; i<prices.length; i++){
            //update min value before or at the i-th days
            min = Math.min(prices[i],min);
            //calculate the profit
            rnt = Math.max(rnt, prices[i]-min);
        }
        return rnt;
    }
}
