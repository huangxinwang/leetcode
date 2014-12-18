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
        
        int[] C = new int[m+n];
        
        //compare current value in two array and advance the pointer with the smaller one
        int i=0; int j=0;
        while(i<m && j<n){
            if(A[i] <= B[j]){
                C[i+j] = A[i];
                i++;
            } 
            else{
                C[i+j] = B[j];
                j++;
            }
        }
        
        //advance the pointer to the end
        while(i<m){
            C[i+n] = A[i];
            i++;
        }
        
        while(j<n){
            C[j+m] = B[j];
            j++;
        }
        
        //copy C to A
        for(i=0; i<m+n; i++){
            A[i] = C[i];
        }
        
        
    }
}
