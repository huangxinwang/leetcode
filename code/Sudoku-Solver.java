/**
 * Problem Statement: Sudoku Solver 
 * Link: https://oj.leetcode.com/problems/sudoku-solver/
 * Time: 468 ms
 * Hardness: ****
 * 
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 */


public class Solution {
    public void solveSudoku(char[][] board) {
        
        if(board==null || board.length!=9 || board[0].length!=9) return;
        
        helper(board, 0, 0);
    }
    
    
    public boolean helper(char[][] board, int i, int j){
        //check next row
        if(j==9)
            return helper(board,i+1,0);
        //finished 
        if(i==9)
            return true;
        
        //if current board is empty
        //try filling it with each number in 1-9, and check if it is valid
        if(board[i][j]=='.'){
            for(int k=1; k<=9; k++){
                
                //learned: convert int to char
                board[i][j] = (char)(k+'0');
            
                if(isValid(board,i,j))
                    if(helper(board,i,j+1))
                        return true;
                //if not valid, need reset board[i][j]!
                board[i][j] = '.';
            }
        }else
            return helper(board,i,j+1);
        return false;
    }
    
    //check if the assigned char at location[i,j] is valid 
    public boolean isValid(char[][] board, int i, int j){
        //check each row in the j-th column
        for(int k=0; k<9; k++)
            if(k!=i && board[k][j] == board[i][j]) return false;
        //check each column in the ith row
        for(int k=0; k<9; k++)
            if(k!=j && board[i][k] == board[i][j]) return false;
        
        int row = board.length;
        int col = board.length;
        
        for(int m=i/3*3; m<i/3*3+3; m++){
            for(int n=j/3*3; n<j/3*3+3; n++){
                    if(i!=m && j!=n){
                        if(board[i][j] == board[m][n])
                            return false;
                    }
            }
        }
        
        return true;
    }
}


/////////////////////////////////////////////////////////////////////////////
//Round 2: 1/16/2015
public class Solution {
    public void solveSudoku(char[][] board) {
        
        if(board.length!=9 || board[0].length!=9) return;
        dfs(board, 0, 0);
    }
    
    //dfs find solution
    public boolean dfs(char[][] board, int row, int col){
        if(row==9) return true;
        if(col==9)
            return dfs(board, row+1, 0);
            
        if(board[row][col] == '.'){
            
            for(int i=1; i<=9; i++){
                
                if(isValid(board, row, col, i)){
                    board[row][col] = (char)('0'+i);
                    if(dfs(board, row, col+1))
                        return true;
                    board[row][col] = '.';
                    
                }
            }
        }
        
        else return dfs(board, row, col+1);
        return false;
    }
    
    //check if it is valid
    public boolean isValid(char[][] board, int row, int col, int num){
        for(int i=0; i<9; i++){
            if(board[row][i] == (char)('0'+num))
                return false;
        }
        
        for(int i=0; i<9; i++){
            if(board[i][col] == (char)('0'+num))
                return false;
        }
        
        for(int i=(row/3)*3; i<row/3*3+3; i++){
            for(int j=(col/3)*3; j<col/3*3+3; j++){
                if(board[i][j] == (char)('0'+num))
                    return false;
            }
        }
        
        return true;
    }
}
