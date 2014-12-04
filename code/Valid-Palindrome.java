/**
 * Problem Statement: Valid Palindrome 
 * Link: https://oj.leetcode.com/problems/valid-palindrome/
 * Hardness: ***
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 */

//Time complexity O(n)
public class Solution {
    public boolean isPalindrome(String s) {
        
        if(s==null || s.length()==0 || s.length()==1) return true;
        
        int front = 0;
        int end = s.length()-1;
        //two pointers, one scan from front, one scan from end
        while(front < end){
            
            //front point advance until meet an alphanum
            char left = s.charAt(front);
            while(front<end && !(isAlphaNUm(left))){
                front++;
                left = s.charAt(front);
            }
            
            //end pointer advance in backward manner until meet an alphanum
            char right = s.charAt(end);
            while(front<end && !(isAlphaNUm(right))){
                end--;
                right = s.charAt(end);
            }
            
            //compare
            if(!isSame(left, right)) return false;
            front++;
            end--;
        }
        
        return true;
    }
    
    //decide if it is alpha num
    public boolean isAlphaNUm(char c){
        if(c>='a' && c<='z') return true;
        if(c>='A' && c<='Z') return true;
        if(c>='0' && c<='9') return true;
        return false;
    }
    
  
    //decide if two char is the same, ignore cases
    public boolean isSame(char left, char right){
        if(left>='A' && left <='Z') left = (char)(left-('Z'-'z'));
        if(right>='A' && right <='Z') right = (char)(right - ('Z' - 'z'));
        return left==right;
    }
}
