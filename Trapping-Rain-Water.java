/**
 * Problem Statement: Trapping Rain Water 
 * Link:https://oj.leetcode.com/problems/trapping-rain-water/
 * Time: 480ms
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * 
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */


public class Solution {
    public int trap(int[] A) {
      
      if(A.length==0 || A.length==1) return 0;
      int n = A.length;
      int leftIdx = 0;
      int rightIdx = n-1;
      int lMax = A[0];
      int rMax = A[n-1];
      int sum = 0;
      int lTmp = 0;
      int rTmp = 0;
      
      //scan from left to right, sum up waters if current height is less than lMax
      for(int i=0; i<n; i++){
          if(lMax <= A[i]){
              sum += lTmp;
              lTmp = 0;
              lMax = A[i];
              leftIdx = i;
          }else
            lTmp += lMax - A[i];
      }
      
      //scan from right to leftIdx, sum up waters if current height is large than rMax
      for(int i=n-1; i>=leftIdx; i--){
          if(rMax <= A[i]){
              sum += rTmp;
              rTmp = 0;
              rMax = A[i];
              rightIdx = i;
          }else
            rTmp += rMax - A[i];
      }
      
      //sum up the waters between leftIdx, rightIdx
      int height = Math.min(A[leftIdx], A[rightIdx]);
      
      for(int i=leftIdx+1; i<rightIdx-1; i++){
          sum += height - A[i];
      }
      
      return sum;
     
    }
}