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