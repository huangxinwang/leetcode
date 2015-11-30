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


////////////////////////////////////////////////////////
// 2015/11/30
// Highlight: use a hashmap to keep track of the value list of a given string
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        return help(input, map);
    }
    
    //use a hashmap to maintain the results of a given string to avoid repeated calculation
    public List<Integer> help(String input, Map<String, List<Integer>> map){
        List<Integer> rnt = new ArrayList<Integer>();
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(c!='+' && c!='-' && c!='*') continue;
            String left = input.substring(0,i);
            String right = input.substring(i+1, input.length());
            List<Integer> list1 = map.containsKey(left)? map.get(left): help(left, map);
            List<Integer> list2 = map.containsKey(right)? map.get(right): help(right, map);
            
            for(Integer int1 : list1){
                for(Integer int2 : list2){
                    if(c=='+'){
                        rnt.add(int1+int2);
                    }
                    else if(c=='-'){
                        rnt.add(int1-int2);
                    }
                    else{
                        rnt.add(int1*int2);
                    }
                }
            }
            
            
        }
        
        if(rnt.size()==0){
                rnt.add(Integer.parseInt(input));
        }
        map.put(input, rnt);
        return rnt;
    }
}
