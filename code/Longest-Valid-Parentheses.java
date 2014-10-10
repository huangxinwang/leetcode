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