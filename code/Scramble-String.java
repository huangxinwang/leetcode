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

///////////////////////////////////////////////////////////////////////////////////
//Round 2: 12/19/2014
public class Solution {
    public boolean isScramble(String s1, String s2) {
        
        int len = s1.length();
        if(len != s2.length()) return false;
        
        //whether s1[0..i] s2[0..j] is scramble
        boolean[][][] match = new boolean[len][len][len+1];
        
        //initialize
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++)
                match[i][j][1] = s1.charAt(i)==s2.charAt(j);
        }
        match[0][0][0] = true;
       
         
        //dynamic programming build the table
        for(int m=2; m<=len; m++){
                for(int k=1; k<m; k++){
                          for(int i=0; i<=len-m; i++){
                                for(int j=0; j<=len-m; j++){
                                //the second term is inversed (e.g., ab and ba)
                                match[i][j][m] |= (match[i][j][k] && match[i+k][j+k][m-k]) || (match[i][j+m-k][k] && match[i+k][j][m-k]);
                    }
                }
            }
        }
        
        return match[0][0][len];
    }
}


/////////////////////////////////////////////////////
//2015/11/18
// Highlight: dynamic programming, a[i][j][len] indicates whether str1[i..i+len] str2[j..j+len] scramble
public class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if(n!=s2.length()) return false;
        boolean[][][] scramble = new boolean[n][n][n+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(s1.charAt(i)==s2.charAt(j))
                    scramble[i][j][1] = true;
            }
        }
        
        //Base case
        scramble[0][0][0] = true;
        
        for(int len=2; len<=n; len++){
            for(int m = 1; m<len; m++){
            for(int i=0; i<=n-len; i++){
                for(int j=0; j<=n-len; j++){
                    //Case 1: ab with ab
                    //Case 2: ab with ba
                    scramble[i][j][len] |= (scramble[i][j][m] && scramble[i+m][j+m][len-m]) 
                                           || (scramble[i][j+len-m][m] && scramble[i+m][j][len-m]);
                }
            }
            }
        }
        
        return scramble[0][0][n];
    }
}
