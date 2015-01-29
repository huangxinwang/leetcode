public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordSegmentation(String s, Set<String> dict) {
        // write your code here   
        boolean[] state = new boolean[s.length()+1];
        state[0] = true;
        
        for(int i=1; i<=s.length(); i++){
            for(int j=i; j>=1; j--){
                String curr = s.substring(j-1,i);
                //check if can divide at j
                if(state[j-1] && dict.contains(curr)){
                    state[i] = true;
                    break;
                }
            }
        }
        
        return state[s.length()];
    }
}
