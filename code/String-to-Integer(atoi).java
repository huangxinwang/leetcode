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


///////////////////////////////////////////////////////////
//round 2: 1/3/2015
public class Solution {
    public int atoi(String str) {
        
        long rnt = 0;
        int pos = 0;
        int neg = 0;
        int idx = 0;
        int validbit = 0;
        
        while(idx<str.length()){
            char c = str.charAt(idx);
            if(c=='\0') break;
            else if(c=='+') pos++;
            else if(c=='-') neg++;
            else if(c>='0' && c<='9'){ 
                rnt = 10*rnt + (c-'0');
                validbit++;
            }
            else if(c==' ') {if(neg>0 || pos>0 ||rnt>0) break;}
            else break;
            
            idx++;
            //avoid being larger than long
            if(validbit>12) break;
            
        }
        
        if(pos+neg>1) return 0;
        if(neg==1) rnt = -rnt;
        
        if(rnt>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(rnt<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        
        return (int)rnt;
    }
}


////////////////////////////////////////////////////////////
// 10/09/2015
// Highlight: corner case
public class Solution {
    public int myAtoi(String str) {
        if(str==null || str.length()==0) return 0;
        boolean positive = true;
        boolean symbol = false;
        int idx = 0;
        
        //preprocessing
        while(true){
            char c = str.charAt(idx);
            if(c=='-'){
                if(symbol) return 0;
                positive = positive==true? false: true;
            }else if(c=='+'){
                if(symbol) return 0;
            }else if(c==' '){
                if(symbol) return 0;
            }else break;
            
            if(c=='-' || c=='+'){
                if(symbol) return 0;
                symbol = true;
            }
            idx++;
        }
       
        //parse string to int, note range
        long rnt = 0; 
        while(idx<str.length()){
            char c = str.charAt(idx);
            if(c<'0' || c>'9' ||c==' '||c=='+'||c=='-') break;
            rnt = rnt*10 + (c-'0');
            idx++;
            if(rnt<Integer.MIN_VALUE || rnt>Integer.MAX_VALUE) break;
        }
        
        //process symbol and value range
        if(!positive) rnt = -rnt;
        if(rnt<Integer.MIN_VALUE) rnt = Integer.MIN_VALUE;
        else if(rnt>Integer.MAX_VALUE) rnt = Integer.MAX_VALUE;
       
        return (int)rnt;
    }
}
