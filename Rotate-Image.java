/**
 * Problem Statement: Rotate Image
 * 
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up:
 * Could you do this in-place?
 */


public class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        
        //use the relation that matrix[i][j] = matrix[n-1-j][i]
        for(int i=0; i<n/2; i++){
            //note that it should not be j<n/2
            for(int j=0; j < (n+1) /2; j++){
                //in place rotate
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }
            
        
    }
}