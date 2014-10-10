/**
 * Problem Statement: Maximum Subarray
 * Link: https://oj.leetcode.com/problems/maximum-subarray/
 * Time:408ms
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 */


public class Solution {
    
    public int maxSubArray(int[] A) {
        
        //special case
        if(A.length==0) return 0;
        
        //initialize
        //global_max: the current max value of all traversed sequence
        //tmp_max: the max value of current sequence
        int global_max = A[0];
        int tmp_max = 0;
        
        
        for(int i=0; i<A.length; i++){
            //decide whether to add A[i] to original sequence
            //or start a new sequence
            if(tmp_max>0)
                tmp_max = tmp_max + A[i];
            else tmp_max = A[i];
            if(global_max < tmp_max) global_max = tmp_max;
        }
        
        return global_max;
    }
}