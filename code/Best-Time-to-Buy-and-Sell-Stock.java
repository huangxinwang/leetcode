/**
 * Problem Statement: Best Time to Buy and Sell Stock
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 */


public class Solution {
    public int maxProfit(int[] prices) {

        //special case
        if(prices.length<=1) return 0;
        
        //init
        int profit = 0;
        int min = prices[0];
        int max = prices[0];
        
        //traverse and record best profit
        for(int i=1; i<prices.length; i++){
            //update max
            if(max<prices[i]){
                 max = prices[i];
                 int tmp = max - min;
                 profit = profit>tmp ? profit : tmp;
            }
            //update min
            else if(min>prices[i]){
                min = prices[i];
                max = prices[i];
            }
        }
        
        return profit;
    }
}