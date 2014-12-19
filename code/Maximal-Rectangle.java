/**
 * Problem Statement: Maximal Rectangle
 * Link:https://oj.leetcode.com/problems/maximal-rectangle/
 * Time:480 ms
 * Hardness: ****
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */


public class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int row = matrix.length;
        if(row==0) return 0;
        int col = matrix[0].length;
        
        //let f[i,j] denote the longest continuous 1 in the ith row, that ends at j column
        int[][] f = new int[row][col];
        
        //dynamic programming 
        //build f table
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(j==0) f[i][j] = matrix[i][j]=='0'? 0 : 1;
                else f[i][j] = matrix[i][j] == '0'? 0: f[i][j-1]+1;
            }
        }
        
        
        //calculate the max rectangle
        int rnt = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                //use [i,j] as the right top corner
                int len = f[i][j];
                if(len==0) continue;
                //traverse each row to get a rectangle, until the min-length of all rows from i to k is 0
                for(int k=i; k<row; k++){
                    len = Math.min(len, f[k][j]);
                    rnt = Math.max(rnt, len*(k-i+1));
                    if(len==0){
                        break;
                    }
                }
            }
        }
        
        return rnt;
        
        
    }
}

///////////////////////////////////////////////////////////////////////////
//Round 2: 12/19/2014
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int row = matrix.length;
        if(row==0) return 0;
        int col = matrix[0].length;
        
        //one[i][j] stands for the longest length of 1 in the ith row, ends at j
        int[][] one = new int[row][col];
        
        //dynamic build one
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(j==0) one[i][0] = matrix[i][0]=='0'?0:1;
                else one[i][j] = matrix[i][j]=='0'? 0: one[i][j-1]+1;
            }
        }
        
        int rnt = 0;
        
        //find the maximum area, using the information in one[][]
        //use [i][j] as the right most corner of the rectangle
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(one[i][j]==0) continue;
                
                int len = one[i][j];
                for(int k=i; k<row; k++){
                    len = Math.min(len, one[k][j]);
                    rnt = Math.max(rnt, len*(k-i+1));
                    if(len==0) break;
                }
            }
        }
        
        return rnt;
    }
}
