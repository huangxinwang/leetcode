/**
 * Problem Statement: Valid Number 
 * Link: https://oj.leetcode.com/problems/valid-number/
 * Time:
 * Hardness: **
 * 
 * Validate if a given string is numeric.
 */


public class Solution {
    public boolean isNumber(String s) {
        
        if(s==null || s.length()==0) return false;
        boolean space = false;
        boolean dot = false;
        boolean hasNum = false;
        boolean hasE = false;
        boolean numAfterE = false;
        boolean spaceAfterNum = false;
        boolean hasNeg = false;
        boolean hasPos = false;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c!=' ' &&  spaceAfterNum==true) return false;
            
            //case 1: number
            //record whether has num after e
            if(c>='0' && c<='9'){
                hasNum = true;
                if(hasE) numAfterE = true;
                continue;
            } 
            
            //case 2: .
            //if already has '.' or 'e', then invalid
            else if(c=='.'){
                if(dot==true || hasE==true) return false;
                dot = true;
                continue;
            }
            
            //case 3: e
            //if already has e, or have no number ahead, then invalid
            else if(c=='e'){
                if(hasE==true || hasNum==false) return false;
                hasE = true;
                continue;
            }
            
            //case4: ' '
            //record if this is space after non-space
            else if(c==' '){
                if(hasNum==true || dot==true || hasNeg==true || hasPos ==true){
                    spaceAfterNum = true;
                    continue;
                }
                continue;
            }
            
            //case 5: '-'
            //if has no number and dot ahead, then record hasNeg
            //if it not at head, then it is only valid after 'e'
            else if(c=='-'){
                if(hasNum==false && dot==false) {
                    hasNeg = true;
                    continue;
                }
                if(s.charAt(i-1)!='e') return false;
            }
            
            //case 6: '+'
            //similar to case 5
            else if(c=='+'){
                if(hasNum==false && dot==false && hasPos==false && hasNeg==false) {
                    hasPos = true;
                    continue;
                }
                if(s.charAt(i-1)!='e') return false;
            }
            
            //case 7: other
            else return false;
        }
        
        //has no number after 'e', invalid
        if(hasE==true && numAfterE==false) return false;
       
        //has no number, invalid
        if(hasNum==false) return false;
        
        return true;
    }
}