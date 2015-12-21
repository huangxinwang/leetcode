/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
 
/**
 * Principle
 * a^b = b^a
 * a^b^c = a^(b^c)
 */
 
////////////////////////////////////
// 2015/12/20
// Highlight: bit operation
public class Solution {
    public int singleNumber(int[] nums) {
        //0 xor x equals x
        int rnt = 0;
        //x xor x equals 0
        for(int i=0; i<nums.length; i++){
            rnt ^= nums[i];
        }
        return rnt;
    }
}
