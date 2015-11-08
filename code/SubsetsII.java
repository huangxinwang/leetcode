/**
 * Problem Statement: Subsets II 
 * 
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 */
 
 
/**
 * Reference: http://blog.csdn.net/u013027996/article/details/20237271
 */


public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        
        
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        if(num.length==0) return rnt;
        
        Arrays.sort(num);
        //dfs, traverse from 0, sublist contains i elements
        for(int i=1; i<num.length+1; i++){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            dfs(rnt, tmp, num, 0, i);
        }
        rnt.add(new ArrayList<Integer>());
        return rnt;
    }
    
    //dfs 
    
    public void dfs(ArrayList<ArrayList<Integer>> rnt, ArrayList<Integer> tmp, int[] num, int start, int k){
        //add all sublist which contian k elements
        if(tmp.size()==k){
            rnt.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        ArrayList<Integer> existNum = new ArrayList<Integer>();
        for(int i=start; i<num.length; i++){
            
            if(existNum.contains(num[i])){
                continue;
            }
            
            existNum.add(num[i]);
            tmp.add(num[i]);
            dfs(rnt, tmp, num, i+1, k);
            tmp.remove(tmp.size()-1);
        }
    }
}


/////////////////////////////////////////////////////////////////////////////
//Round 2: 12/17/2014
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        
        Arrays.sort(num);
        
        //enumerate different possible length of subset
        //dfs enumerate
        for(int i=1; i<= num.length; i++){
            dfs(i, 0, rnt, tmp, num);
        }
        
        
        
        rnt.add(new ArrayList<Integer>());
        return rnt;
    }
    
    public void dfs(int depth, int start, ArrayList<ArrayList<Integer>> rnt, ArrayList<Integer> tmp, int[] num){
        
        if(tmp.size()==depth){
            rnt.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        ArrayList<Integer> existNum = new ArrayList<Integer>();
        
        for(int i=start; i<num.length; i++){
            
            //this is different from num[i-1]==num[i]
            //since this is dfs procedure
            if(existNum.contains(num[i])) continue;
            
            
            existNum.add(num[i]);
            tmp.add(num[i]);
            dfs(depth, i+1, rnt, tmp, num);
            tmp.remove(tmp.size()-1);
        }
    }
}


/////////////////////////////////////////////////////////////
//2015/11/07
// Highlight: use an array to keep track of whether an element is used or not
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rnt = new ArrayList<List<Integer>>();
        ArrayList<Integer> curr =new ArrayList<Integer>();
        
        //keep track of whether an element is used
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        
        int idx = 0;
        dfs(rnt, curr, nums, used, idx);
        
        rnt.add(new ArrayList<Integer>());
        
        return rnt;
    }
    
    public void dfs(List<List<Integer>> rnt, ArrayList<Integer> curr, int[] nums, boolean[] used, int idx){
        if(curr.size()!=0){
            rnt.add(new ArrayList<Integer>(curr));
        }
        if(idx>=nums.length){
            return;
        }
        
        for(int i=idx; i<nums.length; i++){
            if(i>0 && nums[i] == nums[i-1] && used[i-1]==false){
                continue;
            }else{
                curr.add(nums[i]);
                used[i] = true;
                dfs(rnt, curr, nums, used, i+1);
                curr.remove(curr.size()-1);
                used[i] = false;
            }
        }
    }
}
