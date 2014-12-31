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


/////////////////////////////////////////////////////////////////////////////
//Round 2: 12/30/2014
public class Solution {
    public int trap(int[] A) {
        
        //special case
        if(A.length<=1) return 0;
        
        
        //traverse from left to right, sum up waters if currentMax is smaller than A[i]
        int sum = 0;
        int tmpSum = 0;
        int leftMax = 0;
        int leftIndex = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] >= leftMax){
                sum = sum + tmpSum;
                tmpSum = 0;
                leftMax = A[i];
                leftIndex = i;
            }
            else
                tmpSum = tmpSum + (leftMax -A[i]);
        }
        
        
        //traverse from right to leftIndex, sum up waters if currentMax is smaller than A[i]
        int rightMax = 0;
        int rightIndex = A.length-1;
        tmpSum = 0;
        for(int i=A.length-1; i>=leftIndex; i--){
            if(A[i]>=rightMax){
                sum += tmpSum;
                tmpSum = 0;
                rightMax = A[i];
                rightIndex = i;
            }
            else
                tmpSum += (rightMax - A[i]);
        }
        
        
        //sum up waters between leftIndex and rightIndex
        int height = Math.min(A[leftIndex],A[rightIndex]);
        for(int i=leftIndex+1; i<rightIndex; i++){
            sum += (height-A[i]);
        }
        
        return sum;
    }
}
