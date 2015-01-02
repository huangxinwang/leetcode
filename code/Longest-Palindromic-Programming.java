/**
 * Problem Statement: Longest Palindromic Substring 
 * Link: https://oj.leetcode.com/problems/longest-palindromic-substring/
 * Time: 876 ms
 * 
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */



public class Solution {
    public String longestPalindrome(String s) {
        
        int len = s.length();
        if(len<=1) return s;
        //table[i,j] is true if s[i..j] is string
        boolean[][] table = new boolean[len][len];
        
        int maxStart = 0;
        int maxLen = 1;
        
        //initial table
        for(int i=0; i<len; i++)
            table[i][i] = true;
        
        for(int i=0; i<len-1; i++){
            table[i][i+1] = (s.charAt(i) == s.charAt(i+1));
            if(s.charAt(i) == s.charAt(i+1)){
                maxStart = i;
                maxLen = 2;
            }
        }
        //length should at least be 3, otherwise table[i+1][j-1] will have index problem
        //dynamic programming build table 
        for(int length = 3; length<=len; length++){
            for(int i=0; i<len-length+1; i++){
                int j = i+length-1;
                table[i][j] = (s.charAt(i) == s.charAt(j)) && (table[i+1][j-1]);
                if(length > maxLen && table[i][j]){
                    maxLen = length;
                    maxStart = i;
                }
            }
        }
        
        return s.substring(maxStart, maxStart+maxLen);
        
    }
}


////////////////////////////////////////////////////////////
//Round 2: 1/1/2015
public class Solution {
    public String longestPalindrome(String s) {
        
        int len = s.length();
        boolean[][] palin = new boolean[len][len];
        
        int maxLen = 1;
        int maxStart = 0;
        
        //length=1
        for(int i=0; i<len; i++)
            palin[i][i] = true;
          
        //length=2  
        for(int i=0; i<len-1; i++){
            if(s.charAt(i)==s.charAt(i+1)){
                if(maxLen<2){
                    maxLen = 2;
                    maxStart = i;
                }
                palin[i][i+1] = true;
            }
        }
        
        
       //different from the one that only return maxLength
       //we build the table by considering different length of the palindrome
       for(int step=3; step<=len; step++){
           for(int i=0; i<=len-step; i++){
               int j = i+step-1;
               if(s.charAt(i)==s.charAt(j) && palin[i+1][j-1]){
                   palin[i][j] = true;
                   if(step>maxLen){
                       maxLen = step;
                       maxStart = i;
                   }
               }
           }
       }
        
        return s.substring(maxStart, maxStart+maxLen);
    }
}
