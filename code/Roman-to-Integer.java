/**
 * Problem Statement: Roman to Integer 
 * Link: https://oj.leetcode.com/problems/roman-to-integer/
 * Hardness: **
 * 
 * 
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */


public class Solution {
    public int romanToInt(String s) {
        
        int rnt = 0;
        for(int i=0; i<s.length(); i++){
            
            //from left to right, if increasing order, then add (current - 2*left) to sum
            //otherwise, keep adding up
            if(i>0 && cToi(s.charAt(i)) > cToi(s.charAt(i-1))){
               
                rnt +=(cToi(s.charAt(i)) - 2*cToi(s.charAt(i-1)));
            }else
                rnt += cToi(s.charAt(i));
        }
        
        return rnt;
        
    }
    
    //convert char to int
    public int cToi(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}