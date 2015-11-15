/**
 * Problem Statement: Compare Version Numbers 
 * Link: https://oj.leetcode.com/problems/compare-version-numbers/
 * 
 */


public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int len = Math.max(arr1.length, arr2.length);
       
        
        int i=0;
        while(i<len){
                
                //pat the shorter one with 0
                int a1 = i<arr1.length?Integer.parseInt(arr1[i]) : 0;
                int a2 = i<arr2.length?Integer.parseInt(arr2[i]) : 0;
                if(a1>a2) return 1;
                if(a1<a2) return -1;
           
            i++;
        }
        
        return 0;
        
        
    }
}


///////////////////////////////////////////////////////////////////////
//2015/11/14
// Highlight: string split and compare
public class Solution {
    public int compareVersion(String version1, String version2) {
        
        //split strings
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        
        //compare each string, if not exist, use 0
        int i=0;
        for(; i<Math.max(str1.length, str2.length); i++){
            int val1 = i<str1.length? Integer.parseInt(str1[i]) : 0;
            int val2 = i<str2.length? Integer.parseInt(str2[i]) : 0;
            if(val1>val2) return 1;
            if(val1<val2) return -1;
        }

        return 0;
    }
}
