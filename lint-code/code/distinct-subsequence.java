public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        int[][] count = new int[S.length()+1][T.length()+1];
        int slen = S.length();
        int tlen = T.length();
        //special case
        for(int i=0; i<=slen; i++)
            count[i][0] = 1;
            
        for(int i=1; i<=slen; i++){
            for(int j=1; j<=tlen; j++){
                if(S.charAt(i-1) == T.charAt(j-1)){
                    //Case 1: T(j) is matched to S(i)
                    //Case 2: T(j) is to matched to S(i-1)
                    count[i][j] = count[i-1][j-1] + count[i-1][j];
                }
                else count[i][j] = count[i-1][j];
            }
        }
        
        return count[slen][tlen];
        
        
        
    }
}
