/**
 * Problem Statement: Permutations
 * Link:https://oj.leetcode.com/problems/permutations/
 * Time: 456 ms
 * 
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 */


public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        int[] used = new int[num.length];
        
        dfs(rnt, tmp, num, used, 0);
        
        return rnt;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> rnt, ArrayList<Integer> tmp, int[] num, int[] used, int depth){
        
        //terminate condition
        if(depth==num.length){
            rnt.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        //depth first search
        for(int i=0; i<num.length; i++){
            //skip elements that have been added to tmp
            if(used[i]==1) continue;
            
            //add new elements to tmp
            used[i] = 1;
            
            ArrayList<Integer> newTmp = new ArrayList<Integer>(tmp);
            newTmp.add(num[i]);
            dfs(rnt, newTmp, num, used, depth+1);
            
            used[i] = 0;
        }
    }
}