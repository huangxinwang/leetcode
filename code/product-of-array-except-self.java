/**
* Problem Statement: Product of Array Except Self
*
* Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
* Solve it without division and in O(n).
* For example, given [1,2,3,4], return [24,12,8,6].
*/

////////////////////////////////////////////////////
// 2015/11/23
// Highlight: DP
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        //keep track of prod from [0..i] and prod from [i+1..n]
        int[] forward = new int[nums.length];
        for(int i=0; i<forward.length; i++){
            if(i==0) forward[i] = 1;
            else forward[i] = forward[i-1]*nums[i-1];
        }
        int[] backward = new int[nums.length];
        for(int i=backward.length-1; i>=0; i--){
            if(i==nums.length-1) backward[i] = 1;
            else backward[i] = backward[i+1]*nums[i+1];
        }
        
        int[] rnt = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(i==0) rnt[i] = backward[0];
            else if(i==nums.length-1) rnt[i] = forward[nums.length-1];
            else rnt[i] = forward[i]*backward[i];
        }
        
        return rnt;
    }
}


///////////////////////////////////////////////
// 2015/11/13
// Highlight: constant space (except output)
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        //rnt[i] = nums[0]*...*nums[i-1]
        int[] rnt = new int[nums.length];
        for(int i=0; i<rnt.length; i++){
            if(i==0) rnt[i] = 1;
            else rnt[i] = rnt[i-1]*nums[i-1];
        }
        
        //fill the prod from i+1 to n
        int prod = 1;
        for(int i=nums.length-1; i>=0; i--){
            rnt[i] = rnt[i]*prod;
            prod = prod * nums[i];
        }
        
        return rnt;
    }
}
