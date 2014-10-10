/**
 * Problem Statement: Valid Sudoku 
 * Link: https://oj.leetcode.com/problems/valid-sudoku/
 * Time:528ms
 * 
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 
 * 
 */


public class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int row = board.length;
        int col = board[0].length;
        
        //check each row
        for(int i=0; i<row; i++){
            int[] occupied = new int[col];
            for(int j=0; j<col; j++){
                if(board[i][j]=='.') continue;
                int val = Character.getNumericValue(board[i][j]);
                if(val <=0 || val>9) return false;
                if(occupied[val-1]==1) return false;
                else occupied[val-1] = 1;
            }
        }
        
        //check each column
        for(int i=0; i<col; i++){
            int[] occupied = new int[row];
            for(int j=0; j<row; j++){
                if(board[j][i]=='.') continue;
                int val = Character.getNumericValue(board[j][i]);
                if(val<=0 || val>9) return false;
                if(occupied[val-1]==1) return false;
                else occupied[val-1] = 1;
            }
        }
       
        //check each box 
        for(int i=0; i<=row-3; i=i+3){
            for(int j=0; j<=col -3; j=j+3){
                ArrayList<Integer> occupied = new ArrayList<Integer>();
                for(int r=i; r<i+3; r++){
                    for(int c=j; c<j+3; c++){
                        if(board[r][c]=='.') continue;
                        int val = Character.getNumericValue(board[r][c]);
                        if(val<=0 || val>9) return false;
                        if(occupied.contains(val)) return false;
                        else occupied.add(val);
                    }
                }
            }
        }
        
        return true;
    }
}