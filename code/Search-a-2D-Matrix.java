/**
 * Problem Statement
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *  Integers in each row are sorted from left to right.
 *  The first integer of each row is greater than the last integer of the previous row.
 */
 
 /*
  * reference: http://blog.csdn.net/fightforyourdream/article/details/14220921
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



///////////////////////////////////////////////////////////////////////
//Round 2: 12/24/2014
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //2D binary search
        return searchRow(0, matrix.length-1, matrix, target);
        
    }
    
    //binary search row
    public boolean searchRow(int low, int high, int[][] matrix, int target){
        if(low>high) return false;
        int mid = (low+high)/2;
        
        if(searchCol(mid, 0, matrix[mid].length-1, matrix, target)) return true;
        if(matrix[mid][0]<target) return searchRow(mid+1, high, matrix, target);
        else return searchRow(low, mid-1, matrix, target);
    }
    
    //for a specific row, binary search col
    public boolean searchCol(int row, int low, int high, int[][] matrix, int target){
        if(low>high) return false;
        int mid = (low+high)/2;
        int val = matrix[row][mid];
        
        if(val==target) return true;
        if(val < target) return searchCol(row, mid+1, high, matrix, target);
        else return searchCol(row, low, mid-1, matrix, target);
        
    }
}


///////////////////////////////////////////////////////////
//Round 3: 1/15/2015
//time complexity: O(log m * log n)

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchRow(matrix, 0, matrix.length-1, target);
    }
    
    //search for rows
    public boolean searchRow(int[][] matrix, int left, int right, int target){
        int len = matrix[0].length;
        if(left>right) return false;
        if(left==right)
            //search current row
            return searchCol(matrix, left, 0, len-1, target);
        int mid = (left+right)/2;
        if(searchCol(matrix, mid, 0, len-1, target)) return true;
        if(matrix[mid][0]>target)
            return searchRow(matrix, left, mid-1, target);
        else if(matrix[mid][len-1] < target)
            return searchRow(matrix, mid+1, right, target);
        else return false;
    }
    
    //search a row by column
    public boolean searchCol(int[][] matrix, int row, int left, int right, int target){
        if(left>right) return false;
        int mid = (left+right)/2;
        int midVal = matrix[row][mid];
        if(midVal == target) return true;
        if(midVal < target)
            return searchCol(matrix, row, mid+1, right, target);
        else return searchCol(matrix, row, left, mid-1, target);
    }
}
