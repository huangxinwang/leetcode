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
                //loc[curr] = 0; This line is not necessary
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
/////////////////////////////////////////////////////////////////////
// 2015/11/05 
// Highlight: dfs
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> rnt = new ArrayList<List<String>>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        
        int depth = 0;
        dfs(board, depth, rnt, 0);
        return rnt;
    }
    
    //for each line, for each colume try to put a queen there
    public void dfs(char[][] board, int depth, List<List<String>> rnt, int x){
        int row = board.length;
        int col = board[0].length;
        if(depth==row){
            rnt.add(readBoard(board));
            return;
        }
        
        if(x>=row){
            return;
        }
        
        //for each column, try to put queen there
        for(int i=0; i<board.length; i++){
             if(board[x][i]=='.'){
            
                board[x][i] = 'Q';
                
                if(validBoard(board, x, i)){
                  dfs(board, depth+1, rnt, x+1);
                }
               
                board[x][i] = '.';
               
            }
        }


    }

    
    //print board
    public ArrayList<String> readBoard(char[][] board){
        ArrayList<String> rnt = new ArrayList<String>();
        for(int i=0; i<board.length; i++){
            String currline = "";
            for(int j=0; j<board[0].length; j++){
                currline +=board[i][j];
            }
            rnt.add(currline);
        }
        
        return rnt;
    }
    
    //check if valid
    public boolean validBoard(char[][] board, int x, int y){
        int row = board.length;
        int col = board[0].length;
        for(int j=0; j<col; j++){
            if(board[x][j]=='Q' && (j!=y)) return false;
        }
        
        for(int i=0; i<row; i++){
            if(i!=x && board[i][y] == 'Q') return false;
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                
                if(i==x && j==y) continue;
                if(board[i][j] == 'Q'){
                    if(Math.abs(i-x) == Math.abs(j-y)) return false;
                }
                
            }
        }
        
        return true;
    }
}
