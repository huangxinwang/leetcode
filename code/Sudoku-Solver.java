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