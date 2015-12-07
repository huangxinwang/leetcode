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


/////////////////////////////////////////////////////////
// 2015/12/07
// Highlight: use a stack to keep track of characters
// Time: O(n)
// Space: O(n)

public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            //left-side: push to stack
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }
            //righ-side: check if match
            else{
                if(stack.isEmpty()) return false;
                if(c==')' && stack.pop()!='(') return false;
                else if(c==']' && stack.pop()!='[') return false;
                else if(c=='}' && stack.pop()!='{') return false;
            }
        }
        
        return stack.isEmpty();
    }
}
