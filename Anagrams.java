/**
 * Problem Statement: Anagrams 
 * Link: Given an array of strings, return all groups of strings that are anagrams.
 * Ref: http://blog.csdn.net/linhuanmars/article/details/21664747
 * Hardness: **
 * Time: 788 ms
 * 
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * 
 */


public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        
        ArrayList<String> rnt = new ArrayList<String>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        //sort each string, and put them into hashmap
        for(int i=0; i<strs.length; i++){
            char[] currStr = strs[i].toCharArray();
            Arrays.sort(currStr);
            String newStr = new String(currStr);
            
            if(map.containsKey(newStr)){
                map.get(newStr).add(strs[i]);
            }else{
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(newStr,list);
            }
        }
        
        //iterate the hashmap 
        //Learn 1: map.values(), iterator over key
        Iterator itr = map.values().iterator();
        while(itr.hasNext()){
            ArrayList<String> list = (ArrayList<String>) itr.next();
            if(list.size()>=2){
                //Learn 2: list.addAll(input), add each string in input list
                rnt.addAll(list);
            }
        }
        
        return rnt;
    }
}