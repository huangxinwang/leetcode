/**
 * Problem Statement: Search in Rotated Sorted Array
 * Link:https://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 * Time:432 ms
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * 
 * 
 */


//////////////////////////////////////////////////////////////////////
// 2015/11/28
// Recursive
// Highlight: discuss left < mid (further discuss left<target<mid); otherwise further discuss (mid<target<right)
public class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0) return -1;
        return bs(nums, target, 0, nums.length-1);
    }
    
    public int bs(int[] nums, int target, int left, int right){
        if(left>right) return -1;
        int mid = left + (right-left)/2;
        
        if(nums[mid] == target) return mid;
        //corner case: <=, rather than <
        if(nums[left]<=nums[mid]){
            if(nums[left]<=target && target<nums[mid])
                return bs(nums, target, left, mid-1);
            else return bs(nums, target, mid+1, right);
        }else{
            if(nums[mid]<target && target <= nums[right])
                return bs(nums, target, mid+1, right);
            else return bs(nums, target, left, mid-1);
        }
    }
}


//////////////////////////////////////////////////////////////////////
// 2015/11/28
// Iterative
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target) return mid;
            
            if(nums[left]<=nums[mid]){
                if(nums[left]<=target && target<nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(nums[mid]<target && target<=nums[right]){
                    left = mid+1;
                }else right = mid-1;
            }
        }
        
        return -1;
    }
}
