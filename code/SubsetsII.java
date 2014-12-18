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
