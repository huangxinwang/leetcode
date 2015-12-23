// Remove duplicate letters

/////////////////////////////////////////
// 2015/12/22
// Highlight: stack, logic
// Time: O(n)


public class Solution {
    public String removeDuplicateLetters(String s) {
        HashSet<Character> set = new HashSet<Character>();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        //maintains counts of each character
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else map.put(c,1);
        }
        
        //for each character c
        //1. reduce its count
        //2. push top elements from stack, if it is larger than c, and will appear later
        //3. add c to the stack
        //4. the characters remaining in the stack is the result
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c,map.get(c)-1);
            if(set.contains(c)) continue;
            
            //step 2
            while(!stack.isEmpty() && stack.peek()>c && map.get(stack.peek())>=1){
                set.remove(stack.pop());
            }
            
            //step 3
            stack.add(c);
            set.add(c);
        }
        
        //step 4
        String rnt = new String();
        for(int i=0; i<stack.size(); i++){
            rnt += stack.get(i);
        }
        
        return rnt;
    }
}
