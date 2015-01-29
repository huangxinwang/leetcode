public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here 
        int[][] ways = new int[m][n];
        
        ways[0][0]=1;
        for(int i=1; i<m; i++){
            ways[i][0] = 1;
        }
        
        for(int i=1; i<n; i++){
            ways[0][i] = 1;
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                ways[i][j] = ways[i-1][j] + ways[i][j-1];
            }
        }
        
        return ways[m-1][n-1];
    }
}
