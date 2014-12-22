/**
 * Problem Statement: Excel Sheet Column Title 
 * Hardness: **
 * Link: https://oj.leetcode.com/problems/excel-sheet-column-title/
 */

public class Solution {
    public String convertToTitle(int n) {
        String rnt = "";
        int remain = n;
        int result = 0;
        boolean flag = false;
        
        while(n>0){
            result = n%26;
            //need to disginuish cases in which result is 0
            if(result==0)
                n = n/26-1;
            else n = n/26;
            
            //apped related character to string
            if(result==0) rnt+="Z";
            else{
                 char c = (char)('A'+result-1);
                 rnt+=c;
            }
        }
        
        return new StringBuilder(rnt).reverse().toString();
    }
}
