/**
 * Problem Statement: Jump Game II
 * Link: https://oj.leetcode.com/problems/jump-game-ii/
 * Time: 416 ms
 * Hardness: ***
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */


public class Solution {
    public int jump(int[] A) {
        
        int len = A.length;
        
        //define: minStep[i] is the minStep to reach at index i
        int[] minStep = new int[len];
        
        //init: 
        int maxCover = Math.min(A[0],len-1);
        minStep[0] = 0;
        for(int i=1; i<=maxCover; i++){
            minStep[i] = 1;
        }
        
        //traverse and update maxCover and minStep
        for(int start=0; start<=maxCover; start++){
            
            if(start+A[start]>maxCover){
                int newMaxCover = Math.min(start+A[start],len-1);
                //update the minStep from oldMaxCover to newMaxCover
                for(int j=maxCover+1; j<=newMaxCover; j++){
                    minStep[j] = minStep[start]+1;
                }
                maxCover = newMaxCover;
            }
            //reach end
            if(maxCover>=len-1) return minStep[len-1];
        }
        
        return Integer.MAX_VALUE;
    }
}

//////////////////////////////////////////////////////////////////////
//Round 2: 12/30/2014
public class Solution {
    public int jump(int[] A) {
        
        //special case
        if(A.length==0) return Integer.MAX_VALUE;
        if(A.length==1) return 0;
        
        //define minStep[i] as the minimum step to reach index i
        int[] minStep = new int[A.length];
        
        //initialize 
        int maxCover = Math.min(A.length-1,A[0]);
        for(int i=1; i<=maxCover; i++){
            minStep[i] = 1;
        }
        
        //traverse A
        //update maxCover
        for(int i=0; i<A.length && i<=maxCover; i++){
            if(i+A[i]>maxCover){
                int newCover = Math.min(A.length-1,i+A[i]);
                //only new extend cover are updated
                for(int j=maxCover+1; j<=newCover; j++){
                    minStep[j] = minStep[i]+1;
                }
                //update maxCover
                maxCover = newCover;
            }

        
        //terminate condition
        if(maxCover==A.length-1)    
            return minStep[A.length-1];
        }
    
    return Integer.MAX_VALUE;
    }
}
