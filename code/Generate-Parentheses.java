/**
 * Problem Statement: Generate Parentheses
 * Link: https://oj.leetcode.com/problems/generate-parentheses/
 * Time: 372ms
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 */


//////////////////////////////////////////////////
// 2015/12/07
// Highlight: dfs

public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        int left = 0;
        int right = 0;
        String curr = new String();
        ArrayList<String> rnt = new ArrayList<String>();
        dfs(rnt, curr, left, right,n);
        return rnt;
    }
    
    public void dfs(ArrayList<String> rnt, String curr, int left, int right, int n){
        if(curr.length()==n*2){
            rnt.add(curr);
            return;
        }
        
        //generate left "("
        if(left<n){
            dfs(rnt, curr+"(", left+1, right, n);
        }
        
        //genegrate right ")"
        if(right<left){
            dfs(rnt, curr+")", left, right+1,n);
        }
    }
}
