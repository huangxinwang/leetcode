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


/////////////////////////////////////////////////////////////////////////////////////////////////////////
// 2015/11/02
// Highlight: discuss by cases
public class Solution {
    
    public int[] searchRange(int[] nums, int target) {
        int[] rnt = new int[2];
    
        return helper(nums, 0, nums.length-1, target);
        
    }
    
    public int[] helper(int[] nums, int left, int right, int target){
        
        int[] rnt = new int[2];
        rnt[0] = -1;
        rnt[1] = -1;
        
         if(left>=right){
            
            if(nums[left]==target){
                rnt[0] = left;
                rnt[1] = left;
                if(right>=0 && nums[right]==target) rnt[1] = right;
                return rnt;
                
            }
            return rnt;
        }
        
        if(nums[left]==target && nums[right]==target){
            rnt[0] = left;
            rnt[1] = right;
            return rnt;
        }
       
        
        int mid = (left+right)/2;
        //Case 1: go to left
        if(nums[mid]>target){
            return helper(nums, left, mid-1,  target);
        }
        //Case 2: go to right
        else if(nums[mid]<target){
             return helper(nums, mid+1, right,  target);
        }
        //Case 3: go to both sides, and combine the results
        else{
            int[] tmp1 = helper(nums, left, mid-1, target);
            int[] tmp2 = helper(nums, mid+1, right,  target);
          
            rnt[0] = mid;
            rnt[1] = mid;
            if(tmp1[0]!=-1) rnt[0] = tmp1[0];
            if(tmp2[1]!=-1) rnt[1] = tmp2[1];
            return rnt;
        }
    }
}
