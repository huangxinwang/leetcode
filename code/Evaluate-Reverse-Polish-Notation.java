/**
 * Problem Statement: Evaluate Reverse Polish Notation
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. 
 * Each operand may be an integer or another expression.
 * 
 */

//import in order to use regex
import java.util.regex.*;

public class Solution {
    
    public int evalRPN(String[] tokens) {
        
        //match both positive and negative integers
        Pattern  p = Pattern.compile("[-+]?[\\d]+");
        //use list as stack(LIFO order)
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<tokens.length; i++){
            //judge if it is a number or symbol
            Matcher m = p.matcher(tokens[i]);
            //if number
            if(m.matches()){
                list.add(Integer.parseInt(tokens[i]));
            }
            //if symbol
            else{
                
                //do calculation using last two numbers(pop out)
                //then push the calculation result to list
                int num2 = list.remove(list.size()-1);
                int num1 = list.remove(list.size()-1);
                int num3 = 0;
                switch(tokens[i]){
                    case "+":
                        num3 = num1 + num2;
                        break;
                    case "-":
                        num3 = num1 - num2;
                        break;
                    case "/":
                        num3 = num1/num2;
                        break;
                    case "*":
                        num3 = num1*num2;
                        break;
                }
                list.add(num3);
            }
        }
        
     return list.get(0);
     
    }
}



/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 11/28/2014
//Time complexity: O(1)

public class Solution {
    
    public int evalRPN(String[] tokens) {
        
        //maintain a stack to process each tokens
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<tokens.length; i++){
            
            //if current token is operator, then pop numbers from stack to do calculation, and push the result to the stack
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int num2 = (int)stack.pop();
                int num1 = (int)stack.pop();
                int result = 0;
                switch(tokens[i]){
                    case "+": result = num1+num2; break;
                    case "-": result = num1-num2; break;
                    case "*": result = num1 * num2; break;
                    case "/": result = num1/num2; break;
                }
                stack.push(result);
            }
            //else just push the number to the stack
            else{
                int curr = Integer.parseInt(tokens[i]);
                stack.push(curr);
            }
        }
        
        //return final result
        return (int)stack.pop();
    }
}


//////////////////////////////////////////////////////////////////
// 2015/11/14
// Highlight: stack
public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<tokens.length; i++){
            String str = tokens[i];
            if(str.equals("+")){
                Integer i1 = stack.pop();
                Integer i2 = stack.pop();
                Integer i3 = i2 + i1;
                stack.push(i3);
            }
            else if(str.equals("/")){
                Integer i1 = stack.pop();
                Integer i2 = stack.pop();
                Integer i3 = i2 / i1;
                stack.push(i3);
            }
            else if(str.equals("*")){
                Integer i1 = stack.pop();
                Integer i2 = stack.pop();
                Integer i3 = i2 * i1;
                stack.push(i3);
            }
            else if(str.equals("-")){
                Integer i1 = stack.pop();
                Integer i2 = stack.pop();
                Integer i3 = i2 - i1;
                stack.push(i3);
            }else{
                Integer i3 = Integer.parseInt(str);
                stack.push(i3);
            }
        }
        
        return stack.pop();
    }
}
