/**
 * Problem Statement: Unique Paths
 * Link:https://oj.leetcode.com/problems/unique-paths/
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 */


public class Solution {
    public int uniquePaths(int m, int n) {
        
        //special case
        if(m==0 || n==0) return 0;
        
        //num[i][j] stands for the number of ways to reach (i,j)
        int[][] num = new int[m][n];
        
        //initial condition
        for(int i=0; i<m; i++)
            num[i][0] = 1;
        
        for(int i=0; i<n; i++)
            num[0][i] = 1;
        
        //dynamic programming approach to compute number of path to new position
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++)
                num[i][j] = num[i-1][j] + num[i][j-1];
        }
        
        return num[m-1][n-1];
    }
}

////////////////////////////////////////////////////////
//Round 2: 12/24/2014
public class Solution {
    public int uniquePaths(int m, int n) {
        
        //define dynamic table, path[i][j] denotes the number of ways to go from start to (i+1)(j+1)
        int[][] path = new int[m][n];
        
        //initialize the table
        for(int i=0; i<m; i++)
            path[i][0] = 1;
        for(int i=0; i<n; i++)
            path[0][i] = 1;
            
        //dynamic build the table
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++)
                path[i][j] = path[i-1][j] + path[i][j-1];
        }
        
        return path[m-1][n-1];
    }
}
