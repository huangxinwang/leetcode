/**
* Problem Statement: Maximal Square
*Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
*
*For example, given the following matrix:
*
*1 0 1 0 0
*1 0 1 1 1
*1 1 1 1 1
*1 0 0 1 0
*Return 4.
*
*/

///////////////////////////////////////
// 2015/11/20
// Highlight: 2D Dynamic programming to keep track of maximum number of ones ends at position [i][j], O(n^3) running time in finding maximum square

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int[][] ones = new int[matrix.length][matrix[0].length];
        int max = 0;
        
        //keep the maximum number of ones end at position [i][j]
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]=='0'){
                    ones[i][j] = 0;
                }else{
                    if(j==0) ones[i][j] = 1;
                    else ones[i][j] = ones[i][j-1] + 1;
                }
            }
        }
        
        //For each row, and right column, find the maximum square starting from the given row
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                int len = ones[i][j];
                for(int row = i; row<matrix.length; row++){
                    len = Math.min(len, ones[row][j]);
                    if(len==0 || len<(row-i+1)) break;
                    //use the minimum of width and height, since it requires square
                    int area = Math.min(len, row-i+1)*Math.min(len, row-i+1);
                    if(max<area) max = area;
                }
            }
        }
        
        return max;
    }
}
