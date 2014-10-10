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