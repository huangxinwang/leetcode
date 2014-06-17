/**
 * Problem Statement: Word Break 
 * Given a string s and a dictionary of words dict, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 */


public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        
        int length = s.length();
        
        //dynamic table
        //dp[i]=true indicates s.substring(0,i) can be segmented into space-seperated sequence
        boolean[] dp = new boolean[length+1];
        
        dp[0] = true;
        
        //dynamic build table dp[i] 
        for(int i=1; i<=length; i++){
            
            for(int j=i-1; j>=0; j--){
                //the main trick for dynamic programming
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        
        //result
        return dp[length];
    }
}