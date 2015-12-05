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

/////////////////////////////////////////////////////////////////////////////////////////////
// 2015/12/04
// Highlight: automata
public class Solution {
    
     
    enum InputType{
        INVALID, // 0 Include: Alphas, '(', '&' ans so on  
        SPACE, // 1  
        SIGN, // 2 '+','-' 
        DIGIT, // 3 numbers  
        DOT, // 4 '.'  
        EXPONENT, // 5 'e' 'E'  
    }
        
    public boolean isNumber(String s) {
       
        
        int[][] transTable = new int[][]{  
        //0INVA,1SPA,2SIG,3DI,4DO,5E  
            {-1,  0,  3,  1,  2, -1},//0初始无输入或者只有space的状态  
            {-1,  8, -1,  1,  4,  5},//1输入了数字之后的状态  
            {-1, -1, -1,  4, -1, -1},//2前面无数字，只输入了Dot的状态  
            {-1, -1, -1,  1,  2, -1},//3输入了符号状态  
            {-1,  8, -1,  4, -1,  5},//4前面有数字和有dot的状态  
            {-1, -1,  6,  7, -1, -1},//5'e' or 'E'输入后的状态  
            {-1, -1, -1,  7, -1, -1},//6输入e之后输入Sign的状态  
            {-1,  8, -1,  7, -1, -1},//7输入e后输入数字的状态  
            {-1,  8, -1, -1, -1, -1}//8前面有有效数输入之后，输入space的状态  
        };
        
        int state = 0;
        int i = 0;
        while(i<s.length()){
            InputType input = InputType.INVALID;
            char c = s.charAt(i);
            if(c == ' ') input = InputType.SPACE;
            else if(c == '.') input = InputType.DOT;
            else if(c == '+' || c == '-') input = InputType.SIGN;
            else if(c == 'e' || c =='E') input = InputType.EXPONENT;
            else if(c>= '0' && c<='9') input = InputType.DIGIT;
            state = transTable[state][input.ordinal()];
            if(state == -1) return false;
            i++;
        }
        
        return state ==1 || state ==4 || state == 7  || state == 8;
        
    }
}
