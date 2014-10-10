/**
 * Problem Statement: Scramble String 
 * Link: https://oj.leetcode.com/problems/scramble-string/
 * Time: 456 ms
 * 
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */


public class Solution {
    public boolean isScramble(String s1, String s2) {
        
        //special case
        if(s1.length() != s2.length()) return false;
        
        
        //canScramble[i][j][m] is true if s1(i..i+m-1) and s2(j..j+m-1) are scramble
        int len = s1.length();
        boolean[][][] canScramble = new boolean[len][len][len+1];
        
        //initialize
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++)
                if(s1.charAt(i) == s2.charAt(j))
                    canScramble[i][j][1] = true;
        }
        
        //dynamic programming build the table
        //time O(n^4)
        for(int m=2; m<=len; m++){
            for(int i=0; i<=len-m; i++){
                for(int j=0; j<=len-m; j++){
                    //string with length m could be split into k and m-k substrings
                    for(int k=1; k<=m-1; k++)
                        canScramble[i][j][m] |= (canScramble[i][j][k] && canScramble[i+k][j+k][m-k]
                                               || (canScramble[i][j+m-k][k] && canScramble[i+k][j][m-k]));
                }
            }
        }
        
        return canScramble[0][0][len];
    }
}