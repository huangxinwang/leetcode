public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public ArrayList<ArrayList<String>> partition(String s) {
        // write your code here
        ArrayList<ArrayList<String>> rnt = new ArrayList<ArrayList<String>>();
        ArrayList<String> tmp = new ArrayList<String>();
        int start = 0;
        dfs(rnt, tmp, start, s);
        return rnt;
    }
    
    //dfs 
    public void dfs(ArrayList<ArrayList<String>> rnt, ArrayList<String> tmp, int start, String s){
        if(start>=s.length()){
            rnt.add(new ArrayList<String>(tmp));
            return;
        }
        
      
        for(int j= start+1; j<=s.length(); j++){
            String str = s.substring(start,j);
            //enumerate all possible palindrone start at index "start"
            if(valid(str)){
                tmp.add(str);
                dfs(rnt, tmp, j, s);
                tmp.remove(tmp.size()-1);
            }
        }
       
    }
    
    public boolean valid(String s){
        for(int i=0; i<=s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        }
        
        return true;
    }
}
