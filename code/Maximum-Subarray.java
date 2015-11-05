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

//////////////////////////////////////////////////////////////////////////////
//Round 2: 12/30/2014
public class Solution {
    public int maxSubArray(int[] A) {
        
        int max = A[0];
        int sum = A[0];
        
        //one round traverse
        //if current sum <0; then set it to 0
        //update max value
        for(int i=1; i<A.length; i++){
            if(sum<0) sum = 0;
            sum = sum+A[i];
            if(sum>max) max = sum;
        }
        
        return max;
    }
}


////////////////////////////////////////////
// 2015/11/05
// Highlight: logic
public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr = nums[0]<0? 0: nums[0];
        for(int i=1; i<nums.length; i++){
            curr = curr + nums[i];
            if(max<curr) max = curr;
            //discard previous traversed, if curr <0
            if(curr<0) curr = 0;
        }
        
        return max;
    }
}
