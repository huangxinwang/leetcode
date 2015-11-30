/**
 * Problem Statement: Subsets
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Link: https://oj.leetcode.com/problems/subsets/
 * 
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 */


public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        //return parameter
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        if(S.length==0) return rnt;
        ArrayList<Integer> curr = new ArrayList<Integer>();
        rnt.add(new ArrayList<Integer>());
        
        //change the size of subsets
        for(int i=1; i<=S.length; i++)
            dfs(S,0,0,i,rnt,curr);
        return rnt;
        
    }
    
    public void dfs(int[] S, int start, int depth, int size, ArrayList<ArrayList<Integer>> rnt, ArrayList<Integer> curr){
        //finish condition
        if(depth==size){
            //sort list
            ArrayList<Integer> finish = new ArrayList<Integer>(curr);
            Collections.sort(finish);
            rnt.add(finish);
            return;
        }
        
        //dfs
        for(int i=start; i<S.length; i++){
            ArrayList<Integer> tmp = new ArrayList<Integer>(curr);
            tmp.add(S[i]);
            dfs(S, i+1, depth+1, size, rnt, tmp);
        }
    }
}

///////////////////////////////////////////////////////////////////////////
//Round 2: 12/20/2014
//Time complexity: O(2^n)

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        rnt.add(new ArrayList<Integer>());
        
        //for each elements in S, using existing subset + S[i] to create new subset
        for(int i=0; i<S.length; i++){
            int currsize = rnt.size();
            for(int j=0; j<currsize; j++){
                ArrayList<Integer> curr = new ArrayList<Integer>(rnt.get(j));
                curr.add(S[i]);
                rnt.add(curr);
            }
        }
        
        return rnt;
    }
}


///////////////////////////////////////////////////////
// 2015/11/07
// Highlight: dfs, find combinations
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        int idx = 0;
        
        List<List<Integer>> rnt = new ArrayList<List<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        
        dfs(rnt, curr, idx, nums);
        rnt.add(new ArrayList<Integer>());
        return rnt;
    }
    
    //dfs to find all combinations
    public void dfs(List<List<Integer>> rnt, ArrayList<Integer> curr, int idx, int[] nums){
        
        //even not reach idx, current subset could be added to rnt !!
        if(curr.size()!=0){
                rnt.add(new ArrayList<Integer>(curr));
        }
            
        if(idx>=nums.length){
            
            return;
        }
        
        for(int i = idx; i<nums.length; i++){
            curr.add(nums[i]);
            dfs(rnt, curr, i+1, nums);
            curr.remove(curr.size()-1);
        }
    }
}
