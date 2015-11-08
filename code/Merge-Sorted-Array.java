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
    public void merge(int A[], int m, int B[], int n) {
        
        //put elements to A
        //note we start from the end in order not to overwrite elements in A
        while(m>=1 && n>=1){
            
            if(A[m-1] >= B[n-1]){
                A[m+n-1] = A[m-1];
                m--;
            }
            else{
                A[m+n-1] = B[n-1];
                n--;
            }
        }
        
        //if B hasn't traversed to the end, continue moving elements to A
        while(n>=1){
            A[m+n-1] = B[n-1];
            n--;
        }
    }
}

/////////////////////////////////////////////////////////////
//Round 2: 12/18/2014
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        
        //advance pointer from end to start in order not to override
        while(m>0 && n>0){
            if(A[m-1]<B[n-1]){
                A[m+n-1] = B[n-1];
                n--;
            }else{
                A[m+n-1] = A[m-1];
                m--;
            }
        }
        
        
        while(n>0){
            A[m+n-1] = B[n-1];
            n--;
        }
    }
}


/////////////////////////////////////////////////
// 2015/11/08
// Highlight: write from end to start in order not to override
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        while(m>0 && n>0){
            if(nums1[m-1]>nums2[n-1]){
                nums1[m+n-1] = nums1[m-1];
                m--;
            }else{
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }
        
        while(n>0){
            nums1[m+n-1] = nums2[n-1];
            n--;
        }
    }
}
