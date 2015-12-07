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


////////////////////////////////////////////////////////////
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(s==null) return t==null;
        if(s.length()!=t.length()) return false;
        HashMap<Character, Integer> smap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tmap = new HashMap<Character, Integer>();
        
        for(int i=0; i<s.length(); i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            
            //if s has
            if(smap.containsKey(sc)){
                //t must have
                if(!tmap.containsKey(tc)) return false;
                //and should be the same
                int idx = smap.get(sc);
                if(t.charAt(idx)!=tc) return false;
                idx = tmap.get(tc);
                if(s.charAt(idx)!=sc) return false;
            }
            // if s has not
            else{
                //t must not have
                if(tmap.containsKey(tc)) return false;
                tmap.put(tc,i);
                smap.put(sc,i);
            }
        }
        
        return true;
        
        
    }
}


////////////////////////////////////////////////////////
// 2015/12/07
// Time: O(n^2), since need to search key by value
// Space: O(n)
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s==null) return t==null;
        if(s.length()!=t.length()) return false;
        
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        
        for(int i=0; i<s.length(); i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            
            //if <x,tc>, x exits and x is not sc; return false
            Character key = getKey(map, tc);
             if(key!=null && key!=sc) return false;
             
            //if <sc,x> exists, x is not tc, return false
            if(map.containsKey(sc)){
                if(map.get(sc)!=tc) return false;
            }
            //store the mapping
            else{
                map.put(sc, tc);
            }
        }
        
        return true;
    }
    
    public Character getKey(HashMap<Character, Character> map, char tc){
        for(Character key: map.keySet()){
            if(map.get(key)==tc) return key;
        }
        return null;
    }
}
