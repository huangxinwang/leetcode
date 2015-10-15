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


/////////////////////////////////////////////////////////
//Round 2: 1/7/2015
//similar merge k-sorted list

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs.length==0) return new String();
        return helper(strs, 0, strs.length-1);
    }
    
    public String helper(String[] strs, int start, int end){
        if(start==end) return strs[start];
        if(start+1 == end) return commonPrefix(strs[start], strs[end]);
        int mid = (start+end)/2;
        //recursive using helper to get string
        return commonPrefix(helper(strs, start, mid), helper(strs, mid+1, end));
    }
    
    //find commonprefix of two string
    public String commonPrefix(String s1, String s2){
        int len = 0;
        for(int i=0; i<Math.min(s1.length(), s2.length()); i++){
            if(s1.charAt(i) == s2.charAt(i)) len++;
            else return s1.substring(0,len);
        }
        
        return s1.substring(0,len);
    }
}


//////////////////////////////////////////
//2015-10-15 
//Highlight: assume common prefix has length k, then it takes time k*n
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs ==null || strs.length==0) return new String();
        int idx = 0;
        boolean error = false;
        
        //compare current char of each string
        while(true){
            if(strs[0].length() < (idx+1)) {error= true; break;}
            char curr = strs[0].charAt(idx);
            for(int i=1; i<strs.length; i++){
                if(strs[i].length()<(idx+1)) {error= true; break;}
                char other = strs[i].charAt(idx);
                if(other!=curr) {error= true; break;}
            }
            if(error) break;
            idx++;
        }
        
        return strs[0].substring(0,idx);
       
    }
}
