class Solution {
    /**
     * @param A: An integer array.
     * @return an integer array
     */
    public int[] rerange(int[] A) {
        // write your code here
        
        
        //partition array into negative and positive
        int left = 0;
        int right = A.length-1;
        int leftCount = 0;
        while(left<right){
            while(A[left]<0 && left<A.length-1){
                left++;
                leftCount++;
            }
            while(A[right]>0 && right>0)
                right--;
            if(left<right){
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
                left++;
                right--;
                leftCount++;
            }
        }
        
        //if more negative than positive, then let the first number be negative, i.e., i starts from 1
        int i = 0;
        if(A.length%2==1 && leftCount>A.length/2) i =1;
        
        //inteleave negative and positive
        for(; i<A.length/2; i+=2){
            int tmp = A[i];
            A[i] = A[A.length-1-i];
            A[A.length-1-i] = tmp;
        }
        
        //if there are more negative or positive, shift the value to the end of the array
        if(A.length%2 == 1){
            int tmp = A[A.length/2];
            for( i=A.length/2+1; i<A.length; i++){
                A[i-1] = A[i];
            }
            A[A.length-1] = tmp;
        }
       
      
        
        return A;
   }
}
