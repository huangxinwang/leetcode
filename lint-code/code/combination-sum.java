public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        Arrays.sort(candidates);
        int start = 0;
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        int curr = 0;
        dfs(rnt, tmp, candidates, start, curr, target);
        return rnt;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> rnt, ArrayList<Integer> tmp, int[] candidates, int start, int curr, int target){
        if(curr==target){
            rnt.add(new ArrayList<Integer>(tmp));
            return;
        }
        if(start==candidates.length || curr>target) return;
        
        for(int i = start; i<candidates.length; i++){
            ArrayList<Integer> newtmp = new ArrayList<Integer>(tmp);
            newtmp.add(candidates[i]);
            dfs(rnt, newtmp, candidates, i, curr+candidates[i], target);
        }
    }
}
