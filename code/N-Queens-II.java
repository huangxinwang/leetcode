/**
 * Problem Statement: N-Queens II 
 * Link: https://oj.leetcode.com/problems/n-queens-ii/
 * Time:
 * 
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */


public class Solution {
    
    int rnt;
    public int totalNQueens(int n) {
        
        //keep state of invalid position
        int[][] state = new int[n][n];
        rnt = 0;
        //dfs find solutions
        dfs(n, state, 0);
        return rnt;
    }
    
    public void dfs(int n, int[][] state, int depth){
        //solution found
        if(depth==n){
            rnt = rnt + 1;
            return;
        }
        
        //traverse each line
        for(int i=0; i<n; i++){
            //current position available
            if(state[depth][i]==0){
                int[][] newState = cloneState(state);
                newState[depth][i] = 1;
                //invalid related positions
                for(int m=depth; m<n; m++)
                    newState[m][i] = 1;
                for(int m=depth+1; m<n; m++){
                    int col = i +(m-depth);
                    if(col<n) newState[m][col]=1;
                }
                for(int m=depth+1; m<n; m++){
                    int col = i- (m-depth);
                    if(col>=0) newState[m][col]=1;
                }
                dfs(n, newState, depth+1);
            }
        }
    }
    
    //clone state
    public int[][] cloneState(int[][] origin){
        int row = origin.length;
        int col = origin[0].length;
        int[][] rnt = new int[row][col];
        for(int i=0; i<row; i++)
            for(int j=0; j<col; j++)
                rnt[i][j] = origin[i][j];
        return rnt;
    }
}


/////////////////////////////////////////////////////////////////////////////
//Round 2: 12/30/2014
public class Solution {
    
    public int totalNQueens(int n) {
        
        int curr = 0;
        int[] loc = new int[n];
        
        return helper(curr, loc, n);
        
    }
    
    //dfs find all solutions
    public int helper(int curr, int[] loc, int n){
        
        int count = 0;
        
        if(curr==n){
            return 1;
        }
        
        for(int i=0; i<n; i++){
            loc[curr] = i;
            if(checkValid(curr, loc, n)){
                 count = count + helper(curr+1, loc, n);
            }
            loc[curr] = 0;
        }
        
        return count;
    }
    
    //check if current allocation is valid 
    public boolean checkValid(int curr, int[] loc, int n){
        
        for(int i=0; i<curr; i++){
            if(loc[i] == loc[curr]) return false;
            if(Math.abs(loc[i]-loc[curr]) == Math.abs(i-curr)) return false;
        }
        
        return true;
    }
}


/////////////////////////////////////////////////////
// 2015/11/05
// Highlight: dfs
// Time complexity: O(n^3)
public class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> rnt = new ArrayList<List<String>>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        
        int depth = 0;
        dfs(board, depth, rnt, 0);
        return rnt.size();
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
