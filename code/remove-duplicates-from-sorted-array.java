/**
 * Problem Statement: Remove Duplicates from Sorted Array
 * Link: https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */


public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int idx = 0;
        int curr = nums[0];
        
        //write the number only when it is different from next number
        for(int i=1; i<nums.length; i++){
            if(nums[i]!=curr){
                nums[idx++] = curr;
                curr = nums[i];
            }
        }
        
        //deal with the last number
        nums[idx++] = curr;
        return idx;
    }
}
