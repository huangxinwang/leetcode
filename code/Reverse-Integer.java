/**
 * Problem Statement: Reverse Integer 
 * Link: https://oj.leetcode.com/problems/reverse-integer/
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
 
public class Solution {
    public int reverse(int x) {
        //check if positive or negative
        boolean flag = true;
        if(x<0){
           x=-x;
           flag = false;
        } 
        
        //convert int to string
        //reverse string
        String xStr = String.valueOf(x);
        String rnt = new String();
        for(int i=xStr.length()-1; i>=0; i--)
            rnt+=xStr.charAt(i);
        
        //convert string to int 
        int rntVal = Integer.parseInt(rnt);
        
        //add sign
        if(flag) return rntVal;
        else return -rntVal;
    }
}

///////////////////////////////////////////////////////////////////////////////////
//Round 2: 12/26/2014
public class Solution {
    public int reverse(int x) {
        
        //since overflow may happen, thus we denote the variable as long type
        long rnt = 0; long remain = 0;
        
        while(x!=0){
            remain = x%10;
            rnt = rnt*10+remain;
            x = x/10;
        }
        
        //decide if overflow, if yes, return 0
        if(rnt >= Integer.MAX_VALUE ||  rnt<=Integer.MIN_VALUE) return 0;
        
        return (int)rnt;
    }
}


///////////////////////////////////////////////////////////////////////
// 10/09/2015
// Highlight: corner case, larger than max or less than min
public class Solution {
    public int reverse(int x) {
        long rnt = 0;
        long remain = 0;
        
        while(x!=0){
            remain = x%10;
            rnt = rnt*10+remain;
            x = x/10;
        }
        
        if(rnt<=Integer.MIN_VALUE || rnt>=Integer.MAX_VALUE)
            return 0;
        else return (int)rnt;
    }
}
