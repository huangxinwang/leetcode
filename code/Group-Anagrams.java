/**
 * Problem Statement: Anagrams 
 * 
 * Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 */


public class Solution {
    public List<String> anagrams(String[] strs) {
        
        //create footprint for each string
        String[] footprint = new String[strs.length];
        for(int i=0; i<strs.length; i++){
            footprint[i] = getfootprint(strs[i], 7);
        }
        
        //put footprint into map
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        for(int i=0; i<strs.length; i++){
            String key = footprint[i];
            if(map.containsKey(key)){
                map.get(key).add(i);
            }
            else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                map.put(key, list);
                map.get(key).add(i);
            }
        }
        
        
        //get anagrams
        ArrayList<String> rnt = new ArrayList<String>();
        for(String key: map.keySet()){
            
            ArrayList<Integer> list = map.get(key);
            
            if(list.size()>1){
                for(int i=0; i<list.size(); i++){
                    rnt.add(strs[list.get(i)]);
                }
            }
        }
        
        return rnt;
    }
    
    //create footprint for each string
    private String getfootprint(String s, int seed){
        int[] index = new int[26];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            index[c-'a']++;
        }
        
        long rnt = 0;
        for(int i=0; i<26; i++){
            rnt = rnt*seed + index[i];
        }
        
        return Long.toString(rnt);
    }
}


///////////////////////////////////////////////////////////////////
// 2015/11/05
//Highlight: use map, and use string sort
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        List<List<String>> rnt = new ArrayList<List<String>>();
        
        //use map to group strings
        for(int i=0; i<strs.length; i++){
            String curr = strs[i];
            char[] array = curr.toCharArray();
            Arrays.sort(array);
            String sorted = new String(array);
            List<String> list = new ArrayList<String>();
            if(map.containsKey(sorted)){
                list = map.get(sorted);
            }
            list.add(strs[i]);
            map.put(sorted, list);
        }
        
        //sort strings in list
        for(String key: map.keySet()){
            List<String> list = map.get(key);
            java.util.Collections.sort(list);
            rnt.add(list);
        }
        
        return rnt;
    }
}
