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


///////////////////////////////////////////////////////////////////
// 2015/12/07
// Highlight: maintain current max and min value
public class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null) return 0;
        int rnt = nums[0];
        int currmin = nums[0];
        int currmax = nums[0];
        
        for(int i=1; i<nums.length; i++){
            //avoid overwriting
           int tmpmax = currmax;
           int tmpmin = currmin;
           //computer currentmax and min
           if(nums[i]>0){
               tmpmax = Math.max(nums[i], currmax*nums[i]);
               tmpmin = Math.min(nums[i], currmin*nums[i]);
           }else{
               tmpmax = Math.max(nums[i], currmin*nums[i]);
               tmpmin = Math.min(nums[i], currmax*nums[i]);
           }
           currmax = tmpmax;
           currmin = tmpmin;
           
           if(rnt<currmax) rnt = currmax;
        }
        
        return rnt;
        
    }
    
    
}


///////////////////////////////////////////////////////////////////

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



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2, 11/25/2014
//time complexity: O(n)

public class Solution {
    public int maxProduct(int[] A) {
        
        //maintain current local max/min and global max
        int globalMax = A[0];
        int localMin = A[0];
        int localMax = A[0];
        
        //update local max/min based on whether A[i] is larger, equal or smaller than 0
        for(int i=1; i<A.length; i++){
            
            if(A[i] > 0){
                localMax = Math.max(localMax*A[i], A[i]);
                localMin = Math.min(localMin*A[i], A[i]); 
            }else if(A[i]<0){
                int tmpLocalMax = Math.max(A[i], localMin*A[i]);
                localMin = Math.min(A[i], localMax*A[i]);
                localMax = tmpLocalMax;
            }
            else{
                localMax = 0;
                localMin = 0;
            }
            
            //update globalmax
            if(localMax > globalMax) globalMax = localMax;
        }
        
        return globalMax;
    }
}


////////////////////////////////////////////////////////////////
// 2015/11/14
// Highlight: maintain a current min and current max value
public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==1) return nums[0];
        
        //maintain a current min and current max value
        int currmin = nums[0];
        int currmax = nums[0];
        int max = currmax;
        for(int i=1; i<nums.length; i++){
            int val1 = currmin * nums[i];
            int val2 = currmax * nums[i];
            
            currmax = Math.max(val1, val2);
            if(currmax < nums[i]){
                currmax = nums[i];
            }
        
            
            currmin = Math.min(val1, val2);
            if(currmin > nums[i]){
                currmin = nums[i];
            }
            
            //update global max
            if(max<currmax) max = currmax;
        }
        
        return max;
    }
}
