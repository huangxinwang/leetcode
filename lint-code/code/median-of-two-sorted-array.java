


class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int n = A.length;
        int m = B.length;
        
        if( (n+m)%2==0){
            double m1 = getMedian(A, 0, n, B, 0, m, (n+m)/2);
            double m2 = getMedian(A,0, n, B, 0,m, (n+m)/2+1);
            //System.out.println(m1+" "+m2);
            return (m1+m2)/2.0;
        }
        else return getMedian(A, 0, n, B, 0, m, (n+m+1)/2);
    }
    

    //right index is excluded
    //use length to judge whether exceed k or not
    public double getMedian(int[] A, int leftA, int rightA, int[] B, int leftB, int rightB, int k){
  
        if(leftA>=rightA) return B[leftB+k-1];
        if(leftB>=rightB) return A[leftA+k-1];
        if(k<=1) return A[leftA] <= B[leftB] ? A[leftA] : B[leftB];
        
        int n = (rightA-leftA);
        int m = (rightB-leftB);
        
        int midA = (rightA + leftA)/2;
        int midB = (rightB + leftB)/2;
        
        
        if(n/2+m/2+1 >= k)
        {
            if(A[midA] < B[midB])
                return getMedian(A, leftA, rightA, B, leftB, midB, k);
            else
                return getMedian(A, leftA, midA, B, leftB, rightB, k);
        }
        else
        {
            if(A[midA] < B[midB])
                return getMedian(A, midA+1, rightA, B, leftB, rightB, k-n/2-1);
            else
                return getMedian(A, leftA, rightA, B, midB+1, rightB, k-m/2-1);
        }
        
    }
    
}
