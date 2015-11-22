/**
* Problem Statement: Basic Calculator
*
*Implement a basic calculator to evaluate a simple expression string.
* 
*The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
*
* You may assume that the given expression is always valid.
* 
* Some examples:
* "1 + 1" = 2
* " 2-1 + 2 " = 3
* "(1+(4+5+2)-3)+(6+8)" = 23
*/

///////////////////////////////////////
// 2015/11/21
// Highlight: since there are only +,- operation, we can maintain a stack to keep track of the sign
public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(1);
        int rnt = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int num = c - '0';
                int j = i+1;
                while(j<s.length() && Character.isDigit(s.charAt(j))){
                    num = num*10 + (s.charAt(j)-'0');
                    j++;
                }
                rnt += stack.pop()*num;
                i = j-1;
            }else if(c==')'){
                stack.pop();
            }
            //maintain 1 or -1 in the stack
            else if(c=='+' || c=='('){
                stack.push(stack.peek());
            }else if(c=='-'){
                stack.push(-1*stack.peek());
            }
        }
        
        return rnt;
    }
}
