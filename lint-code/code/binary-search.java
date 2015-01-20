/**
* Problem Statement: 
*
* For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
* If the target number does not exist in the array, return -1.
*/

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        int idx1 = help(nums, target-1,  0, nums.length-1);
        int idx2 = help(nums, target, 0, nums.length-1);
        if(idx1 == idx2) return -1;
        else return idx1;
    }
    
    //return (index+1) of the right most of the target value
    public int help(int[] nums, int target, int left, int right){
        if(left > right) return left;
        int mid = (left + right)/2;
        
        if(nums[mid] <= target)
            return help(nums, target, mid+1, right);
        else return help(nums, target, left, mid-1);
    }
}
