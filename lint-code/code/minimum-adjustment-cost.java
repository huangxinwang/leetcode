public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        
       
       //cost[i][j] denotes the minimum cost of modifying 0...i and A[i] is adjust to j
       int[][] cost = new int[A.size()+1][101];
     
       for(int i=1; i<=100; i++)
           cost[1][i] = Math.abs(i-A.get(0));
           
       for(int i=1; i<=A.size(); i++){
           for(int j=0; j<=100; j++){
               int min = Integer.MAX_VALUE;
               //find the minimum with the given range [j-target, j+target]
               for(int k =0; k<=target; k++){
                   if(j+k<=100){
                       int val = cost[i-1][j+k] + Math.abs(j-A.get(i-1));
                       if(val < min) min = val;
                   }
                   if(j-k>=0){
                       int val = cost[i-1][j-k] + Math.abs(j-A.get(i-1));
                       if(val < min) min = val;
                   }
               }
               cost[i][j] = min;
           }
       }
       
       int min = Integer.MAX_VALUE;
       for(int i=0; i<=100; i++){
           if(min > cost[A.size()][i])
                min = cost[A.size()][i];
       }
       
       return min;
    }
}
