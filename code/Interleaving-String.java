/**
 * Problem Statement: Interleaving String 
 * Link:https://oj.leetcode.com/problems/interleaving-string/
 * Time:500 ms
 * 
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */


public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        //special case
        if(len1 + len2 != len3) return false;
        if(len1==0) return s2.equals(s3);
        if(len2==0) return s1.equals(s3);
        
        //match[i][j]==true if s1[0..i-1] and s2[0..j-1] can interleaving s3[0..i+j-1]
        boolean[][] match = new boolean[len1+1][len2+1];
        
        //initialize
        match[0][0] = true;
        for(int i=1; i<=len1; i++){
            match[i][0] |= match[i-1][0];
            if(s1.charAt(i-1)!=s3.charAt(i-1))
                match[i][0] = false;
        }
        
        for(int j=1; j<=len2; j++){
            match[0][j] |= match[0][j-1];
            if(s2.charAt(j-1)!=s3.charAt(j-1))
                match[0][j] = false;
        }
        
        //dynamic compute match[i][j]
        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++)
                match[i][j] = (s1.charAt(i-1)==s3.charAt(i+j-1) && match[i-1][j] ||
                                s2.charAt(j-1)==s3.charAt(i+j-1) && match[i][j-1]);
        }
        
        return match[len1][len2];
    }
}