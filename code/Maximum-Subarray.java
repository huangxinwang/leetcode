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

////////////////////////////////////
// 2015/12/16
// Highlight: logic
// Time: O(n)

public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr = nums[0];
        for(int i=1; i<nums.length; i++){
            //if previous sum is negative, discard it
            if(curr<0) curr = nums[i];
            else curr = curr + nums[i];
            if(max<curr) max = curr;
        }
        return max;
    }
}
