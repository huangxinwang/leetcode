/**
 * Problem Statement: String to Integer (atoi) 
 * Link:https://oj.leetcode.com/problems/string-to-integer-atoi/
 * Time: 456 ms
 * 
 * Implement atoi to convert a string to an integer.
 */

public class Solution {
    public int atoi(String str) {
        
        long rnt = 0;
        int pos = 0;
        int neg = 0;
        int idx = 0;
        int space = 0;
        
        //traverse each characeter
        while(idx < str.length()){
            
            char curr = str.charAt(idx);
            if(curr == '\0') break;
            else if(curr == '+') pos++;
            else if(curr == '-') neg++;
            else if(curr>='0' && curr<='9'){
                rnt = rnt*10 + Character.getNumericValue(curr);  
            }
            //space after any number, positive symbol, negative symbol is not allowed
            else if(curr == ' ') { if(pos>0 || neg>0 || rnt>0) break;}
            else break;
            idx++;
        }
        
        //if more than one symbol, illegal, return 0
        if(pos + neg > 1) return 0;
        
        if(neg==1) rnt = -rnt;
        
        //if exceed MIN or MAX, set as MIN or MAX
        if(rnt>Integer.MAX_VALUE) rnt = Integer.MAX_VALUE;
        if(rnt<Integer.MIN_VALUE) rnt = Integer.MIN_VALUE;
        
        return (int)rnt;
    }
    
}