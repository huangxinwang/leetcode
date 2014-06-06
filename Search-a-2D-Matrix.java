/**
 * Problem Statement
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *  Integers in each row are sorted from left to right.
 *  The first integer of each row is greater than the last integer of the previous row.
 */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length==0) return false;
        
        int row =0;
        row = searchRow(matrix,target,0,matrix.length);
        if(row==-1) return false;
        return searchCol(matrix[row],target,0,matrix[row].length);
        
    }
    
    public boolean searchCol(int[] matrix, int target, int small, int big){
        if(small>=big && matrix[small]!=target) return false;
        if(small>=big && matrix[small]==target) return true;
        int mid = (small+big)/2;
        if(matrix[mid]>=target) return searchCol(matrix,target,small,mid);
        else return searchCol(matrix,target,mid,big);
        
    }
    public int searchRow(int[][] matrix, int target, int small, int big){
        
        if(small>=big){
            if(matrix[small][0]<=target) return small;
            else return -1;
        }
        
        int mid = (small+big)/2;
        if(matrix[mid][0]>=target) return searchRow(matrix,target,small,mid);
        else return searchRow(matrix,target,mid,big);
    }
}