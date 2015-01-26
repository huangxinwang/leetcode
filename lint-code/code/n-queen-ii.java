class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        //write your code here
        int[] count = new int[1];
        int[] loc = new int[n];
        
        help(loc, count, 0, 0, n);
        return count[0];
    }
    
    //recursively find all solution
    public void help(int[] loc, int[] count, int row, int col, int n){
        if(row==n){
            count[0]++;
            return;
        }
        
        for(int i=col; i<n; i++){
            if(validBoard(loc, row, i, n)){
                loc[row] = i;
                help(loc, count, row+1, 0, n);
            }
        }
    }
    
    //test if board is valid
    public boolean validBoard(int[] loc, int row, int col, int n){
        for(int i=0; i<row; i++){
            if(loc[i] == col) return false;
            if(Math.abs(loc[i] - col) == Math.abs(i-row)) return false;
        }
        return true;
    }
    
    
};


