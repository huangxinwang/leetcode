/**
 * Problem Statement: Unique Paths
 * Link:https://oj.leetcode.com/problems/unique-paths/
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 */

///////////////////////////////////
// 2015/12/30
// Highlight: 2D DP

public class Solution {
    public int uniquePaths(int m, int n) {
        //count[i][j] represents the number of ways to reach grid[i][j]
        int[][] count = new int[m][n];
        
        //for each grid, we can reach it by each from left-side or top-side
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0) count[i][j] = 1;
                else count[i][j] = count[i-1][j] + count[i][j-1];
            }
        }
        
        return count[m-1][n-1];
    }
}
