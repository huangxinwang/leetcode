class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        
        //loc[i] denote the column to put the queen in the i-th row
        int[] loc = new int[n];
        ArrayList<ArrayList<String>> rnt = new ArrayList<ArrayList<String>>();
        help(rnt, loc, 0, 0, n);
        return rnt;

    }
    
    public void help(ArrayList<ArrayList<String>> rnt, int[] loc, int row, int col, int n){
        if(row==n){
            ArrayList<String> board = printBoard(loc, n);
            rnt.add(board);
            return;
        }
        
        for(int i=col; i<n; i++){
            if(validLoc(loc, row, i,n)){
                loc[row] = i;
                help(rnt, loc, row+1, 0, n);
            }
        }
    }
    
    //print board
    public ArrayList<String> printBoard(int[] loc, int n){
        ArrayList<String> rnt = new ArrayList<String>();
        for(int i=0; i<n; i++){
            StringBuffer sb = new StringBuffer();
            for(int j=0; j<n; j++){
                if(loc[i]!=j)
                    sb.append(".");
                else sb.append("Q");
            }
            rnt.add(sb.toString());
        }
        
        return rnt;
    }
    
    //test whether it is valid
    public boolean validLoc(int[] loc, int row, int col, int n){
        for(int i=0; i<row; i++){
            if(loc[i] == col) return false;
            if(Math.abs(i-row)==Math.abs(loc[i] - col)) return false;
        }
        
        return true;
    }
};
