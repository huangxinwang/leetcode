//Ref: http://leetcode.com/2010/10/searching-2d-sorted-matrix-part-ii.html

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        int row = matrix.length;
        if(row==0) return 0;
        
        int col = matrix[0].length;
        if(matrix[0][0] > target || matrix[row-1][col-1]<target) return 0;
        int i =0;
        int j = col-1;
        int count = 0;
        //the start position is matrix[0][col-1]
        while(i<=row-1 && j>=0){
            
            if(matrix[i][j] > target)
                j--;
            else if(matrix[i][j] < target)
                i++;
            else{
                //keep search other occurence
                count++;
                if(j>0) j--;
                else return count;
            }
        }
        
        return count;
        
    }
}

