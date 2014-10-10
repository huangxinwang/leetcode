/**
 * Problem Statement: Search in Rotated Sorted Array II 
 * Link: https://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * 
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * 
 */

public class Solution {
    public boolean search(int[] A, int target) {
        //special case
        if(A.length==0) return false;
        
        int left = 0;
        int right = A.length-1;
        return searchRotate(A, left, right, target);
    }
    
    public boolean searchRotate(int[] A, int left, int right, int target){
        int mid = (left+right)/2;
        //terminate conditions
        if(mid>=right && A[mid]!=target) return false;
        if(A[mid] == target) return true;
        
        //Case1: consider instance [1 1 1 3 1], both side need rotate search
        if(A[left]==A[mid] || A[mid]==A[right]) return searchRotate(A, mid+1, right, target) || searchRotate(A, left, mid, target);
        //Case2:
        if(A[left]<A[mid]){
            return binarySearch(A, left, mid, target) || searchRotate(A, mid+1, right, target);
        }
        //Case3:
        else{
            return searchRotate(A, left, mid, target) || binarySearch(A, mid+1, right, target);
        }
    }
    
    public boolean binarySearch(int[] A, int left, int right, int target){
        int mid = (left+right)/2;
        //terminate condition
        if(mid>=right && A[mid]!=target) return false;
        if(A[mid]==target) return true;
        
        //two cases
        if(A[mid]>target) return binarySearch(A, left, mid, target);
        else return binarySearch(A, mid+1, right, target);
    }
}