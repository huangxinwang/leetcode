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