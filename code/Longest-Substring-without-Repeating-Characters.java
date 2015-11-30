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


///////////////////////////////////////////////////
//Round 2: 1/4/2015
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        int start = 0;
        int max = 0;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            //calculate length
            //advance front of window to contain no duplicate characters
            if(map.containsKey(c)){
                int curr = i-start;
                max = max>curr ? max : curr;
                while(start<i && s.charAt(start)!=c){
                    map.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
            else{
                map.put(c,1);
            }
        }
        
        max = max >(s.length()-start) ? max: (s.length()-start);
        
        return max;
    }
}


////////////////////////////////////////////////////////////////////
//11/29/2015
//Time complexity: best O(n)； worst O(n)? because one element will only be scanned at most twice??
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        
        Set<Character> map = new HashSet<Character>();
        int start = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            //if c is already in the set, remove all the chars upto the first c (inclusive)
            if(map.contains(c)){
                int currlen = i-start;
                if(max<currlen) max = currlen;
                while(s.charAt(start)!=c){
                    map.remove(s.charAt(start));
                    start++;
                }
                map.remove(s.charAt(start));
                start++;
            }
            map.add(c);
        }
        
        if(max<s.length()-start) max = s.length()-start;
        
        return max;
    }
}
