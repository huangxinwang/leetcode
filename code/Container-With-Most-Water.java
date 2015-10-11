/**
 * Problem Statement: Container With Most Water 
 * Link:https://oj.leetcode.com/problems/container-with-most-water/
 * Time:
 * Ref: http://fisherlei.blogspot.com/2013/01/leetcode-container-with-most-water.html
 * 
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */


public class Solution {
    public int maxArea(int[] height) {
        
       int len = height.length;
       //special case
       if(len<=1) return 0;
       
       //running time O(n)
       //advance start and end according to their relative value
       int start = 0; 
       int end = len-1;
       int max = 0;
       while(start<end){
           int area = Math.min(height[start], height[end])*(end-start);
           if(max < area) max = area;
           if(height[start] < height[end]) start++;
           else end--;
       }
       
       return max;
    }
}


///////////////////////////////////////////////
//Round 2: 1/8/2015
public class Solution {
    public int maxArea(int[] height) {
        
        int max = 0;
        int start = 0;
        int end = height.length-1;
        while(start<end){
            int curr = Math.min(height[start], height[end])*(end-start);
            max = max>curr?max : curr;
            //logic
            if(height[start] < height[end])
                start++;
            else end--;
        }
        
        return max;
    }
}


/////////////////////////////////////////////////////
// 2015-10-10
// Highlight: advance left or right pointer
public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while(left<right){
            int curr_height = Math.min(height[left], height[right]);
            int area = (right-left)*curr_height;
            max = max > area ? max : area;
            //advance left or right pointer
            if(height[left]<height[right]){
                left++;
            }else right--;
        }
        return max;
    }
}
