/**
* Problem Statement: Isomorphic Strings
*
*Given two strings s and t, determine if they are isomorphic.
*
*Two strings are isomorphic if the characters in s can be replaced to get t.
*
*All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters *may map to the same character but a character may map to itself.
*
*/


///////////////////////////////////////
// 2015/12/04
// Highlight: hashmap
//Time complexity: O(n)
//Space complexity: O(2n)

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s==null) return t==null;
        if(s.length()!=t.length()) return false;
        HashMap<Character, Integer> smap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tmap = new HashMap<Character, Integer>();
        
        for(int i=0; i<s.length(); i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            
            //If s has
            if(smap.containsKey(sc)){
                int sidx = smap.get(sc);
                //t must has
                if(!tmap.containsKey(tc)) return false;
                //and must be the same
                if(t.charAt(sidx)!= tc) return false;
            }
            //If s has not
            else{
                //t cannot have
                if(tmap.containsKey(tc)) return false;
                smap.put(sc,i);
                tmap.put(tc,i);
            }
        }
        
        return true;
    }
}
