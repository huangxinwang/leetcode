/**
 * Problem Statement: N-Queens II 
 * Link: https://oj.leetcode.com/problems/n-queens-ii/
 * Time:
 * 
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */


public class Solution {
    
    int rnt;
    public int totalNQueens(int n) {
        
        //keep state of invalid position
        int[][] state = new int[n][n];
        rnt = 0;
        //dfs find solutions
        dfs(n, state, 0);
        return rnt;
    }
    
    public void dfs(int n, int[][] state, int depth){
        //solution found
        if(depth==n){
            rnt = rnt + 1;
            return;
        }
        
        //traverse each line
        for(int i=0; i<n; i++){
            //current position available
            if(state[depth][i]==0){
                int[][] newState = cloneState(state);
                newState[depth][i] = 1;
                //invalid related positions
                for(int m=depth; m<n; m++)
                    newState[m][i] = 1;
                for(int m=depth+1; m<n; m++){
                    int col = i +(m-depth);
                    if(col<n) newState[m][col]=1;
                }
                for(int m=depth+1; m<n; m++){
                    int col = i- (m-depth);
                    if(col>=0) newState[m][col]=1;
                }
                dfs(n, newState, depth+1);
            }
        }
    }
    
    //clone state
    public int[][] cloneState(int[][] origin){
        int row = origin.length;
        int col = origin[0].length;
        int[][] rnt = new int[row][col];
        for(int i=0; i<row; i++)
            for(int j=0; j<col; j++)
                rnt[i][j] = origin[i][j];
        return rnt;
    }
}