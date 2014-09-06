/**
 * Problem Statement: https://oj.leetcode.com/problems/wildcard-matching/
 * Time: 680 ms
 * Link: https://oj.leetcode.com/problems/wildcard-matching/
 * Ref: http://yucoding.blogspot.com/2013/02/leetcode-question-123-wildcard-matching.html
 * Hardness: *****
 * 
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 */



public class Solution {
    public boolean isMatch(String s, String p) {
        
        int sRecord = -1;
        int pRecord = -1;
        int sIndex = 0;
        int pIndex = 0;
        
        //scan s and p string until reach the end of s string
        while(sIndex<s.length()){
            
            if(pIndex<p.length()){
                //matched with char or '?'
                if(s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?') {
                    sIndex++;
                    pIndex++;
                    continue;
                }
                //matched with '*, record the matched places in sRecord and pRecord
                if(p.charAt(pIndex) == '*'){
                    sRecord = sIndex;
                    pRecord = pIndex;
                    pIndex++;
                    continue;
                }
            }
            
            //if not matched, roll back to last record places
            if(pRecord != -1){
                sIndex = ++sRecord;
                pIndex = pRecord+1;
                continue;
            }
            return false;
        }
        
        //process result
        if(sIndex != s.length()) return false;
        
        while(pIndex<p.length()){
            if(p.charAt(pIndex) != '*')
                return false;
            pIndex++;
        }
        
        return true;
    }
}