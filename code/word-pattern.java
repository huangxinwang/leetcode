/**
*Given a pattern and a string str, find if str follows the same pattern.
*
*Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
*
*Examples:
*pattern = "abba", str = "dog cat cat dog" should return true.
*pattern = "abba", str = "dog cat cat fish" should return false.
*pattern = "aaaa", str = "dog cat cat dog" should return false.
*pattern = "abba", str = "dog dog dog dog" should return false.
*Notes:
*You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*
*/


// 2015/11/11
// Time complexity: O(pattern.length)
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
        
        //use a hashmap to record each character
        //e.g., <a, <the index of a>>
        //      <b, <the index of b>>
        for(int i=0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            ArrayList<Integer> list = new ArrayList<Integer>();
            if(map.containsKey(c)){
                list = map.get(c);
            }
            list.add(i);
            map.put(c, list);
        }
        
        String[] arrays = str.split(" ");
        if(arrays.length != pattern.length()) return false;
        
        HashSet<String> set = new HashSet<String>();
        
        //check if the index for the same character match same string in the given string
        for(Character key : map.keySet()){
            ArrayList<Integer> list = map.get(key);
            if(list.size()==0) continue;
            String firststr = arrays[list.get(0)];
            if(set.contains(firststr)) return false;
            set.add(firststr);
            for(int i=1; i<list.size(); i++){
                if(arrays.length<i+1) return false;
                if(!arrays[list.get(i)].equals(firststr)) return false;
            }
        }
        
        return true;
    }
}
