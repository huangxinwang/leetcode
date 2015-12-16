/**
 * Problem Statement: Find Peak Element
 * Link: https://oj.leetcode.com/problems/find-peak-element/
 * 
 */

public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        
        //corner cases
        if(nums[0]>nums[1]) return 0;
        int len = nums.length;
        if(nums[len-1]>nums[len-2]) return len-1;
        
        //find peak
        for(int i=1; i<len-1; i++){
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1]) return i;
        }
        return -1;
    }
}
