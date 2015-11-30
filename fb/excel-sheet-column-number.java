/**
* Problem Statement: Excel Sheet Column Number
* Ref: https://leetcode.com/problems/excel-sheet-column-number/
*/

public class Solution {
    public int titleToNumber(String s) {
        int rnt = 0;
        for(int i=0; i<s.length(); i++){
            int val = (int)(s.charAt(i)-'A'+1);
            rnt = rnt*26 + val;
        }
        return rnt;
    }
}
