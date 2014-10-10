/**
 * Problem Statement: Distinct Subsequences
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by 
 * deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit" Return 3.
 */
 
 /**
  * Reference: http://blog.csdn.net/sbitswc/article/details/28488911
  */

public class Solution {
    public int numDistinct(String S, String T) {
        
        int s1 = S.length();
        int t1 = T.length();
        
        int[][] num = new int[t1+1][s1+1];
        for(int i=0; i<=s1; i++) 
            num[0][i] = 1;
        for(int j=1; j<=t1; j++)
            num[j][0] = 0;
           
        //dynamic programming 
        for(int i=1; i<=t1;i++)
        {
            for(int j=1; j<=s1; j++){
                if(i>j) {
                    num[i][j]=0;
                    continue;
                }
                if(T.charAt(i-1)!=S.charAt(j-1))
                    num[i][j] = num[i][j-1];
                else
                    num[i][j] = num[i][j-1] + num[i-1][j-1];
                    
            }
        }
        
        return num[t1][s1];
        
    }
}