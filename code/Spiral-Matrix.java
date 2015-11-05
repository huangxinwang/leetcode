/**
 * Problem Statement: Spiral Matrix
 * Link: https://oj.leetcode.com/problems/spiral-matrix/
 * Hardness: ***
 */

public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        
        ArrayList<Integer> rnt = new ArrayList<Integer>();
        int row = matrix.length;
        if(row==0) return rnt;
        
        int col = matrix[0].length;
        
        
        //scap each outer loop, note the number of loop to scan is Math.min(row/2,col/2)+1
        for(int i=0; i<=Math.min(row/2,col/2); i++){
            
            //top
            for(int j=i; j<=col-i-1; j++){
                rnt.add(matrix[i][j]);
            }
            
            //right
            for(int j=i+1; j<=row-2-i; j++){
                rnt.add(matrix[j][col-i-1]);
            }
            
            //bottom
            //note need avoid repetetion when row is even
            if(2*i!=row-1){
                for(int j=col-i-1; j>=i; j--){
                    rnt.add(matrix[row-i-1][j]);
                }
            }
            
            //left
            //note need to avoid repetition
            if(i!=col-i-1)
           {
                for(int j=row-2-i; j>=i+1; j--){
                    rnt.add(matrix[j][i]);
                }
            }
           
           //judge if it is to the end 
           if(rnt.size() == row*col) break;
            
        }
        
        return rnt;
    }
}

//////////////////////////////////////////////////////////////////////////////////////////
// 2015/11/04
// Highlight: corner cases, avoid repete traverse
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> rnt = new ArrayList<Integer>();
        if(matrix.length==0) return rnt;
        int m = matrix.length;
        int n = matrix[0].length;
       
       
        
        for(int k=0; k<=Math.min(m,n)/2; k++){
          
           for(int j=k; j<n-k; j++)
                rnt.add(matrix[k][j]);
                
           for(int i=k+1; i<m-k-1; i++)
                rnt.add(matrix[i][n-k-1]);
                
           if(k!=m-k-1){
               for(int j=n-k-1; j>=k; j--)
                    rnt.add(matrix[m-k-1][j]);
           }
               
           if(k!=n-k-1){ 
            for(int i=m-k-2; i>=k+1; i--)
                rnt.add(matrix[i][k]);
           }
           
           if(rnt.size() == m*n) break;
        }
        
        return rnt;
    }
}
