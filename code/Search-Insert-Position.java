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

////////////////////////////////////////////////////////////
//Round 2: 12/31/2014
public class Solution {
    
    public int searchInsert(int[] A, int target) {
        return binarySearch(A, target, 0, A.length-1);
    }
    
    //binary search the position
    public int binarySearch(int[] A, int target, int left, int right){
        if(left>right) return left;
        if(A[left]==target) return left;
        
        int mid = (left+right)/2;
        if(A[mid]==target) return mid;
        if(A[mid]>target)
            return binarySearch(A, target, left, mid-1);
        else 
            return binarySearch(A, target, mid+1, right);
    }
}

///////////////////////////////////////////////////////////
// 11/04/2015
// Highlight: recursive search
public class Solution {
    public int searchInsert(int[] nums, int target) {
        return help(nums, target, 0, nums.length-1);
    }
    
    public int help(int[] nums, int target, int left, int right){
        //decide return index
        if(left>=right){
            if(nums[left] >= target) return left;
            else return left+1;
        }
        
        //recursive explore
        int mid = (left+right)/2;
        if(nums[mid] > target)
            return help(nums, target, left, mid-1);
        else if(nums[mid] < target)
            return help(nums, target, mid+1, right);
        //if nums[mid]==target, recursive search left side
        else return help(nums, target, left, mid);
    }
}
