/**
* Problem Statement: Group Anagrams
*
*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rnt = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(int i=0; i<strs.length; i++){
            char[] str = strs[i].toCharArray();
            //get sorted version of current string
            //add to the hashmap
            Arrays.sort(str);
            String sorted = new String(str);
            List<String> curr = new ArrayList<String>();
            if(map.containsKey(sorted)){
                curr = map.get(sorted);
            }
            curr.add(strs[i]);
            map.put(sorted,curr);
        }
        
        //sort each list
        for(String key: map.keySet()){
            List<String> list = map.get(key);
            java.util.Collections.sort(list);
            rnt.add(list);
        }
        
        return rnt;
    }
}
