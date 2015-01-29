public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        
        if(s1.length()+s2.length() != s3.length()) return false;
        
        boolean[][] state = new boolean[s1.length()+1][s2.length()+1];
        
        state[0][0] = true;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) == s3.charAt(i))
                state[i+1][0] = true;
            else break;
        }
        
        for(int i=0; i<s2.length(); i++){
            if(s2.charAt(i) == s3.charAt(i))
                state[0][i+1] = true;
            else break;
        }
        
        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if(s1.charAt(i-1) == s3.charAt(i+j-1) && state[i-1][j]){
                    state[i][j] = true;
                    //break;
                }
                if(s2.charAt(j-1) == s3.charAt(i+j-1) && state[i][j-1]){
                    state[i][j] = true;
                    //break;
                }
            }
        }
        
        return state[s1.length()][s2.length()];
    }
}
