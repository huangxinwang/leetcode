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


//////////////////////////////////////////////////
//Round 2: 12/24/2014
public class Solution {
    public int minPathSum(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        
        //define table, dist[i][j] represents the dist from start point to grid[i][j]
        int[][] dist = new int[row][col];
        
        //initialize
        dist[0][0] = grid[0][0];
        
        for(int i=1; i<row; i++){
            dist[i][0] = dist[i-1][0] + grid[i][0];
        }

        for(int i=1; i<col; i++)
            dist[0][i] = dist[0][i-1] + grid[0][i];
         
        //dynamic build the table   
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                dist[i][j] = Math.min(dist[i-1][j]+grid[i][j], dist[i][j-1]+ grid[i][j]);
            }
        }
        
        return dist[row-1][col-1];
    }
}


////////////////////////////////////////////////////////////
// 2015/11/06
// Highlight: 2D DP
public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length==0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        
        for(int i=0; i<m; i++){
            if(i==0) sum[i][0] = grid[i][0];
            else sum[i][0] = sum[i-1][0] + grid[i][0];
        }
        
        for(int j=1; j<n; j++){
            sum[0][j] = sum[0][j-1] + grid[0][j];
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                sum[i][j] = grid[i][j] + Math.min(sum[i-1][j], sum[i][j-1]);
            }
        }
        
        return sum[m-1][n-1];
    }
}
