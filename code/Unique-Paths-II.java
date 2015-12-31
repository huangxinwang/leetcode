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

///////////////////////////////////
// 2015/12/30
// Highlight: 2D DP
// Space: O(n)
public class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] count = new int[n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //Case 1: has obstacle, then set as zero
                if(grid[i][j]==1) count[j] = 0;
                
                //Deal with i==0, j==0
                else if(i==0 && j==0) count[j] = 1;
                else if(j==0) count[j] = count[j];
                else count[j] = count[j] + count[j-1];
            }
        }
        
        return count[n-1];
    }
}
