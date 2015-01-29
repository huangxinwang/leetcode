public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int alen = A.length();
        int blen = B.length();
        int[][] count = new int[alen+1][blen+1];
        
        for(int i=1; i<=alen; i++){
            for(int j=1; j<=blen; j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    count[i][j] = count[i-1][j-1]+1;
                }
                else{
                    count[i][j] = Math.max(count[i-1][j], count[i][j-1]);
                }
            }
        }
        
        return count[alen][blen];
    }
}

