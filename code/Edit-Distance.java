/**
 * Problem Statement: Edit Distance
 * Link: https://oj.leetcode.com/problems/edit-distance/
 * 
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
 * (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */


public class Solution {
    public int minDistance(String word1, String word2) {
        
        int len1 = word1.length();
        int len2 = word2.length();
        
        //the edit distance of word1[0..i] and word2[0..j]
        int[][] C = new int[len1+1][len2+1];
        
        //initialize
        C[0][0] = 0;
        for(int i=1; i<=len1; i++)
            C[i][0] = i;
        for(int j=1; j<=len2; j++)
            C[0][j] = j;
            
        //dynamic programming find the length of the longest common sequence
        for(int i=1; i<=len1; i++)
            for(int j=1; j<=len2; j++)
            if(word1.charAt(i-1)==word2.charAt(j-1)) C[i][j] = C[i-1][j-1];
            else
            { 
                C[i][j] = Math.min(C[i-1][j], C[i][j-1]) + 1;
                C[i][j] = Math.min(C[i][j], C[i-1][j-1]+1);
             }
        
        return C[len1][len2];
    }
}