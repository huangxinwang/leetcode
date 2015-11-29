/**
* Problem Statement: Search in Rotated Sorted Array
* Ref: http://www.1point3acres.com/bbs/thread-154432-1-1.html
*/


//http://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-java/

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
