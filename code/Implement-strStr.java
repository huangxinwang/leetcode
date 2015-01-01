/**
 * Problem Statement: implement strStr()
 * Link:https://oj.leetcode.com/problems/implement-strstr/
 * Time:448 ms
 * Comment: It would better to use KMP.
 * 
 * Implement strStr().Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 */



public class Solution {
    public String strStr(String haystack, String needle) {
        
        //special case
        if(haystack==null || needle==null) return null;
        
        //naive forloop search
        for(int i= 0; i<haystack.length()-needle.length()+1; i++){
            
            int j = 0 ;
            //not found
            for(; j<needle.length(); j++){
                if(haystack.charAt(i+j) != needle.charAt(j))
                    break;
            }
            
            //found
            if(j == needle.length())
                return haystack.substring(i);
        }
        
        return null;
    }
}

////////////////////////////////////////////////
//Round 2: 12/31/2014
//complexity O(m*n)
//better solution: KMP
public class Solution {
    public int strStr(String haystack, String needle) {
        
        for(int i=0; i<=haystack.length()-needle.length(); i++){
            int j=0;
            for(; j<needle.length(); j++){
                if(haystack.charAt(i+j)!=needle.charAt(j))
                    break;
            }
            
            if(j==needle.length())
                return i;
        }
        return -1;
    }
}
