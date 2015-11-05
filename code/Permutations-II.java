/**
 * Problem Statement: Permutations II 
 * Link:https://oj.leetcode.com/problems/permutations-ii/
 * Time:408 ms
 * Ref: http://fisherlei.blogspot.com/2012/12/leetcode-permutations-ii.html
 * 
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        //sort num so that duplicate numbers are continuous
        Arrays.sort(num);
        int[] used = new int[num.length];
        
        dfs(num, used, 0, tmp, rnt);
        
        return rnt;
    }
    
    public void dfs(int[] num, int[] used, int depth, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> rnt){
        
        if(depth==num.length){
            rnt.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for(int i=0; i<num.length; i++){
            if(used[i]==0){
                //not using an unused element, if it duplicates with its predecessor, and the predecessor is unused
                if(i>0 && num[i]==num[i-1] && used[i-1]==0)
                    continue;
                used[i]=1;
                ArrayList<Integer> newTmp = new ArrayList<Integer>(tmp);
                newTmp.add(num[i]);
                dfs(num, used, depth+1, newTmp, rnt);
                used[i]=0;
            }
        }
    }
}


////////////////////////////////////////////////////////////////////////////////
//Round 2: 12/30/2014
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        
        //sort the array
        Arrays.sort(num);
        
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        int[] used = new int[num.length];
        int depth = num.length;
        dfs(num, used, depth, tmp, rnt);
        return rnt;
    }
    
    public void dfs(int[] num, int[] used, int depth, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> rnt){
        if(depth==0){
            rnt.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for(int i=0; i<num.length; i++){
            
            //for duplicate numbers, if previous elements is not used, then skip current elements
            if(i>0 && num[i-1]==num[i] && used[i-1]==0) continue;
            if(used[i]==1) continue;
            
            used[i]=1;
            tmp.add(num[i]);
            dfs(num, used, depth-1, tmp, rnt);
            used[i]=0;
            tmp.remove(tmp.size()-1);
        }
    }
}


//////////////////////////////////////////////////////////////
// 2015/11/04
// Highlight: dfs, use an array to keep track of whether a number is used
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rnt = new ArrayList<List<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        int depth = 0;
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, depth, rnt ,curr);
        return rnt;
    }
    
    public void dfs(int[] nums, boolean[] used, int depth, List<List<Integer>> rnt, ArrayList<Integer> curr){
        if(depth == nums.length){
            rnt.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;
            if(i>0 && nums[i]==nums[i-1] && used[i-1]==false) continue;
            used[i] = true;
            curr.add(nums[i]);
            dfs(nums, used, depth+1, rnt, curr);
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
}
