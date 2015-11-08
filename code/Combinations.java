/**
 * Problem Statement: Combinations
 * Link: https://oj.leetcode.com/problems/combinations/
 * 
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * 
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        
        //define parameters
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        
        //dfs
        dfs(rnt, tmp, 1, k, n);
        return rnt;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> rnt, ArrayList<Integer> tmp, int start, int remain, int n){
        //Case1: terminate condition, find target
        if(remain==0){
            rnt.add(new ArrayList<Integer>(tmp));
            return;
        }
        //Case2: terminate condition, not find target
        if(start>n) return;
        //DFS
        for(int i=start; i<=n; i++){
            ArrayList<Integer> curr = new ArrayList<Integer>(tmp);
            curr.add(i);
            dfs(rnt, curr, i+1, remain-1, n);
        }
    }
}

////////////////////////////////////////////////////////////////////////
//Round 2: 12/21/2014
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        
        dfs(1, k, n, rnt, tmp);
        
        return rnt;
    }
    
    //dfs find all possible solution
    public void dfs(int start, int depth, int n, ArrayList<ArrayList<Integer>> rnt, ArrayList<Integer> tmp){
        if(depth==0){
            rnt.add(new ArrayList<Integer>(tmp));
            return;
        }
        if(start>n) return;
        
        for(int i=start; i<=n; i++){
            tmp.add(i);
            dfs(i+1, depth-1, n, rnt, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}


///////////////////////////////////////////////////////////////
// 2015/11/07
// Highlight: dfs
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = i+1;
        List<List<Integer>> rnt = new ArrayList<List<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        int idx = 0;
        dfs(rnt, curr, k, nums, idx);
        
        return rnt;
    }
    
    //dfs find all combinations
    public void dfs(List<List<Integer>> rnt, ArrayList<Integer> curr, int depth, int[] nums, int idx){
        if(depth==0){
            rnt.add(new ArrayList<Integer>(curr));
            return;
        }
        
        if(idx>=nums.length) return;
        
        for(int i=idx; i<nums.length; i++){
            curr.add(nums[i]);
            dfs(rnt, curr, depth-1, nums, i+1);
            curr.remove(curr.size()-1);
        }
    }
}
