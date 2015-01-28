public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if(n==1) return 1;
        int[] count = new int[n];
        count[0] = 1;
        count[1] = 2;
        for(int i=2; i<n; i++){
            count[i] = count[i-1] + count[i-2];
        }
        
        return count[n-1];
        
    }
}
