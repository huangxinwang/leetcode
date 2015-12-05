// First position of target
//
//For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
//If the target number does not exist in the array, return -1.


////////////////////////////////////////////////////////////////////////
// 2015/12/05
// Time: O(logn)
class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        int low = 0;
        int high = nums.length-1;
        
        while(low<high){
            int mid = low + (high-low)/2;
            //advance lower when <
            if(nums[mid]<target){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        
        if(nums[low]!=target) return -1;
        return low;
    }
}
