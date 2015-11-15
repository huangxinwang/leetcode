/**
*Reverse bits of a given 32 bits unsigned integer.
*
*For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented *in binary as 00111001011110000010100101000000).
*/

///////////////////////////////////////////
//2015/11/14
// Highlight: bit operation, avoid overflow
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rnt = 0;
        int mask = 1;
        int idx = 0;
        
        for(int i=0; i<32; i++){
            mask  = 1<< i;
            //current bit is 1
            if((mask & n)!=0){
                rnt = rnt +1;
            }
            //avoid overflow
            if(i!=31) rnt = rnt<<1;
        }
        
        return rnt;
    }
}
