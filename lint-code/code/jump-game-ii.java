public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        int[] min = new int[A.length];
        for(int i=0; i<A.length; i++){
            min[i] = A.length;
        }
        
        min[0] = 0;
        for(int i=0; i<A.length; i++){
            for(int j=0; j<i; j++){
                if(j+A[j]>=i){
                    min[i] = Math.min(min[i], min[j]+1);
                }
            }
        }
        
        return min[A.length-1];
    }
}
