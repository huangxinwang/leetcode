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
// 2015/12/07 
// Highlight: DFS
// Time: O(2^n)

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> rnt = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        List<Integer> curr = new ArrayList<Integer>();
        int idx = 0;
        int sum = 0;
        dfs(rnt, curr, candidates, used, idx, sum, target);
        return rnt;
    }
    
    public void dfs(List<List<Integer>> rnt, List<Integer> curr, int[] candidates, boolean[] used, int idx, int sum, int target){
        
        //terminate cases
        if(sum==target){
            rnt.add(new ArrayList<Integer>(curr));
            return;
        }
        if(sum>target) return;
        if(idx>=candidates.length) return;
        
       
            
        //skip current due to repeated value
        if(idx!=0 && candidates[idx-1]==candidates[idx] && used[idx-1]==false)
            dfs(rnt, curr, candidates, used, idx+1, sum, target);
        else{
            //add current
            curr.add(candidates[idx]);
            used[idx] = true;
            dfs(rnt, curr, candidates, used, idx+1, sum+candidates[idx], target);
            used[idx] = false;
            curr.remove(curr.size()-1);
           
            //jump to next
            dfs(rnt, curr, candidates, used, idx+1, sum, target);
        }
    }
    
}
