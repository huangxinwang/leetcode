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


//////////////////////////////////////////////////////
// 2015/10/30
// Highlight: bruteforce
// Time complexity: O(m*n)
public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0 && haystack!=null) return 0;
        int validLen = 0;
        int currIdx = 0;
        for(int i=0; i<haystack.length(); i++){
            char hc = haystack.charAt(i);
            char nc = needle.charAt(currIdx);
            // if match
            if(hc==nc){
                currIdx++;
                validLen++;
                if(validLen==needle.length())
                    return i-validLen+1;
            }
            // if not match
            else{
                // rollback i
                i = i-validLen;
                validLen = 0;
                currIdx = 0;
            }
        }
        return -1;
    }
}
