Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

///////////////////////////////////////////////
// 2015/12/07
// Highlight: dfs
// Time: C(9,K) ?

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> rnt = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        int idx = 0;
        int sum = 0;
        dfs(rnt, curr,  k, n, idx, sum);
        return rnt;
    }
    
    public void dfs(List<List<Integer>> rnt, List<Integer> curr,  int k, int n, int idx, int sum){
        //terminate cases
        if(sum==n && k==0){
            rnt.add(new ArrayList<Integer>(curr));
            return;
        }
        if(sum>=n || k<=0 || idx>=9) return;
        
        //add current
        curr.add(idx+1);
        dfs(rnt, curr,  k-1, n, idx+1, sum+idx+1);
        curr.remove(curr.size()-1);
        
        //skip current
        dfs(rnt, curr, k, n, idx+1, sum);
    }
}
