/**
 * Problem Statement: Unique Paths II 
 * Link: https://oj.leetcode.com/problems/unique-paths-ii/
 * 
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 */





public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        //get row number and column number
        int m = obstacleGrid.length;
        int n= obstacleGrid[0].length;
        
        //special case
        if(m==0 || n==0) return 0;
        
        //num[i][j] stands for the number of path to get to position(i,j)
        int[][] num = new int[m][n];
        
        //initial condition
        if(obstacleGrid[0][0]==1) return 0;
        num[0][0]=1;
        
        //note that unlike the one without obstacle, it is important to check wheher the neighbour is blocked, i.e. num[i-1][0]==0?
        for(int i=1; i<m; i++){
            if(obstacleGrid[i][0]==1 || num[i-1][0]==0) 
                num[i][0] = 0;
            else num[i][0] = 1;
        }
        
        for(int i=1; i<n; i++){
            if(obstacleGrid[0][i]==1 || num[0][i-1]==0)
                num[0][i] = 0;
            else num[0][i] = 1;
        }
        
        
        //dynamic programming to update table
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++)
                if(obstacleGrid[i][j]==1)
                    num[i][j] = 0;
                else
                    num[i][j] = num[i-1][j] + num[i][j-1];
        }
        
        return num[m-1][n-1];
    }
}