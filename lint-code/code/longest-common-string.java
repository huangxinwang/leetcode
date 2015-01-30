public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int alen = A.length();
        int blen = B.length();
        if(alen==0 || blen==0) return 0;
        
        int[][] count = new int[alen+1][blen+1];
        int max = 0;
        
        for(int i=1; i<=alen; i++){
            for(int j=1; j<=blen; j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    count[i][j] = count[i-1][j-1]+1;
                    if(count[i][j] > max) max = count[i][j];
                }
                //since must be continuous
                else count[i][j] = 0;
                //Math.max(count[i-1][j], count[i][j-1]);
            }
        }
        
        return max;
    }
}
