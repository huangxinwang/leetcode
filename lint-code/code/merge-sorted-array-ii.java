class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int idx = m+n-1;
        int aidx = m-1;
        int bidx = n-1;
        while(aidx>=0 && bidx>=0){
            if(A[aidx] >= B[bidx]){
                A[idx] = A[aidx];
                aidx--;
            }else{
                A[idx] = B[bidx];
                bidx--;
            }
            idx--;
        }
        
        while(bidx>=0){
            A[idx] = B[bidx];
            bidx--;
            idx--;
        }
    }
}
