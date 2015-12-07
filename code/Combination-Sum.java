/**
 * Problem Statement: Combination Sum
 * Link:https://oj.leetcode.com/problems/combination-sum/
 * Time:600ms
 * 
 * Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * 
 * 
 */


//////////////////////////////////////////////////////
// 2015/12/07
// Highlight: DFS

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rnt = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        Arrays.sort(candidates);
        int sum = 0;
        int idx = 0;
        dfs(rnt, curr, candidates, target, idx, sum);
        return rnt;
    }
    
    public void dfs(List<List<Integer>> rnt, List<Integer> curr, int[] candidates, int target, int idx, int sum){
        
        //terminate cases
        if(sum==target){
            rnt.add(new ArrayList<Integer>(curr));
            return;
        }
        
        if(sum>target) return;
        if(idx>=candidates.length) return;
        
        //add current number
        curr.add(candidates[idx]);
        dfs(rnt, curr, candidates, target, idx, sum+candidates[idx]);
        curr.remove(curr.size()-1);
        
        //jump to next number, skip repeated ones
        while(idx<candidates.length-1 && candidates[idx+1] == candidates[idx]){
            idx++;
        }
        if(idx<candidates.length-1)
            dfs(rnt, curr, candidates, target, idx+1, sum);
    }
}
