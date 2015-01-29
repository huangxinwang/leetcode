public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public ArrayList<String> anagrams(String[] strs) {
        // write your code here
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        //sort each string, and put the original one to the hashmap
        for(int i=0; i<strs.length; i++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            ArrayList<String> list ;
            
            if(map.containsKey(s)){
                list = map.get(s);
            }else{
                list = new ArrayList<String>();
            }
            list.add(strs[i]);
            map.put(s, list);
        }
        
        //constract the return list
        ArrayList<String> rnt = new ArrayList<String>();
        for(String key: map.keySet()){
            ArrayList<String> list = map.get(key);
            if(list.size()>1){
                for(String item: list)
                    rnt.add(item);
            }
        }
        
        return rnt;
    }
}
