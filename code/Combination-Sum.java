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


public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        
        //declare parameters
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        int sum = 0;
        int currIndex = 0;
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        
        //sort array
        Arrays.sort(candidates);
                
        //dfs find all solutions      
        dfs(currIndex, sum, target, candidates, tmp, rnt);
        
        return rnt;
    }
    
    public void dfs(int currIndex, int sum, int target, int[] candidates, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> rnt){
        
        //terminate condition
        if(sum>target)  return;
        if(sum==target){
            rnt.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        //add current number
        if(currIndex<candidates.length){
            int newSum = sum + candidates[currIndex];
            ArrayList<Integer> newTmp = new ArrayList<Integer>(tmp);
            newTmp.add(candidates[currIndex]);
            dfs(currIndex, newSum, target, candidates, newTmp, rnt);
        }
        
        //jump to next number
        if(currIndex<candidates.length-1){
            dfs(currIndex+1, sum, target, candidates, tmp, rnt);
        }
    }
}



//////////////////////////////////////////////////////////
// 2015/11/03
// Highlight: dfs
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> rnt = new ArrayList<List<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        int sum = 0;
        int depth = 0;
        dfs(candidates, target, sum, rnt, curr, depth);
        return rnt;
    }
    
    public void dfs(int[] candidates, int target, int sum, List<List<Integer>> rnt, ArrayList<Integer> curr, int depth){
        if(sum==target){
            ArrayList<Integer> newLsit = new ArrayList<Integer>(curr);
            rnt.add(newLsit);
            return;
        }
        if(depth>=candidates.length || sum>target){
            return;
        }
        
        //add current value at index depth
        curr.add(candidates[depth]);
        dfs(candidates, target, sum+candidates[depth], rnt, curr, depth);
        curr.remove(curr.size()-1);
        
        //not add current value at depth
        //skip same value
        int lastVal = candidates[depth];
        while(depth<candidates.length-1 && candidates[depth+1]==lastVal){
           depth++;
        }
        depth++;
        dfs(candidates, target, sum, rnt, curr, depth);
    }
}
