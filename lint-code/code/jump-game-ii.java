////////////////////////////// 
//Complexity: O(n^2)

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

///////////////////////////////////////
//Complexity: O(n)
public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        int[] min = new int[A.length];
        
        int maxCover = 0;
   
        
        for(int i=0; i<A.length && i<=maxCover; i++){
            int newCover = A[i] + i;
            
            //for each j after i, the first time to reach j is the optimal minimum step
            //so update the min of j, the range of j is from maxCover+1...newCover
            if(newCover>maxCover){
                for(int j=maxCover+1; j<=Math.min(newCover, A.length-1); j++){
                    min[j] = min[i]+1;
                }
                maxCover = newCover;
            }
            
            if(maxCover>=A.length) break;
        }
        
        return min[A.length-1];
    }
}
