/**
 * Problem Statement: Spiral Matrix II
 * Link: https://oj.leetcode.com/problems/spiral-matrix-ii/
 * Time: 368 ms
 * 
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * 
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * 
 */



public class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] rnt = new int[n][n];
        int layer = 0;
        int i = 0;
        int j =-1;
        int curr = 1;
        
        //fill array by layers
        while(layer<n){
            
            //top
            while(j<=n-layer-2){
                j++;
                rnt[i][j] = curr;
                curr++;
            }
            
            //right
            while(i<=n-layer-2){
                i++;
                rnt[i][j] = curr;
                curr++;
            }
            
            //bottom
            while(j>=0+layer+1){
                j--;
                rnt[i][j] = curr;
                curr++;
            }
            
            //left
            while(i>=layer+2){
                i--;
                rnt[i][j] = curr;
                curr++;
            }
            
            layer++;
            
        }
        
        return rnt;
    }
}


//////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 12/30/2014
public class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] rnt = new int[n][n];
        
        //file array by layer
        int layer = 0;
        
        int curr = 1;
        
        for(layer=0; layer<=n/2; layer++){
            //top
            for(int i=layer; i<n-layer; i++){
                rnt[layer][i] = curr;
                curr++;
            }
            
            //right
            for(int i=layer+1; i<n-layer-1; i++){
                rnt[i][n-layer-1] = curr;
                curr++;
            }
            
            //bottom
            if(layer!=n-layer-1){
                for(int i=n-layer-1; i>=layer; i--){
                    rnt[n-layer-1][i] = curr;
                    curr++;
                }
            }
            
            //left
            if(layer!=n-layer-1){
                for(int i=n-layer-2; i>=layer+1; i--){
                    rnt[i][layer] = curr;
                    curr++;
                }
            }
        }
        
        return rnt;
    }
}
