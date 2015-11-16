/**
* Problem Statement: Number of 1 bits
*
* Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
*
* For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
*/

///////////////////////////////////////////////////////////////
// 2015/11/15
// Highlight: bit operation, use mask to get the i-th bit
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int rnt = 0;
        int mask = 1;
        
        //mask to get the i-th bit 
        for(int i=0; i<32; i++){
            mask = 1<<i;
            if ((mask & n)!=0) rnt++;
        }
        return rnt;
    }
}
