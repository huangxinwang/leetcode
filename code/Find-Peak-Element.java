/**
 * Problem Statement: Find Peak Element
 * Link: https://oj.leetcode.com/problems/find-peak-element/
 * 
 */

public class Solution {
    public int findPeakElement(int[] num) {
        
        //special conditions
        if(num.length==1) return 0;
        if(num[0]>num[1]) return 0;
        if(num[num.length-1]>num[num.length-2]) return num.length-1;
        
        //traverse array
        for(int i=1; i<num.length-1; i++){
            if(num[i-1]<num[i] && num[i]>num[i+1]) 
                return i;
        }
        
        return 0;
    }
}
