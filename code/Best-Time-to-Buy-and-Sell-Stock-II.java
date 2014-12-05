/**
 * Problem Statement: Best Time to Buy and Sell Stock II 
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). 
 * 
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */



public class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0;
        
        //trick
        for(int i=0; i<prices.length-1; i++){
            profit += Math.max(0,prices[i+1]-prices[i]);
        }
        
        return profit;
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 12/04/2014
//time complexity O(n)


public class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length <=1) return 0;
        int maxpro = 0;

        //sell the stock whenever it is possible to make profits
        for(int i=1; i<prices.length; i++){
            if(prices[i] > prices[i-1])
                maxpro += prices[i] - prices[i-1];
            else continue;
        }
        
        return maxpro;
        
    }
}
