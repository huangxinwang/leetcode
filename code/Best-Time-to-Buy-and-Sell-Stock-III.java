/**
 * Problem Statement: Best Time to Buy and Sell Stock III 
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */



/**
 * Reference: http://blog.csdn.net/u013027996/article/details/19414967
 */


public class Solution {
    public int maxProfit(int[] prices) {
        
        //max-profit = max-profit[1..i] + max-profit[i+1..n]
        //let arrayA[i] denote the max profit gain from 0..i
        //let arrayB[i] denote the max profit gain from i..len
        //use dynamic programming to construct arrayA and arrayB
        
        if(prices.length==0 || prices.length==1) return 0;
        int[] arrayA = new int[prices.length];
        int[] arrayB= new int[prices.length];
        
        //build arrayA
        int min = prices[0];
        arrayA[0] = 0;
        for(int i=1; i<prices.length; i++){
            arrayA[i] = prices[i] - min;
            arrayA[i] = arrayA[i] > arrayA[i-1] ? arrayA[i] : arrayA[i-1];
            if(prices[i] < min)
                min = prices[i];
        }
        
        //build arrayB
        int max = prices[prices.length-1];
        arrayB[prices.length-1] = 0;
        for(int i=prices.length-2; i>=0; i--){
            arrayB[i] = max - prices[i];
            arrayB[i] = arrayB[i] > arrayB[i+1] ? arrayB[i] : arrayB[i+1];
            if(prices[i] > max)
                max = prices[i];
        }
        
        //calculate max-profit
        int profit = 0;
        for(int i=0; i<prices.length-1; i++){
            int tmp = arrayA[i] + arrayB[i];
            profit = profit > tmp ? profit : tmp;
        }
        
        return profit;
    }
}


///////////////////////////////////////////////////////////////////////////////
//Round 2: 12/04/2014
//Time complexity O(n)
//My question: what if the constraints is k times of buy and sell?

public class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length <=1 ) return 0;
        //let A[i] denote the maximum profit achieved from 0 to i-the day
        int[] A = new int[prices.length];
        int min = prices[0];
        A[0] = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i] < min)
                min = prices[i];
            A[i] = prices[i] - min;
        }
        
        //Let B[i] denote the maximum profit achieved from i-the day to len
        int[] B = new int[prices.length];
        int max = prices[prices.length-1];
        B[prices.length-1] = 0;
        for(int i=prices.length-2; i>=0; i--){
            if(max < prices[i])
                max = prices[i];
            B[i] = Math.max(max - prices[i], B[i+1]);
        }
        
        //sum up
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++){
            if(maxProfit < A[i] + B[i])
                maxProfit = A[i] + B[i];
        }
        
        return maxProfit;
        
    }
    
    
}
