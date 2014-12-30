/**
 * Problem Statement: Anagrams 
 * 
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
