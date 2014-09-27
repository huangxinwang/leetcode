/**
 * Problem Statement: Maximum Product Subarray 
 * Link: https://oj.leetcode.com/problems/maximum-product-subarray/
 * Time: 384 ms
 * Hardness: **
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */

public class Solution {
    public int maxProduct(int[] A) {
		if(A.length==0) return 0;
		
        int max = A[0];
        //maintain last max positive, last min negative
        int localNegMin = A[0];
        int localPosMax = A[0];
        //maintain current max positive, current min negative
        int currMin = 0;
        int currMax = 0;
        
        //maintain a current max positive, and current min negative
        for(int i=1; i<A.length; i++){
            int curr = A[i];
            
            //calculate current max positive, and min negative
            if(curr<0){
                currMin = localPosMax>0 ? localPosMax*curr:curr;
                currMax = localNegMin<=0 ? localNegMin*curr:curr;
            }else{
                currMin = localNegMin<=0 ? localNegMin*curr:curr;
                currMax = localPosMax>0 ? localPosMax*curr:curr;
            }
            
            //update last max positive, min negative
            localPosMax = currMax;
            localNegMin = currMin;
            //update max value
            max = max>localPosMax ? max : localPosMax;
        }
        
        return max;
    }
}
