/**
* Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
* For example,
* Given nums = [0, 1, 3] return 2.
*
**/

///////////////////////////////////////////////////
// 2015/11/14
// Highlight: xor operation
public class Solution {
    public int missingNumber(int[] nums) {
        
       //xor all the numbers with number 0..n, similar to single number
       int res = 0;
       for(int i=0; i<nums.length; i++){
           res = res  ^ ( (i+1) ^ nums[i]);
       }
       
       return res;
    }
}
