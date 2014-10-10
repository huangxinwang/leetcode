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