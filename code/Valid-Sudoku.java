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

/////////////////////////////////////////////////////////////////////////
//Round 2： 12/25/2014
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int row = board.length;
        if(row!=9) return false;
        int col = board[0].length;
        if(col!=9) return false;
        
        //check row
        for(int i=0; i<row; i++){
            HashMap<Character, Integer> map = new HashMap<Character,Integer>();
            for(int j=0; j<col; j++){
                if(board[i][j]!='.' && (board[i][j]<='0' || board[i][j]>'9')) return false;
                if(board[i][j]=='.') continue;
                if(!map.containsKey(board[i][j]))
                    map.put(board[i][j],1);
                else return false;
            }
        }
        
        //check column
        for(int i=0; i<col; i++){
            HashMap<Character, Integer> map = new HashMap<Character,Integer>();
            for(int j=0; j<row; j++){
                if(board[j][i]=='.') continue;
                if(!map.containsKey(board[j][i]))
                    map.put(board[j][i],1);
                else return false;
            }
        }
        
        //check 9 sub-square
        for(int i=0; i<row; i+=3){
            for(int j=0; j<col; j+=3){
                HashMap<Character, Integer> map = new HashMap<Character,Integer>();
                for(int m=i; m<i+3; m++){
                    for(int n=j; n<j+3; n++){
                        if(board[m][n]=='.') continue;
                        if(!map.containsKey(board[m][n]))
                            map.put(board[m][n],1);
                        else return false;
                    }
                }
            }
        }
        
        return true;
    }
}


///////////////////////////////////////////////////////////
// 2015/11/04
// Highlight: check in order
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        
        //check column
        for(int k=0; k<row; k++){
            HashSet<Character> map = new HashSet<Character>();
            for(int i=0; i<col; i++){
                char val = board[k][i];
                if(val=='.') continue;
                else if(map.contains(val)) return false;
                else map.add(val);
            }
        }
        
        //check row
        for(int k=0; k<col; k++){
            HashSet<Character> map = new HashSet<Character>();
            for(int i=0; i<row; i++){
                char val = board[i][k];
                if(val=='.') continue;
                else if(map.contains(val)) return false;
                else  map.add(val);
            }
        }
        
        //check 3*3 box
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(!isValid(board,i,j)) return false;
            }
        }
        
        return true;
    }
    
    
    //check validity at a curtain location of 3*3 box
    public boolean isValid(char[][] board, int x, int y){
        int row = board.length;
        int col = board[0].length;

        int x_idx = x/3;
        int y_idx = y/3;
        
        HashSet<Character> map = new HashSet<Character>();
        for(int i=3*x_idx; i<3*(x_idx+1); i++){
            for(int j=3*y_idx; j<3*(y_idx+1); j++){
                char val = board[i][j];
                if(val=='.') continue;
                else if(map.contains(val)) return false;
                else  map.add(val);
            }
        }
        
        return true;
    }
}
