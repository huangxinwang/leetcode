/**
* Problem Statement: House Robber
*
* You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only *constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically *contact the police if two adjacent houses were broken into on the same night.
*
* Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can * rob tonight without alerting the police.
*/

/////////////////////////////////////
// 2015/11/20
// Highlight: 1D DP
public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        
        //use DP to keep track the maximum gain of stop at i
        int[] stop = new int[nums.length+1];
        
        stop[1] = nums[0];

        
        for(int i=1; i<nums.length; i++){
            stop[i+1] = Math.max(stop[i-1]+nums[i], stop[i]);
        }
        
        return stop[nums.length];
    }
}
