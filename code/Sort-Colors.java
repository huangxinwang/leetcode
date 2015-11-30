/**
 * Problem Statement: Sort Colors 
 * Link: https://oj.leetcode.com/problems/sort-colors/
 * 
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */



/////////////////////////////////////////////////////
// 2015/11/30
// Highlight: in place exchange
public class Solution {
    public void sortColors(int[] nums) {
        //put 0 in the first part of array
        int start = help(nums,0,nums.length-1,0);
        //put 1 in the second part of array
        help(nums,start,nums.length-1,1);
    }
    
    public int help(int[] nums, int start, int end, int target){
        int i=start;
        
        for(; i<end; i++){
            if(nums[i]==target) continue;
            else{
                //find target value from end
                while(end>start && nums[end]!=target){
                    end--;
                }
                //corner case
                if(i>=end) break;
                //exchange
                nums[end] = nums[i];
                nums[i] = target;
            }
        }
        return i;
    }
}
