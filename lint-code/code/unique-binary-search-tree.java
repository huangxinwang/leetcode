public class Solution {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        // write your code here
        
        //count[i], use i as root, the # of unique BST
        int[] count = new int[n+1];
        if(n==0) return 1;
        if(n<=2) return n;
        count[0] = 1;
        count[1] = 1;
        count[2] = 2;
        
        
        for(int i=3; i<=n; i++){
            int curr = 0;
            //use j as root
            for(int j=1; j<=i; j++){
                int left = j-1;
                int right = i-j;
                curr += count[left]*count[right];
            }
            count[i] = curr;
        }
        
        return count[n];
    
    }
}
