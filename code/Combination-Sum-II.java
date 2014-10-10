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


public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
       
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        //special case
        if(num.length<1) return rnt;
         
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(num);
        int start = 0;
        
        //dfs find all combinations
        dfs(num, target, start, tmp, rnt);
        
        return rnt;
    }
    
    public void dfs(int[] num, int sum, int start, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> rnt){
        
        //terminate condition
        if(sum==0){
            rnt.add(new ArrayList<Integer>(tmp));
        }
        if(start==num.length || sum<0)
            return;
        
        //TODO: discuss with Hua  
        int prev = -1;
        for(int i=start; i<num.length; i++){
            if(num[i]!=prev){
                tmp.add(num[i]);
                dfs(num, sum-num[i], i+1, tmp, rnt);
                prev = num[i];
                tmp.remove(tmp.size()-1);
            }
        }
       
    }
}
