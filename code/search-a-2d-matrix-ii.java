// Search a 2d matrix ii


/////////////////////////////////////////
// 2015/12/15
// Highlight: logic
// Time: O(m+n)
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0) return false;
        int i = 0;
        int j = matrix[0].length-1;
        
        //search from top right
        while(i<matrix.length && j>=0){
            int val = matrix[i][j];
            if(target==val) return true;
            //current val larger than target, elements in current col should be discarded, so j--
            if(target<val) j--;
            //current val smaller than target, elements in current row should be discarded, so i++
            else i++;
        }
        
        return false;
    }
}


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
