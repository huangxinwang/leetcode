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
// 2015/11/19
// Highlight: hashmap
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()==0) return t.length()==0;
        if(s.length()!=t.length()) return false;
        
        HashMap<Character, Integer> smap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tmap = new HashMap<Character, Integer>();
        
        //make sure: index with same char in s, must also have same char in t, and vice vesa
        for(int i=0; i<s.length(); i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(smap.containsKey(sc)){
                if(!tmap.containsKey(tc)) return false;
                int idx = smap.get(sc);
                if(t.charAt(idx)!=t.charAt(i)) return false;
            }else{ 
                if(tmap.containsKey(tc)) return false;
                smap.put(sc, i);
                tmap.put(tc,i);
            }
        }
        
        return true;
    }
}
