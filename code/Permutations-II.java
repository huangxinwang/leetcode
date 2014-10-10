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