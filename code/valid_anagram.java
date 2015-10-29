


// 2015/10/29
// Highlight: hashmap
public class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
            }else map.put(c, map.get(c)+1);
        }
        
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            if(!map.containsKey(c)) return false;
            else map.put(c, map.get(c)-1);
        }
        
        //check if map contains no elements
        for(Character key: map.keySet()){
            if(map.get(key)!=0) return false;
        }
        return true;
    }
}
