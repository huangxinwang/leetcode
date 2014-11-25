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



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2, 11/25/2014
//Time complexity O(n)

public class Solution {
    public int findMin(int[] num) {
        
        if(num.length==1) return num[0];
        return binarySearch(0, num.length-1, num);
    }
    
    public int binarySearch(int left, int right, int[] num){
        //terminate case
        if(left >= right) return num[left];
        if(left+1 == right) return Math.min(num[left], num[right]);
        
        int mid = (left + right)/2;
        
        //recursive, 3 cases of num[mid] and num[right]
        //note that when num[mid] == num[right], neither side can be discarded
        if(num[mid] < num[right])
            return binarySearch(left, mid, num);
        else if(num[mid] > num[right])
            return binarySearch(mid, right, num);
        else return 
            Math.min( binarySearch(left, mid, num), binarySearch(mid, right, num));
    }
}
