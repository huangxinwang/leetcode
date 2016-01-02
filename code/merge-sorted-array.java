/**
 * Problem Statement: Merge Sorted Array 
 * 
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 */

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m+n-1;
        int i = m-1;
        int j = n-1;
        
        //fill in reverse order
        //larger one first
        while(i>=0 && j>=0){
            if(nums1[i]<nums2[j]){
                nums1[idx--] = nums2[j--];
            }else{
                nums1[idx--] = nums1[i--];
            }
        }
        
        //fill the rest of nums2
        while(j>=0){
            nums1[idx--] = nums2[j--];
        }
    }
}
