/**
* Problem Statement: Find the Duplicate Number
*
*/


/////////////////////////////////////////
// 2015/11/30
// Highlight: binary search
// # of number < mid between [1,mid], then the duplicate number is in the right
public class Solution {
    public int findDuplicate(int[] nums) {
       int min = 1;
       int max = nums.length-1;
       
       while(min<=max){
           int mid = (min + max)/2;
           int count = 0;
           for(int i=0; i<nums.length; i++){
               if(nums[i]<=mid){
                   count++;
               }
           }
           if(count>mid){
               max = mid-1;
           }else{
               min = mid+1;
           }
       }
       
       return min;
    }
}
