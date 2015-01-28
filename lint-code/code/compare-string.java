public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i=0; i<A.length(); i++){
            Character c = new Character(A.charAt(i));
            if(map.containsKey(c))
                map.put(c, map.get(c)+1);
            else map.put(c,1);
        }
        
        for(int i=0; i<B.length(); i++){
            Character c = new Character(B.charAt(i));
            if(!map.containsKey(c)) return false;
            else{
                int count = map.get(c);
                count--;
                if(count==0) map.remove(c);
                else map.put(c, count);
            }
        }
        
        return true;
    }
}
