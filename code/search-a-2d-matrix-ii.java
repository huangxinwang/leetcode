// Search a 2d matrix ii

/////////////////////////////////////
// 2015/12/15
// Highlight: for each row, binary search
// Time: O(m*log n)

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        //for each row, binary search
        for(int i=0; i<row; i++){
            if(matrix[i][0] > target){
                return false;
            }
            if(matrix[i][col-1]>=target){
                if(bs(matrix, i, target, 0, col-1)) return true;
            }
        }
        
        return false;
    }
    
    public boolean bs(int[][] matrix, int row, int target, int left, int right){
        if(left>right) return false;
        int mid = left + (right-left)/2;
        if(matrix[row][mid]==target) return true;
        if(matrix[row][mid]<target){
            return bs(matrix, row,target, mid+1, right);
        }else return bs(matrix, row, target, left, mid-1);
    }
}
