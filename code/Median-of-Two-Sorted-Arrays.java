/**
 * Problem Statement: Median of Two Sorted Arrays 
 * Ref: http://www.acmerblog.com/leetcode-median-of-two-sorted-arrays-5330.html
 * 
 */

/////////////////////////////////////////////
// 2015/12/20
// Highlight: divide and conquer
// Time complexity: O(log(m+n))
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1+len2;
        if(total%2==1){
            return help(nums1, 0, len1-1, nums2, 0, len2-1, total/2); //find the kth one
        }else{
            double val1 = help(nums1, 0, len1-1, nums2, 0, len2-1, total/2);
            double val2 = help(nums1, 0, len1-1, nums2, 0, len2-1, total/2-1);
            return (val1+val2)/2;
        }
    }
    
    //Find the k-th element (index is k)
    public double help(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k){
        int len1 = end1-start1+1;
        int len2 = end2-start2+1;
        if(len1==0) return nums2[start2+k];
        if(len2==0) return nums1[start1+k];
       
        if(k==0) return Math.min(nums1[start1], nums2[start2]);
        
        //find mid of nums1, note that the mid is porportional to "k" and "len1/(len1+len2)"
        int mid1 = len1*k/(len1+len2);
        int mid2 = start2 + k-mid1-1;
        mid1 = start1 + mid1;
        
        int val1 = nums1[mid1];
        int val2 = nums2[mid2];
        //Case 1: discard left part of nums1 (i.e., find the minimum x elements of nums)
        if(val1<val2) return help(nums1, mid1+1, end1, nums2, start2, end2, k-(mid1-start1)-1);
        //Case 2: discard left part of nums2
        else if(val1>val2) return help(nums1, start1, end1, nums2, mid2+1, end2, k-(mid2-start2)-1);
        //Case 3
        else return val1;
    }
}




/////////////////////////////////////////////////////////
// 10/03/2015
// Time complexity: O(log(n+m))
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        //judge whether odd or even
        if((n+m)%2!=0){
            return findKthElement(nums1, nums2,0,n-1,0,m-1,(n+m)/2);
        }else{
            double result1 = findKthElement(nums1, nums2,0,n-1,0,m-1,(n+m)/2);
            double result2 = findKthElement(nums1, nums2,0,n-1,0,m-1,(n+m)/2-1);
            return (result1+result2)/2.0;
        }
    }
    
    public double findKthElement(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2, int k){
        int len1 = end1-start1+1;
        int len2 = end2-start2+1;
        if(len1==0) return nums2[k+start2];
        if(len2==0) return nums1[k+start1];
        
        int mid1 = len1*k/(len1+len2);
        int mid2 = k - mid1-1;
        
        mid1 = mid1+start1;
        mid2 = mid2+start2;
        
        if(k==0){
            return nums1[start1]<nums2[start2]? nums1[start1]:nums2[start2];
        }
        
        //remove parts of each array, and update k
        if(nums1[mid1]<nums2[mid2]){
            k = k-(mid1-start1)-1;
            start1 = mid1+1;
            end2 = mid2;
        }else{
            k = k-(mid2-start2)-1;
            start2 = mid2+1;
            end1 = mid1;
        }
        
        return findKthElement(nums1, nums2, start1, end1, start2, end2, k);
        
    }
}
