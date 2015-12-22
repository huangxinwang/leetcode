/**
 * Problem Statement: Best Time to Buy and Sell Stock III 
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */

//////////////////////////////////////////////////
// 2015/12/21
// Highlight: logic

public class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length==0) return 0;
        
        //first[i], the maximum profits if sell at i
        int[] first = new int[prices.length];
        
        //second[i], the maximum profits if buy at/after i, and sell in [i,len-1]
        int[] second = new int[prices.length];
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++){
            if(prices[i]<min) min = prices[i];
            first[i] = prices[i]-min;
        }
        
        int max = prices[prices.length-1];
        for(int i=prices.length-2; i>=0; i--){
            if(max<prices[i]) max = prices[i];
            second[i] = Math.max(max - prices[i], second[i+1]);
        }
        
        //find the maximum profit of completing two transactions
        int rnt = 0;
        for(int i=0; i<prices.length; i++){
            int curr = first[i] + second[i];
            if(rnt<curr) rnt = curr;
        }
        
        return rnt;
    }
}
