/**
 * Problem Statement: Find Minimum in Rotated Sorted Array II 
 * Link: https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * Hardness: **
 * 
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * 
 */

public class Solution {
    
    public int findMin(int[] num) {
        
        //binary search
        return binarySearch(0, num.length-1, num);
        
    }
    
    public int binarySearch(int leftIndex, int rightIndex, int[] num){
        //terminate condition
        if(leftIndex+1 >= rightIndex) return Math.min(num[leftIndex], num[rightIndex]);
        
        //calculate left, mid, right value
        int midIndex = (leftIndex+rightIndex)/2;
        int left = num[leftIndex];
        int right = num[rightIndex];
        int mid = num[midIndex];
        
        //search both sides when left==mid==right
        if(left==mid && mid==right) return Math.min(binarySearch(leftIndex, midIndex, num), binarySearch(midIndex, rightIndex, num));
        
        //same procedure with no duplications
        if(right<=left && left<=mid) return binarySearch(midIndex, rightIndex, num);
        else return binarySearch(leftIndex, midIndex, num); 
    }
}