class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int n = A.length-1;
        int m = B.length-1;
        
        if( (n+m)%2==0){
            return (getMedian(A, 0, n, B, 0,m, (n+m)/2) + getMedian(A,0, n, B, 0,m, (n+m)/2+1))/2.0;
        }
        else return getMedian(A, 0, n, B, 0, m, (n+m)/2+1)/2.0;
    }
    
    public double getMedian(int[] A, int leftA, int rightA, int[] B, int leftB, int rightB, int k){
        
        if(leftA>rightA) return B[leftB+k-1];
        if(leftB>rightB) return A[leftA+k-1];
        if(k<=1) return A[leftA] <= B[leftB] ? A[leftA] : B[leftB];
        
        
        int midA = leftA + (rightA - leftA)/2;
        int midB = leftB + (rightB - leftB)/2;
        
        if(A[midA] <= B[midB]){
            if(midA-leftA+midB-leftB+1 >=k)
                return getMedian(A, leftA, rightA, B, leftB, midB-1, k);
            else  return getMedian(A, midA+1, rightA, B, leftB, rightB, k-(midA-leftA+1));
             
        }
        else{
            if(midA-leftA+midB-leftB+1 >= k)
               return getMedian(A, leftA, midA-1, B, leftB, rightB, k);
                
            else
               return getMedian(A, leftA, rightA, B, midB+1, rightB,k-(midB-leftB+1));
        }
    }
    
}

