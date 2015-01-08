/**
 * Problem Statement: Regular Expression Matching 
 * Link: https://oj.leetcode.com/problems/regular-expression-matching/
 * Hardness: *****
 * 
 */



public class Solution {
    public boolean isMatch(String s, String p) {
        
        int sp = 0;
        int pp = 0;
        
        return subMatch(s, p, sp, pp);
    }
    
    public boolean subMatch(String s, String p, int sp, int pp){
        
        //1. terminate case
        //when p scaned to the end, and sp is not scaned to the end, return false
        if(pp == p.length()) return sp == s.length();
        
        //2. base case
        //the second symbol of current unscaned part of p is not '*'
        //or current unscaned symbol is only 1
        if(pp == p.length()-1 || p.charAt(pp+1)!='*'){
            //sp is scaned to the end, return false;
            //note that this line cannot be put outside, because '' match with 'a*'.
            if(sp == s.length()) return false;
            if(s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '.')
                return subMatch(s, p, sp+1, pp+1);
            return false;
        }
        
        //3. next symbol of p is 'a*'
        else{
            
            //skip 'a*'
            if(subMatch(s, p, sp,pp+2)) return true;
            
            //match all possible string at s to 'a*'
            int start = sp;
            while(start<s.length() && ( s.charAt(start) == p.charAt(pp) || p.charAt(pp) == '.')){
                //match remain strings
                if(subMatch(s, p, start+1,pp+2)) return true;
                start++;
            }
            return false;
        }
    }
}


/////////////////////////////////////////////////////////////////////
//Round 2: 1/8/2015
public class Solution {
    public boolean isMatch(String s, String p) {
        
        return helper(s, p, 0, 0);
    }
    
    public boolean helper(String s, String p, int sp, int pp){
        
        //case 1: terminate cases
        if(pp>=p.length())
            return sp==s.length();
        
        //case 2: ab
        if(pp==p.length()-1 || p.charAt(pp+1)!='*'){
            if(sp>=s.length()) return false;
            if(s.charAt(sp)==p.charAt(pp) || p.charAt(pp)=='.')
                return helper(s, p, sp+1, pp+1);
            return false;
        }
        //Case 3: a*, or a
        else{
            
            if(helper(s, p, sp, pp+2)) return true;
            
            int start = sp;
            while(start<s.length() && (s.charAt(start)==p.charAt(pp) || p.charAt(pp)=='.')){

                if(helper(s, p, start+1, pp+2)) return true;
                start++;
            }
            
            return false;
        }
    }
}
