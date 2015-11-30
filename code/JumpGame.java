/**
 * Problem Statement: Jump Game 
 * Link: https://oj.leetcode.com/problems/jump-game/
 * Time: 408 ms
 * Ref: http://fisherlei.blogspot.com/2012/12/leetcode-jump-game.html
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */


/////////////////////////////////
// 2015/11/29
// Highlight: logic
//            keep track of the maximum idx can jump to
public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i=0; i<nums.length && i<=max; i++){
            int curr = i+nums[i];
            //update current maximum idx can jump to
            if(max<curr) max = curr;
            if(max>=nums.length-1) return true;
        }
        
        return false;
    }
}
