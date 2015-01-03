/**
 * Problem Statement: Median of Two Sorted Arrays 
 * Ref: http://www.acmerblog.com/leetcode-median-of-two-sorted-arrays-5330.html
 * 
 */

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        
        int m = A.length;
        int n= B.length;
        int sum = m+n;
        if(sum%2==1)
            return help(A, 0, m-1, B, 0, n-1, (m+n)/2);
        else return (help(A, 0, m-1, B, 0, n-1, (m+n)/2)+help(A, 0, m-1, B, 0, n-1, (m+n)/2-1))/2;
    }
    
    //find the (k+1)-th element
    public double help(int A[], int astart, int aend, int[] B, int bstart, int bend, int k){
        
        //check A and B's length
        int alen = aend-astart+1;
        int blen = bend-bstart+1;
        
        //special case
        if(alen==0)
            return B[bstart+k];
        if(blen==0)
            return A[astart+k];
        if(k==0)
            return A[astart] < B[bstart]? A[astart]: B[bstart];
          
        //get mid
        int amid = alen*k/(alen+blen);
        int bmid = k - amid-1;
        amid = astart+amid;
        bmid = bstart+bmid;
        
        if(A[amid] > B[bmid]){
            k = k-(bmid-bstart+1);
            aend = amid;
            bstart = bmid+1;
        }
        else{
            k = k-(amid-astart+1);
            bend = bmid;
            astart = amid+1;
        }
        
        return help(A, astart, aend, B, bstart, bend, k);
    }
}
