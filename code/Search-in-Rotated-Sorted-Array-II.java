/**
 * Problem Statement: Search in Rotated Sorted Array II 
 * Link: https://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * 
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * 
 */

////////////////////////////////////////////////////
// 2015/11/28
// Highlight: if leftval == midval, then we can only advance the leftpointer by 1
// Ref: http://blog.csdn.net/linhuanmars/article/details/20588511
public class Solution {
    public boolean search(int[] nums, int target) {
        return bs(nums, target, 0, nums.length-1);
    }
    
    public boolean bs(int[] nums, int target, int left, int right){
        if(left>right) return false;
        int mid = left + (right-left)/2;
        
        if(nums[mid]==target) return true;
        
        if(nums[left]<nums[mid]){
            if(nums[left]<=target && target<nums[mid])
                return bs(nums,target, left, mid-1);
            else return bs(nums, target, mid+1, right);
        }
        else if(nums[left] > nums[mid]){
            if(nums[mid]<target && target<=nums[right])
                return bs(nums, target, mid+1, right);
            else return bs(nums, target, left, mid-1);
        }else{
            return bs(nums, target, left+1, right);
        }
    }
}
