/**
 * Problem Statement: Minimum Path Sum 
 * Link: https://oj.leetcode.com/problems/minimum-path-sum/
 * 
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */

public class Solution {
    
    public int minPathSum(int[][] grid) {
      
        //return parameters
        int m = grid.length;
        int n = grid[0].length;
        int[][] minLength = new int[m][n];
        
        //initial condition
        for(int row=1; row<m; row++)
            grid[row][0] += grid[row-1][0];
        for(int col=1; col<n; col++)
            grid[0][col] += grid[0][col-1];
        
        //dynamic programming find min-path
        for(int i=1; i<m; i++)
            for(int j=1; j<n; j++){
                grid[i][j] = Math.min(grid[i][j-1], grid[i-1][j])+grid[i][j];
            }
        
        return grid[m-1][n-1];
    }
}