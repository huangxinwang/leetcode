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

////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 12/23/2014
public class Solution {
    public int numDistinct(String S, String T) {
        
        //dynamic programming
        //num[i][j] means the number of match of string S[0...i], T[0..j]
        int[][] num = new int[S.length()+1][T.length()+1];
        
        //initialization
        for(int i=0; i<=S.length(); i++){
            num[i][0] = 1;
        }
        
        for(int j=0; j<T.length(); j++){ 
            for(int i=0; i<S.length(); i++)
           {
               if(j>i){
                   continue;
               }
                if(S.charAt(i) == T.charAt(j)){
                    //if current char equal, then the number of match of (i+1)(j+1) 
                    //is the sum of the match of(i)(j) and the match of (i)(j+1)
                    num[i+1][j+1] = num[i][j] + num[i][j+1];
                }
                else
                    //otherwise, it is the same as if (i)character is not scaned
                    num[i+1][j+1] = num[i][j+1];
            }
        }
        
        return num[S.length()][T.length()];
    }
}

//////////////////////////////////////////////////////
// 2015/11/18
// Highlight: dfs, timeout!
public class Solution {
    public int numDistinct(String s, String t) {
        int sidx = 0;
        int tidx = 0;
        int[] count = new int[1];
        dfs(sidx, tidx, count, s, t);
        return count[0];
    }
    
    public void dfs(int sidx, int tidx, int[] count, String s, String t){
        if(tidx>=t.length()){
            count[0]++;
            return;
        }
        if(sidx >= s.length()) return;
        
        for(int i = sidx; i<s.length(); i++){
            if(s.charAt(i)==t.charAt(tidx)){
                dfs(i+1, tidx+1, count, s, t);
            }
        }
    }
}
