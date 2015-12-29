/**
 * Problem Statement: Best Time to Buy and Sell Stock III 
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */

//////////////////////////////////////////////////
// 2015/12/21
// Highlight: logic, separate into two transactions

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;
        
        //max profit to complete an transpaction no later than the i-th day
        int min = prices[0];
        int[] pre = new int[prices.length];
        for(int i=1; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            pre[i] = Math.max(pre[i-1],prices[i]-min);
        }
        
        //max profit to complete an transaction start from the i-th day
        int max = prices[prices.length-1];
        int[] back = new int[prices.length];
        for(int i=prices.length-2; i>=0; i--){
            max = Math.max(max, prices[i]);
            back[i] = Math.max(back[i+1], max-prices[i]);
        }
        
        //choose the max profits of two transactions
        //one ends no later than the i-th day
        //one starts at or after the i-th day
        int sum = 0;
        for(int i=0; i<prices.length; i++){
            sum = Math.max(pre[i] + back[i], sum);
        }
        return sum;
    }
}
