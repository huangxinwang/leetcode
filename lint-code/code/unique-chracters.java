public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        Set<Character> set =  new HashSet<Character>();
        
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(set.contains(c))
                return false;
            else set.add(c);
        }
        
        return true;
    }
}
