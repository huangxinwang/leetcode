/**
 * Problem Statement: Valid Parentheses 
 * Link: https://oj.leetcode.com/problems/valid-parentheses/
 * Time: 360 ms
 * Hardness: *
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * 
 */


public class Solution {
    public boolean isValid(String s) {
       
       //use a stack to store the left-side symbols
       Stack<Character> stk = new Stack<Character>();
       
       for(int i=0; i<s.length(); i++){
           char c = s.charAt(i);
           if(c=='(' || c=='{' || c=='[')
                stk.push(c);
           //if current symbol is right side, then check the top elements in the stack
           else if(c==')' || c=='}' || c==']'){
               if(stk.isEmpty()) return false;
               char curr = stk.pop();
               if(c==')' && curr!='(') return false;
               if(c==']' && curr!='[') return false;
               if(c=='}' && curr!='{') return false;
           }
       }
       
       //all left-side symbols should be matched and poped, otherwise, it is invalid
       return stk.isEmpty()? true : false;
       
    }
}

//////////////////////////////////////////////
//Round 2: 1/1/2015
public class Solution {
    public boolean isValid(String s) {
        
        Stack<String> stack = new Stack<String>();
        
        //push leftside, when meet rightside, pop from stack to see leftside match
        for(int i=0; i<s.length(); i++){
            String c = s.substring(i,i+1);
            switch(c){
                case "(":
                    stack.push(c);
                    break;
                case "{":
                    stack.push(c);
                    break;
                case "[":
                    stack.push(c);
                    break;
                case ")":
                    if(stack.isEmpty()) return false;
                    if(!stack.pop().equals("(")) return false;
                    break;
                case "}":
                    if(stack.isEmpty()) return false;
                    if(!stack.pop().equals("{")) return false;
                    break;
                case "]":
                    if(stack.isEmpty()) return false;
                    if(!stack.pop().equals("[")) return false;
                    break;
            }
        }
        
        return stack.isEmpty();
    }
}


/////////////////////////////////////////////////////////////////////////////////////
// 2015/10/25
// Highlight: stack operation
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            //if it is left side, push
            if(c=='(' || c=='[' || c=='{')
                stack.push(c);
            // otherwise, pop if the element on top of the stack is correct
            else{
                if(stack.isEmpty())
                    return false;
                char peekc = stack.peek();
                if( (c==')' && peekc=='(') || (c==']' && peekc =='[') || (c=='}' && peekc =='{')){
                    stack.pop();
                }else{
                    return false;
                }
                
            }
        }
        
        if(stack.isEmpty()) return true;
        return false;
    }
}
