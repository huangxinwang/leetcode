/**
 * Problem Statement: Excel Sheet Column Number 
 * Hardness: *
 * 
 */

public class Solution {
    public int titleToNumber(String s) {
        //traverse string
        int rnt = 0;
        for(int i=0; i<s.length(); i++){
            rnt = rnt*26+(int)(s.charAt(i)-'A')+1;
        }
        
        return rnt;
    }
}
