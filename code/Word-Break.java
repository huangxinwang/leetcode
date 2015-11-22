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


///////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 11/29/2014
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        
        //dynamic programming
        //f[i] denote if s[0..i-1] can be broke
        boolean[] f = new boolean[s.length()+1];
        f[0] = true;
        
        //dynamic programming update f value
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                String word = s.substring(j, i);
                if(f[j] && dict.contains(word)){
                    f[i]=true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}


/////////////////////////////////////////////
// 2015/11/12
// Highlight: dfs, exceed time limit
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s==null || s.length()==0) return true;
        return dfs(s, 0, wordDict);
    }
    
    public boolean dfs(String s, int idx, Set<String> wordDict){
        if(idx>=s.length()) return true;
        for(int i = idx; i<s.length(); i++){
            String curr = s.substring(idx, i+1);
            if(wordDict.contains(curr)){
                if(dfs(s, i+1, wordDict)) return true;
            }
        }
        return false;
    }
}
