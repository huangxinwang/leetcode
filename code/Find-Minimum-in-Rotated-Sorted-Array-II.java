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


///////////////////////////////////////////////////
// 2015/12/07
public int findMin(int[] num) {
    return findMin(num, 0, num.length-1);
}
 
public int findMin(int[] num, int left, int right){
    if(right==left){
        return num[left];
    }
    if(right == left +1){
        return Math.min(num[left], num[right]);
    }
    // 3 3 1 3 3 3
 
    int middle = (right-left)/2 + left;
    // already sorted
    if(num[right] > num[left]){
        return num[left];
    //right shift one
    }else if(num[right] == num[left]){
        return findMin(num, left+1, right);
    //go right    
    }else if(num[middle] >= num[left]){
        return findMin(num, middle, right);
    //go left    
    }else{
        return findMin(num, left, middle);
    }
}


///////////////////////////////////
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


////////////////////////////////////////////////////////////
// 2015/11/14
// Highlight: when nums[mid] == nums[right], it is not sure whether to go left or right parts, so we advance only one step (by right--)
// Time complexity: worst-case O(n)
public class Solution {
    public int findMin(int[] nums) {
        return help(nums, 0, nums.length-1);
    }
    
    public int help(int[] nums, int left, int right){
        if(left>=right){
            if(left<nums.length) return nums[left];
            else return nums[right];
        }
        
        int mid = (left+right)/2;
        //note that the right end is mid, e.g., [3 ,1 ,3], if use mid-1, then 1 will be ignored
        if(nums[mid]<nums[right]){
            return help(nums, left, mid);
        }
        else if(nums[mid]>nums[right]){
            return help(nums, mid+1, right);
        }
        else return help(nums, left, right-1);
    }
}
