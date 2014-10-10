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