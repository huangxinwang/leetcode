/**
*Problem Statement: Move Zeros
*
* Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
*
* For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
*
* Note:
* You must do this in-place without making a copy of the array.
* Minimize the total number of operations.
*
*
*/


//////////////////////////////////////
// 2015/11/19
// Highlight: keep an indx to indicate the right position to put a non-zero number
public class Solution {
    public void moveZeroes(int[] nums) {
        
        //use idx to keep track the right position to put a non-zero number
        int idx = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[idx] = nums[i];
                idx++;
            }
        }
        
        for(int i=idx; i<nums.length; i++)
            nums[i] = 0;
    }
}
