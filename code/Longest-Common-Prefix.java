/**
 * Problem Statement: Longest Common Prefix 
 * Link: https://oj.leetcode.com/problems/longest-common-prefix/
 * Time: 544 ms
 * Hardness: **
 * 
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 */


public class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs.length==0) return "";
        
        return helper(strs, 0, strs.length-1);
    }
    
    //recursive find commonPrefix of two strings
    public String helper(String[] strs, int start, int end){
        if(start==end) return strs[start];
        if(start+1 == end) return commonPrefix(strs[start], strs[end]);
        int mid = (start+end)/2;
        //recursion
        return commonPrefix(helper(strs, start, mid), helper(strs, mid+1, end));
    }
    
    //find commonPrefix of two strings
    public String commonPrefix(String s1, String s2){
        int max = 0;
        for(int i=0; i<Math.min(s1.length(), s2.length()); i++){
            if(s1.charAt(i) == s2.charAt(i)) max++;
            else return s1.substring(0,max);
        }
        return s1.substring(0, max);
    }
    
    
}