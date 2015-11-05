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

//////////////////////////////////////////////////////////
//Round 2: 12/30/2014
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        int[] used = new int[num.length];
        int depth = num.length;
        
        dfs(num, used, depth, tmp, rnt);
        
        return rnt;
    }
    
    //dfs find all solution
    public void dfs(int[] num, int[] used, int depth, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> rnt){
        if(depth==0){
            rnt.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for(int i=0; i<num.length; i++){
            //skip if current number is used
            if(used[i]==1) continue;
            used[i] = 1;
            tmp.add(num[i]);
            dfs(num, used, depth-1, tmp, rnt);
            used[i] = 0;
            tmp.remove(tmp.size()-1);
        }
    }
}



///////////////////////////////////////////////////////////////
// 2015/11/04
// Hilight: dfs
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rnt = new ArrayList<List<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        int depth = 0;
        
        dfs(nums, used, depth, rnt, curr);
        
        return rnt;
    }
    
    public void dfs(int[] nums, boolean[] used, int depth, List<List<Integer>> rnt, ArrayList<Integer> curr){
        if(depth==nums.length){
            rnt.add(new ArrayList<Integer>(curr));
        }
        
        for(int i=0; i<used.length; i++){
            if(used[i]) continue;
            
            curr.add(nums[i]);
            used[i] = true;
            dfs(nums, used, depth+1, rnt, curr);
            used[i] = false;
            curr.remove(curr.size()-1);
        }
    }
}
