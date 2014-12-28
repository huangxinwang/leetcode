/**
 * Problem Statement: Palindrome Number
 * Link: https://oj.leetcode.com/problems/palindrome-number/
 * Time: 680 ms
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 */


public class Solution {
    public boolean isPalindrome(int x) {
        
        String num = Integer.toString(x);
        
        for(int i=0; i<num.length()/2; i++){
            if(num.charAt(i) != num.charAt(num.length()-i-1))
                return false;
        }
        
        return true;
        
    }
}

//////////////////////////////////////////////////
//Round 2: 12/28/2014
public class Solution {
    public boolean isPalindrome(int x) {
        
        String num = String.valueOf(x);
        
        for(int i=0; i<=num.length()/2; i++){
            if(num.charAt(i) != num.charAt(num.length()-i-1))
                return false;
        }
        
        return true;
        
    }
}
