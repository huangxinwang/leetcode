/**
* Problem Statement: Different Ways to Add Parentheses
*
*/


////////////////////////////////////////////
// 2015/11/30
// Highlight: for each operation sign, there are vairous ways to get its left and right parts
//Ref: http://codechen.blogspot.com/2015/07/leetcode-different-ways-to-add.html
// Time complexity: O(n!) ?
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> rnt = new ArrayList<Integer>();
        
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(c!='+' && c!='-' &&  c!='*') continue;
            
            //for each operation, the left and right part can be seperated
            List<Integer> list1 = diffWaysToCompute(input.substring(0,i));
            List<Integer> list2 = diffWaysToCompute(input.substring(i+1,input.length()));
            for(Integer int1 : list1){
                for(Integer int2: list2){
                    if(c=='+'){
                        rnt.add(int1+int2);
                    }else if(c=='-'){
                        rnt.add(int1-int2);
                    }else{
                        rnt.add(int1*int2);
                    }
                }
            }
        }
        
        if(rnt.size()==0){
            rnt.add(Integer.parseInt(input));
        }
        
        return rnt;
    }
}
