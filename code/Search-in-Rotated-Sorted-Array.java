/**
 * Problem Statement: Search in Rotated Sorted Array
 * Link:https://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 * Time:432 ms
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * 
 * 
 */



public class Solution {
    public int search(int[] A, int target) {
        
        if(A.length==0) return -1;
        
        return rotateSearch(A, target, 0, A.length-1);
    }
    
    //normal binary search
    public int binarySearch(int[] A, int target,int left,int right){
        if(left>right) return -1;
        int mid = (left+right)/2;
        if(A[mid]==target) return mid;
        if(A[mid]<target)
            return binarySearch(A, target, mid+1,right);
        else
            return binarySearch(A, target,left,mid-1);
    }
    
    //search rotated array
    public int rotateSearch(int[] A,int target,int left,int right){
        
        //special condition
        if(left>right) return -1;
        if(A[left]<A[right]) return binarySearch(A, target, left, right);
        int mid = (left+right)/2;
        if(A[mid]==target) return mid;
        if(A[left]==target) return left;
        if(A[right]==target) return right;
        
        //four cases 
        if(A[left]<=A[mid]){
            if(A[left]<target && A[mid]>target)
                return binarySearch(A, target, left, mid-1);
            else 
                return rotateSearch(A, target, mid+1, right);
        }else{
            if(A[mid]<target && A[right]>target)
                return binarySearch(A,target, mid+1, right);
            else
                return rotateSearch(A, target, left, mid-1);
        }
    }
}

///////////////////////////////////////////////////////////
//Round 2: 12/31/2014
public class Solution {
    public int search(int[] A, int target) {
        
        return rotateSearch(A, target, 0, A.length-1);
    }
    
    public int rotateSearch(int[] A, int target, int left, int right){
        //terminate cases
        if(left>right) return -1;
        if(A[left]==target) return left;
        
        int mid = (left+right)/2;
        if(A[mid]==target) return mid;
        
        //Case 1: not rated, binary search
        if(A[left]<A[mid] && A[mid]<A[right]){
            if(A[mid]>target)
                return rotateSearch(A, target, left, mid-1);
            else
                return rotateSearch(A, target, mid+1, right);
        }
        //Case 2: roated, search both sides
        else{
            int rnt1 = rotateSearch(A, target, left, mid-1);
            if(rnt1!=-1)
                return rnt1;
            else 
                return rotateSearch(A, target, mid+1, right);
                
        }
    }
}
