public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        int start = 0;
        int sum = 0;
        ArrayList<Integer> curr = new ArrayList<Integer>();
        
        dfs(rnt, curr, A, target, k, 0, 0);
        
        return rnt;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> rnt, ArrayList<Integer> curr, int[] A, int target, int k, int sum, int start){
        if(k==0 && sum==target){
            rnt.add(new ArrayList<Integer>(curr));
        }
        
        if(k==0 || start==A.length)
            return;
            
        for(int i=start; i<A.length; i++){
            curr.add(A[i]);
            dfs(rnt, curr, A, target, k-1, sum+A[i], i+1);
            curr.remove(curr.size()-1);
        }
    }
}
