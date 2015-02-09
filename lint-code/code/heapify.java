public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        
        //from back to 
        for(int i=A.length/2; i>=0; i--){
            help(A, i);
        }
        
    }
    
    public void help(int[] A, int idx){
        int leftIdx = idx*2+1;
        int rightIdx =  idx*2+2;
        if(leftIdx> A.length-1) return;
        if(rightIdx > A.length-1) rightIdx = leftIdx;
        
        int minIdx = A[leftIdx] <= A[rightIdx] ? leftIdx: rightIdx;
        
        if(A[idx] > A[minIdx]){
            int tmp = A[idx];
            A[idx] = A[minIdx];
            A[minIdx] = tmp;
            help(A, minIdx);
        }
    }
}
