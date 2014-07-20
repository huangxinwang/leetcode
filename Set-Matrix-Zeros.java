/**
 * Problem Statement: Set Matrix Zeroes 
 * Link: https://oj.leetcode.com/problems/set-matrix-zeroes/
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */


public class Solution {
    public void setZeroes(int[][] matrix) {
        
        //length of row and column
        int m = matrix.length;
        int n = matrix[0].length;
        //list to store rowIndex and colIndex that are to be set as 0
        ArrayList<Integer> rowList = new ArrayList<Integer>();
        ArrayList<Integer> colList = new ArrayList<Integer>();
        
        //find target row and column index
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    if(!rowList.contains(i)) rowList.add(i);
                    if(!colList.contains(j)) colList.add(j);
                 }
            }
        }
        
        //set target row as 0
        for(int i=0; i<rowList.size(); i++){
            int row = rowList.get(i);
            for(int j=0; j<n; j++)
                matrix[row][j] = 0;
        }
        
        //set target col as 0
        for(int i=0; i<colList.size(); i++){
            int col = colList.get(i);
            for(int j=0; j<m; j++)
                matrix[j][col] =0;
        }
}
}