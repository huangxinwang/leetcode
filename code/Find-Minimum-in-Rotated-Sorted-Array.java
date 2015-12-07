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


/////////////////////////////////////////
// 2015/12/07
public int findMin(int[] num) {
	return findMin(num, 0, num.length - 1);
}
 
public int findMin(int[] num, int left, int right) {
	if (left == right)
		return num[left];
	if ((right - left) == 1)
		return Math.min(num[left], num[right]);
 
	int middle = left + (right - left) / 2;
 
	// not rotated
	if (num[left] < num[right]) {
		return num[left];
 
	// go right side
	} else if (num[middle] > num[left]) {
		return findMin(num, middle, right);
 
	// go left side
	} else {
		return findMin(num, left, middle);
	}
}

////////////////////////////////////////////////////////////////////////////////////

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


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Round 2, 11/25/2014
public class Solution {
    public int findMin(int[] num) {
        
        //terminate case
        if(num.length == 1) return num[0];
        
        return binarySearch(0, num.length-1, num);
        
    }
    
    public int binarySearch(int left, int right, int[] num){
        
        //terminate cases
        if(left >= right) return num[left];
        if(left+1 == right) return Math.min(num[left], num[right]);
        
        
        int mid = (left+right)/2;
        
        //binary search
        //different from normal binary search, we search the right part only when left< mid && mid>right 
        if(num[left] < num[mid] && num[mid] > num[right]){
            return binarySearch(mid, right, num);
        }else
            return binarySearch(left, mid, num);
    }
}


///////////////////////////////////////////////////
// 2015/11/14
// Highlight: discuss cases
public class Solution {
    public int findMin(int[] nums) {
        return help(nums, 0, nums.length-1);
    }
    
    //there are 3 cases
    // l<m<r
    // l<m, m>r, l>r
    // l>m, m>r, l>r
    public int help(int[] nums, int left, int right){
        if(left>=right) return nums[Math.min(left, right)];
        int mid = (left+right)/2;
        if(nums[left] <= nums[mid] && nums[mid] >= nums[right] && nums[left] > nums[right]){
            return help(nums, mid+1, right);
        }
        else return help(nums, left, mid);
    }
}
