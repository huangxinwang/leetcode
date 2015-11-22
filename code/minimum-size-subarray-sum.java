/**
* Problem Statement: Minimum Size Subarray Sum
*
* Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
* 
* For example, given the array [2,3,1,2,4,3] and s = 7,
* the subarray [4,3] has the minimal length under the problem constraint.
*/


///////////////////////////////////////////
// 2015/11/21
// Highlight: logic
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int max = Integer.MAX_VALUE;
        boolean found = false;
        int start = 0;
        int end = 0;
        int currsum = 0;
        while(end<nums.length){
              currsum += nums[end];
              
              //these subsequence all satisfy condition
              while(currsum >= s && start<=end){
                  found = true;
                  int count = end-start+1;
                  if(count<max) max = count;
                    
                  //advance head               
                  currsum -= nums[start];
                  start++;
              }
             end++;
        }
        
        if(found) return max;
        return 0;
    }
}
