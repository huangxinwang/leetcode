/**
 * Problem Statement: Longest Valid Parentheses 
 * Link: https://oj.leetcode.com/problems/longest-valid-parentheses/
 * Time: 424 ms
 * Ref: http://shanjiaxin.blogspot.com/2014/04/longest-valid-parentheses-leetcode.html
 * 
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */


import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        
        //special case
        int len = s.length();
        if(len<=1) return 0;
        
        Stack<Integer> stk = new Stack<Integer>();
        //if stack is empty, keep record of the last valid start
        int start = 0;
        int maxLen = 0;
        
        for(int i=0; i<len; i++){
            if(s.charAt(i) == '(')
                stk.push(i);
            else{
                //if current char is ')' and stk is empty, then start a new valid string
                if(stk.isEmpty())
                    start = i+1;
                else{
                    //pop out the last '(' in the stack
                    stk.pop();
                    //if stk is empty, then the valid string start from last valid start
                    //if stk is not empty, then current valid string only from pop '(' to current ')'
                    //which is calculated using i-stk.peek()
                    maxLen = stk.isEmpty()? Math.max(maxLen, i-start+1): Math.max(maxLen, i - stk.peek());
                    
                }
            }
        }
        
        return maxLen;
    }
}


///////////////////////////////////////////////////////////////////////
//Round 2: 12/31/2014
public class Solution {
    public int longestValidParentheses(String s) {
        
        //I tried 2D dynamic programming, but time limit exceeds
        
        //Thus, I tried using stack, and only do one round traverse
        Stack<Integer> stack = new Stack<Integer>();
        int maxLen = 0;
        int start = 0;
        for(int i=0; i<s.length();i++){
            //push to stack
            if(s.charAt(i)=='(')
                stack.push(i);
            else{
                //current valid start point change to i+1
                if(stack.isEmpty()){
                    start = i+1;
                }
                else{
                    
                    stack.pop();
                    
                    //if after pop, there are no other element, then it means current valid start point is start
                    if(stack.size()==0)
                        maxLen = Math.max(maxLen, i-start+1);
                    //otherwise, the current valid point could be stack.peek()
                    else
                        maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        
        return maxLen;
    }
}



/////////////////////////////////////////////////////////////////////
//2015/11/01
// Highlight: stack, one time traverse, different from longest valid palindrome (continuous v.s. discontinuous)
public class Solution {
    public int longestValidParentheses(String s) {
        
        Stack<Integer> stack = new Stack<Integer>();
        int start = 0;
        int max = 0;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(i);
            }else{
                if(!stack.isEmpty()){
                    
                    stack.pop();
                    // if I replace "stack.size()==0" with stack.isEmpty(), then time limit exceeds
                    if(stack.size()==0){
                          //only when the stack size is zero can we sum up all the length between (Start, i)
                          // otherwise, we cannot ensure all the symbols between (Start, i) will be matched by ')'
                          max = Math.max(max, i-start+1);
                    }else{
                        max = Math.max(max, i-stack.peek());
                    }
                }else{
                    start = i+1;
                }
            }
        }
        
        return max;
    }
}
