/**
 * Problem Statement--search insert position
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * 
 */
 
public class Solution {
    public int searchInsert(int[] A, int target) {
        
       //usnig binary search
       if(A.length<=0) return 0;
       int start = 0;
       int end = A.length-1;
       
       //terminate condition
       while(start<=end){
           //iteration
           int mid = (start + end)/2;
           if(A[mid]==target) return mid;
           if(A[mid] > target) end = mid-1;
           else start = mid+1;
       }
       return start;
    }
}