/**
 * Problem Statement: Rotate Image
 * 
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up:
 * Could you do this in-place?
 */


////////////////////////////////////////////////////////////////////
// 2015/12/24
// Highlight: in-place rotate

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        //use the logic of matrix[i][j] = matrix[n-1-j][i]
        for(int i=0; i<(n+1)/2; i++){
            //rotate by each layer
            for(int j=i; j<n-i-1; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }
    }
}
