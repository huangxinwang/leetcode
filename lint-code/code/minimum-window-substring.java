public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        HashMap<Character, Integer> currmap = new HashMap<Character, Integer>();
        
        //create hashmap using target string
        for(char c : target.toCharArray()){
            int count = 1;
            if(dict.containsKey(c)){
                count = dict.get(c)+1;
            }
            dict.put(c,count);
        }
        
        int max = Integer.MAX_VALUE;
        String optStr = "";
        int validLen = 0;
        int start = 0;
        int idx = 0;
        
        while(idx<source.length()){
            char c = source.charAt(idx);
            
            //read a char in source
            if(dict.containsKey(c)){
                if(currmap.containsKey(c)){
                    if(currmap.get(c)<dict.get(c)){
                        validLen++;
                    } 
                    currmap.put(c, currmap.get(c)+1);
                }else{
                    validLen++;
                    currmap.put(c,1);
                }
            }else{
                if(currmap.containsKey(c)){
                    currmap.put(c, currmap.get(c)+1);
                }else  currmap.put(c,1);
            }
            
            
            //advance front of window
            while(start<=idx){
                char front = source.charAt(start);
                if(dict.containsKey(front) && (currmap.get(front)<=dict.get(front)))
                    break;
                if(!dict.containsKey(front) || currmap.get(front)>dict.get(front)){
                    currmap.put(front, currmap.get(front)-1);
                    start++;
                }
            }
            
            //current window is a match
            if(validLen == target.length()){
                if(max > idx-start+1){
                    max = idx-start+1;
                    optStr = source.substring(start, start+max);
                }
                
                char front = source.charAt(start);
                validLen--;
                currmap.put(front, currmap.get(front)-1);
                start++;
            }
            idx++;
            
        }
        
        return optStr;
    }
}
