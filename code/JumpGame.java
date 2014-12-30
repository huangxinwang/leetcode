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


public class Solution {
    public boolean canJump(int[] A) {
       
    //let maxCover denote the maximum distance can go
    int maxCover = A[0];
    for(int start = 0; start<A.length && start<=maxCover; start++){
       //update maxCover if current step allow going a further distance
       if(start+A[start] > maxCover)
            maxCover = start + A[start];
       //will reach end
       if(maxCover >= A.length-1) return true;
    }
    
    return false;
    }
}

//////////////////////////////////////////////////////////////////////////
//Round 2; 12/29/2014
public class Solution {
    public boolean canJump(int[] A) {
        
        //define max-cover
        int maxCover = A[0];
        
        //traverse A constrainted by maxCover
        for(int start=0; start<A.length && start<=maxCover; start++){
            //update maxCover if further distance can be reached
            if(start+A[start] > maxCover)
                maxCover = start+A[start];
                
            //check terminate condition
            if(maxCover>=A.length-1) return true;
        }
        return false;
    }
}
