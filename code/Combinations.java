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

//////////////////////////////////
// 2015/12/07
// Highlight: DFS
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rnt = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        int idx = 0;
        dfs(rnt, curr, idx, n, k);
        return rnt;
    }
    
    public void dfs(List<List<Integer>> rnt, List<Integer> curr, int idx, int n, int k){
        //terminate cases
        if(k==0){
            rnt.add(new ArrayList<Integer>(curr));
            return;
        }
        if(idx>=n) return;
        
        //use current number
        curr.add(idx+1);
        dfs(rnt, curr, idx+1, n, k-1);
        curr.remove(curr.size()-1);
        
        //skip current number
        dfs(rnt, curr, idx+1, n, k);
    }
}
