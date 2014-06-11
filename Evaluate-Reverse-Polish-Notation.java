/**
 * Problem Statement: Evaluate Reverse Polish Notation
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. 
 * Each operand may be an integer or another expression.
 * 
 */

import java.util.regex.*;

public class Solution {
    
    public int evalRPN(String[] tokens) {
        
        Pattern  p = Pattern.compile("[\\d]+");
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<tokens.length; i++){
			
			//judge if it is an integer or symbol
            Matcher m = p.matcher(tokens[i]);
            if(m.matches()){
                list.add(Integer.parseInt(tokens[i]));
            }else{
				//if it is symbol, pop out numbers for calculation
				//then push back the results
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