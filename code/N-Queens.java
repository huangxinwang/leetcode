/**
 * Problem Statement: N-Queens 
 * Link:https://oj.leetcode.com/problems/n-queens/
 * Time:424 ms
 * 
 * The n-queens puzzle is the problem of placing n queens on an n*n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' 
 * both indicate a queen and an empty space respectively.
 * 
 */


public class Solution {
    
    List<String[]> rnt;
    
    public List<String[]> solveNQueens(int n) {
        
        rnt = new ArrayList<String[]>();
        int[][] curr = new int[n][n];
        
        DFSFindAllSol(0, curr, n);
        
        return rnt;
    }
    
    //use DFS approach to find all solutions
    private void DFSFindAllSol(int depth, int[][] curr, int n){
	
        if(depth==n){
           String[] state = getSolution(curr,n);           
            rnt.add(state);
            return;
        }
        
        for(int i=0; i<n; i++){
            if(curr[depth][i]==0){
                int[][] newState = cloneArray(curr);
                updateState(newState, depth, i, n);
                DFSFindAllSol(depth+1, newState, n);
            }
        }
    }
    
    //clone array
    private int[][] cloneArray(int[][] origin){
        int row = origin.length;
        int col = origin[0].length;
        int[][] rnt = new int[row][col];
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++)
                rnt[i][j] = origin[i][j];
        }
        
        return rnt;
    }
    
    //update state
    public void updateState(int[][] state, int row, int col, int n){
        
        //set column as occupied
        for(int c=0; c<n; c++){
            state[row][c] = 1;
        }
        
        //set row as occupied
        for(int r=0; r<n; r++){
            state[r][col] = 1;
        }
        
        //set diagonal as occupied
        for(int r=row+1;r<n;r++)
        {
            int c1 = col + (r-row);
            int c2 = col - (r-row);
            
            if(c1 < n) state[r][c1] = 1;
            if(c2 >=0) state[r][c2] = 1;
        }
        
        state[row][col] = 2;
    }
	
	//convert solution from int array to string
	public String[] getSolution(int[][] curr, int n){
		 String[] state = new String[n];
            for(int i=0;i<n;i++)
            {
                String s = new String();
                for(int j=0;j<n;j++)
                {
                    switch(curr[i][j])
                    {
                        case 0:
                        case 1:
                            s += '.';
                            break;
                        case 2:
                            s += 'Q';
                            break;
                    }
                }
                state[i] = s;
            }
            
        return state;
	}
    
    
    
}

/////////////////////////////////////////////////////////////////////////
//Round 2: 12/30/2014
/**
 * Ref: http://blog.csdn.net/u011095253/article/details/9158473
 * 
 */

public class Solution {
    public List<String[]> solveNQueens(int n) {
        
        int curr = 0;
        int[] loc = new int[n];
        ArrayList<String[]> rnt = new ArrayList<String[]>();
        
        helper(curr, n, loc, rnt);
        
        return rnt;
    }
    
    //dfs find all possible solution
    public void helper(int curr, int n,  int[] loc, ArrayList<String[]> rnt){
        
        if(curr == n){
            String[] result = printBoard(loc,n);
            rnt.add(result);
            return;
        }
        
        for(int i=0; i<n; i++){
            if(checkValid(curr, i, loc, n)){
                loc[curr] = i;
                helper(curr+1, n, loc, rnt);
                loc[curr] = 0;
            }
        }
        
    }
    
    //check whether current allocation is valid
    public boolean checkValid(int curr, int col, int[] loc, int n){
        for(int i=0; i<curr; i++){
            if(loc[i] == col) return false;
            if(Math.abs(loc[i]-col) == Math.abs(i-curr)) return false;
        }
        
        return true;
    }
    
    //print board to string[]
    public String[] printBoard(int[] loc, int n){
        
        String[] rnt = new String[n];
        for(int i=0; i<n; i++){
            StringBuffer sb = new StringBuffer();
            for(int j=0; j<n; j++){
                if(loc[i]==j)
                    sb.append('Q');
                else sb.append('.');
            }
            rnt[i] = sb.toString();
        }
        
        return rnt;
    }
    
    
}
