/**
 * Problem Statement: Evaluate Reverse Polish Notation
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. 
 * Each operand may be an integer or another expression.
 * 
 */


public class Solution {
    
    public int evalRPN(String[] tokens) {
        
        Patten p = new Patten("[\\d]+");
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<tokens; i++){
            Matcher m = p.matcher(tokens[i]);
            if(m.matches()){
                list.add(Integer.parse(tokens[i]));
            }else{
                int num1 = list.remove(list.size()-1);
                int num2 = list.remove(list.size()-1);
                int num3 = 0;
                switch(tokens[i]){
                    case '+':
                        num3 = num1 + num2;
                        break;
                    case '-':
                        num3 = num1 - num2;
                        break;
                    case '/';
                        num3 = num1/num2;
                        break;
                    case '*':
                        num3 = num1*num2;
                        break;
                }
                list.add(num3);
            }
        }
        
     return list(0);
     
    }
}