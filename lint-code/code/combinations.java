public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		// write your code here
		ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		int start = 1;
		dfs(rnt, tmp, n, start, k);
		return rnt;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> rnt, ArrayList<Integer> tmp, int n, int start, int depth){
        if(depth==0){
            rnt.add(new ArrayList<Integer>(tmp));
            return;
        }
        if(start>n) return;
        
        for(int i=start; i<=n; i++){
            tmp.add(i);
            dfs(rnt, tmp, n, i+1, depth-1);
            tmp.remove(tmp.size()-1);
        }
    }
}
