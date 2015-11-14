/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
 
/**
 * Principle
 * a^b = b^a
 * a^b^c = a^(b^c)
 */
 
public class Solution {
    public int singleNumber(int[] A) {
        
        int rnt = 0;
        for(int i=0; i<A.length; i++)
        {
            //xor
            rnt = rnt^A[i];
        }
        
        return rnt;
    }
}


///////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 11/30/2014

//time complexity O(n)
public class Solution {
    public int singleNumber(int[] A) {
        
        int rnt = 0;
        for(int i=0; i<A.length; i++){
            rnt = rnt^A[i];
        }
        
        return rnt;
    }
}


/////////////////////////////////////////
// 2015/11/13
// Highlight: xor
public class Solution {
    public int singleNumber(int[] nums) {
        
        int rnt = nums[0];
        
        //(a ^ b) ^ b = a
        for(int i=1; i<nums.length; i++){
            rnt = rnt ^ nums[i];
        }
        
        return rnt;
    }
}
