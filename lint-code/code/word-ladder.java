public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        Set<String> exist = new HashSet<String>();
        int len  = start.length();
        
        ArrayList<String> toVisited = new ArrayList<String>();
        
        toVisited.add(start);
        int depth = 1;
        
        //bfs traverse
        while(toVisited.size()>0){
            ArrayList<String> tmp = new ArrayList<String>();
            for(int j=0; j<toVisited.size(); j++){
                String curr = toVisited.get(j);
               
                //find nodes in next layers
                for(int i=0; i<len; i++){
                    for(char c='a'; c<='z'; c++){
                        char[] currArr = curr.toCharArray();
                        currArr[i] = c;
                        String newstr = new String(currArr);
                        if(!exist.contains(newstr) && dict.contains(newstr)){
                            if(newstr.equals(end)) return depth+1;
                            exist.add(newstr);
                            tmp.add(newstr);
                        }
                    }
                }
            }
            //update current layer and depth
            toVisited = new ArrayList<String>(tmp);
            depth++;
        }
        
        return depth;
        
    }
    
    
}
