/**
 * Problem Statement: 
 * Link:
 * Time:
 * Ref: http://answer.ninechapter.com/solutions/combination-sum-ii/
 * 
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 */


////////////////////////////////////////////////////////
// 2015/12/16
// Highlight: DFS
// Time: O(2^n)

 
 public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> rnt = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        boolean[] used = new boolean[candidates.length];
        int idx = 0;
        int sum = 0;
        dfs(rnt, curr, candidates, used, target, sum, idx);
        return rnt;
        
    }
    
    public void dfs(List<List<Integer>> rnt, List<Integer> curr, int[] candidates, boolean[] used, int target, int sum, int idx){
        if(sum==target){
            rnt.add(new ArrayList<Integer>(curr));
            return;
        }
        if(idx>=candidates.length) return;
        if(sum>target) return;
        
        //not use current number
        dfs(rnt, curr, candidates, used, target, sum, idx+1);
        
        //use current number
        if(idx!=0 && candidates[idx-1]==candidates[idx] && used[idx-1] ==false) return;
        used[idx] = true;
        curr.add(candidates[idx]);
        dfs(rnt, curr, candidates, used, target, sum+candidates[idx], idx+1);
        curr.remove(curr.size()-1);
        used[idx] = false;
        
        
    }
}
