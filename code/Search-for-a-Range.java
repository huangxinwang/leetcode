/**
 * Problem Statement: Search for a Range
 * Link:https://oj.leetcode.com/problems/search-for-a-range/
 * Time:362ms
 * 
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * 
 */


public class Solution {
    public int[] searchRange(int[] A, int target) {
        
        //binary search to find left index for target and target+1
        //note whatever target+1 found or not, it will return the index of target_right+1
        int l = binarySearch(0, A.length-1, A, target);
        int r = binarySearch(0, A.length-1, A, target+1);
        int[] rnt = new int[2];
        //target not found
        if(l==r){
            rnt[0]=-1; rnt[1]=-1; return rnt;
        }else{
            rnt[0]=l; rnt[1]=r-1; return rnt;
        }
    }
    
    //binary search the left index of target
    public int binarySearch(int left, int right, int[] A, int target){
        //terminate condition
        if(left>right) return left;
        if(A[left]==target) return left;
        
        //recursive search
        int mid = (left+right)/2;
        
        if(A[mid]>=target){
            return binarySearch(left,mid-1,A,target);
        }
        else
        return binarySearch(mid+1,right,A,target);
        
    }
}

/////////////////////////////////////////////////////////////////////////////
//Round 2: 12/31/2014
public class Solution {
    public int[] searchRange(int[] A, int target) {
        
        int left = binarySearch(A, target, 0, A.length-1);
        int right = binarySearch(A, target+1, 0, A.length-1);
        
        int[] rnt = new int[2];
        if(left==right){
            rnt[0] = -1;
            rnt[1] = -1;
        }
        else{
            rnt[0] = left;
            rnt[1] = right-1;
        }
        return rnt;
    }
    
    public int binarySearch(int[] A, int target, int left, int right){
        //if target value not found, will return target_right+1
        if(left>right) return left;
        if(A[left]==target) return left;
        
        int mid = (left+right)/2;
        if(A[mid]>=target)
            //find the leftmost index for value target
            return binarySearch(A, target, left, mid-1);
        else
            return binarySearch(A, target, mid+1, right);
    }
}
