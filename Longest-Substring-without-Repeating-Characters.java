/**
 * Problem Statement:Longest Substring Without Repeating Characters
 * Link:https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 * Time：564 ms
 * Ref:http://answer.ninechapter.com/solutions/longest-substring-without-repeating-characters/
 * 
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        //special case
        if(s==null || s.length()==0) return 0;
        
        HashSet<Character> hs = new HashSet<Character>();
        int leftBound = 0; int max = 0;
        
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){
                //advance the leftBound until no repeted character contained in current hashset
                while(leftBound<i && s.charAt(i)!=s.charAt(leftBound)){
                    hs.remove(s.charAt(leftBound));
                    leftBound++;
                }
                leftBound++;
            }
            else{
                //update the max longest sequence without repeted characters
                hs.add(s.charAt(i));
                max = Math.max(max, i-leftBound+1);
            }
        }
        
        return max;
    }
}