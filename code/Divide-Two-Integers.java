/**
 * Problem Statement: Divide Two Integers
 * Ref: http://www.lifeincode.net/programming/leetcode-divide-two-integers-java/
 * 
 */

public class Solution {
    public int divide(int dividend, int divisor) {
        
        //long p = Math.abs((long)dividend);
        //long q = Math.abs((long)divisor);
        long p = dividend<0? -(long)dividend: dividend;
        long q = divisor<0? -(long)divisor: divisor;
        
        long rnt = 0;
        while(p>=q){
            int count = 0;
            while(p >= q<<count){
                count++;
            }
            rnt += 1L << (count-1);
            p -= q<<(count-1);
        }
        
        if( (dividend<0 && divisor>0) || (dividend >0 && divisor<0))
            rnt = -rnt;
            
        if(rnt>Integer.MAX_VALUE) rnt = Integer.MAX_VALUE;
        return (int)rnt;
    }
}
