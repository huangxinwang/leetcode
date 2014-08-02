/**
 * Problem Statement: N-Queens 
 * Link:https://oj.leetcode.com/problems/n-queens/
 * Time:424 ms
 * 
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
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