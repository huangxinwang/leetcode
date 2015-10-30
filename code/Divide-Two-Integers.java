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


////////////////////////////////////////////////////////////////////
// 2015/10/30
// Highlight: need to discuss with Huahua
public class Solution {
    public int divide(int dividend_int, int divisor_int) {
        
        //special case
        if(divisor_int==0) return Integer.MAX_VALUE;
        if(divisor_int==1) return dividend_int;
        
        //convert to long
        long dividend = dividend_int;
        long divisor = divisor_int;
        
        //sign
        boolean negative = false;
        if(dividend<0 && divisor>0) negative = true;
        if(dividend>0 && divisor<0) negative = true;
        if(dividend<0) dividend = - dividend;
        if(divisor<0) divisor = - divisor;
        
        // build list
        ArrayList<Long> num = new ArrayList<Long>();
        ArrayList<Integer> times = new ArrayList<Integer>();
        long curr = divisor;
        int lastTime = 1;
        
        while(curr<=dividend){
            num.add(curr);
            times.add(lastTime);
            curr += curr;
            lastTime += lastTime;
        }
        
        
        //divide
        long rnt = 0;
        
        for(int i=num.size()-1; i>=0; i--){
            if(dividend>=num.get(i)){
                rnt += times.get(i);
                dividend -= num.get(i);
                if(dividend==0 || dividend < num.get(0))
                    break;
            }
        }
        
        
        //deal with result
        if(negative) rnt = -rnt;
         
        if(rnt >= Integer.MAX_VALUE) rnt = Integer.MAX_VALUE;
        if(!negative && rnt < 0) rnt = Integer.MAX_VALUE;
        
        return (int)rnt;
        
        
    }
}
