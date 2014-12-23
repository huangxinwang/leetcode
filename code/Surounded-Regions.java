/**
 * Problem Statement: Surrounded Regions 
 * Link: https://oj.leetcode.com/problems/surrounded-regions/
 * Time: 648 ms
 * Ref:http://fisherlei.blogspot.com/2013/03/leetcode-surrounded-regions-solution.html
 * 
 * 
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */




public class Solution {
    public void solve(char[][] board) {
        
        int row = board.length;
        if(row == 0) return;
        int col = board[0].length;
        
        ArrayList<Integer> xIndex = new ArrayList<Integer>();
        ArrayList<Integer> yIndex = new ArrayList<Integer>();
        
        getBorderO(xIndex, yIndex, board);
        
        while(xIndex.size()>0){
            int x = xIndex.remove(0);
            int y = yIndex.remove(0);
            
            board[x][y] = 'Y';
            
            //BFS check boarder, add to-be-explored elements into xIndex and yIndex list
            //If BFS can reach an 'O', then it means this 'O' is not surrounded by 'x'
            //so we marked this kind of 'O' as 'Y'
            //at the end, we turn this other 'O' which is not marked as 'Y' to 'X'
            if(x>0 && board[x-1][y]=='O'){
                xIndex.add(x-1);
                yIndex.add(y);
            }
            
            if(x<row-1 && board[x+1][y] == 'O'){
                xIndex.add(x+1);
                yIndex.add(y);
            }
            
            if(y>0 && board[x][y-1] == 'O'){
                xIndex.add(x);
                yIndex.add(y-1);
            }
            
            if(y<col-1 && board[x][y+1] == 'O'){
                xIndex.add(x);
                yIndex.add(y+1);
            }
        }
        
        //
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == 'Y')
                    board[i][j] = 'O';
            }
        }
    }
    
    //get index of 'O' in border to xIndex and yIndex list
    public void getBorderO(ArrayList<Integer> xIndex, ArrayList<Integer> yIndex, char[][] board){
        
        int row = board.length;
        int col = board[0].length;
        for(int i=0; i<row; i++){
            if(board[i][0]=='O'){
                xIndex.add(i);
                yIndex.add(0);
            }
            
            if(board[i][col-1] == 'O'){
                xIndex.add(i);
                yIndex.add(col-1);
            }
        }
        
        for(int i=0; i<col; i++){
            if(board[0][i] == 'O'){
                xIndex.add(0);
                yIndex.add(i);
            }
            
            if(board[row-1][i] == 'O'){
                xIndex.add(row-1);
                yIndex.add(i);
            }
        }
    }
}



////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 12/23/2014
public class Solution {
    int[] px;
    int[] py;
    
    public void solve(char[][] board) {
        px = new int[]{0,0,-1,1};
        py = new int[]{1,-1,0,0};
        int row = board.length;
        if(row==0) return;
        int col = board[0].length;
        
        //first mark the 'O' in the border as Y
        for(int i=0; i<row; i++){
            if(board[i][0] == 'O')
                board[i][0] = 'Y';
            if(board[i][col-1] == 'O')
                board[i][col-1] = 'Y';
        }
        
        for(int i=0; i<col; i++){
            if(board[0][i] == 'O')
                board[0][i] = 'Y';
            if(board[row-1][i] == 'O')
                board[row-1][i] = 'Y';
        }
        
        
        //propogate from Y, make each 'O' as 'Y' it can reach
         for(int i=0; i<row; i++){
           propogate(board, i, 0);
           propogate(board, i, col-1);
        }
        
        for(int i=0; i<col; i++){
           propogate(board, 0, i);
           propogate(board, row-1, i);
        }
        
        //update the unreached 'O' as 'X'
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++)
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
        }
        
        //change 'Y' back to 'O'
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++)
                if(board[i][j] == 'Y')
                    board[i][j] = 'O';
        }
    }
    
    
    //propate 'Y' to other 'O'
    public void propogate(char[][] board, int x, int y){
        if(board[x][y] != 'Y') return;
        for(int i=0; i<4; i++){
            int cx = x+px[i];
            int cy = y+py[i];
            if(isValid(board, cx, cy)){
                board[cx][cy] = 'Y';
                propogate(board, cx, cy);
            }
        }
    }
    
    //check whether a new position can be propagate
    //stop if current position is not 'O', or has already been propogated as 'Y'
    public boolean isValid(char[][] board, int x, int y){
        if(x<0 || x>=board.length) return false;
        if(y<0 || y>=board[0].length) return false;
        if(board[x][y]=='X' || board[x][y]=='Y') return false;
        return true;
    }
}
