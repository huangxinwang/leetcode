/**
 * Problem Statement
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *  Integers in each row are sorted from left to right.
 *  The first integer of each row is greater than the last integer of the previous row.
 */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
       //special case
       if(matrix.length==0) return false;
       
       //value of current row and col index while searching
       int row = 0;
       int col = matrix[0].length-1;
       
       //compare with matrix[row][col], and adjust value of row or col according to the relative value of matrix[row][col] and target
       while(row < matrix.length && col >= 0 && col < matrix[0].length){
           if(matrix[row][col]==target) return true;
           if(matrix[row][col]>target) col--;
           else row++;
       }
       
       return false;
        
    }
    
    
}