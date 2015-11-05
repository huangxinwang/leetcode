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

//////////////////////////////////////////////////////////////////
//Round 2: 12/30/2014
public class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        
        //use the logic: matrix[i][j] = matrix[n-j-1][i]
        for(int i=0; i<(n+1)/2; i++){
            for(int j=0; j<n/2; j++){
              
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
    }
}


////////////////////////////////////////////////////////////////////
// 2015/11/05
// Highlight: in-place rotate
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        //rotate by each layer
        for(int i=0; i<n/2; i++){
            for(int j=i; j<n-i-1; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
    }
}
