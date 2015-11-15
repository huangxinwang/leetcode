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

////////////////////////////////////////
// 2015/11/14
//Highlight: traverse from right to left seems more complicated
public class Solution {
    public int titleToNumber(String s) {
        
        int rnt = 0;
        int carry = 0;
        //unit
        int unit = 1;
        
        //add from right to left
        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            int sum = c - 'A'+1+carry;
            rnt = rnt + (sum%26)*unit;
            carry = sum/26;
            unit *= 26;
        }
        if(carry!=0){
            rnt = rnt + carry*unit;
        }
        return rnt;
    }
}

////////////////////////////////////////////
// 2015/11/14
// Highlight: try traverse from left to right
public class Solution {
    public int titleToNumber(String s) {
        int rnt = 0;
        for(int i=0; i<s.length(); i++){
            int val = s.charAt(i) - 'A' + 1;
            rnt = rnt*26 + val;
        }
        return rnt;
    }
}
