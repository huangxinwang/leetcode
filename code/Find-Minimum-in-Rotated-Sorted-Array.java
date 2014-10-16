/**
 * Problem Statement: Find Minimum in Rotated Sorted Array
 * Link: https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * Hardness: **
 * Time: 416 ms
 * 
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 */


public class Solution {
    public int findMin(int[] num) {
        
        if(num.length==1) return num[0];
        
        int left = 0;
        int right = num.length;
        
        //binary search to find the mininum
        return help(0,right-1,num);
    }
    
    public int help(int left, int right, int[] num){
        
        //terminate condition: when there are only two number left 
        if(num[left]<num[right] && left+1==right) return num[left];
        if(num[left]>num[right] && left+1==right) return num[right];
        
        //binary search
        int mid = (left+right)/2;
        
        //there are 3 cases, and only in case 1 that you search in the right part
        //case1: right<left<mid
        //case2: mid<right<left
        //case3: left<mid<right
        if(num[left]<num[mid] && num[right]<num[left])
            return help(mid, right, num);
        else return help(left,mid,num);
    }
}