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


public class Solution {
    public List<String> generateParenthesis(int n) {
        
        int left = 0;
        int right = 0;
        ArrayList<String> rnt = new ArrayList<String>();
        String tmp ="";
        
        dfs(left, right, n, tmp, rnt);
        
        return rnt;
    }
    
    //dfs find all solutions
    public void dfs(int left, int right, int n, String tmp, ArrayList<String> rnt){
        //terminate condition
        if(left+right==n*2){
            rnt.add(tmp);
            return;
        }
        
        //recusive condition
        if(right<left){
            String newTmp = tmp+")";
            dfs(left, right+1, n, newTmp, rnt);
        }
        
        if(left<n){
            String newTmp = tmp+"(";
            dfs(left+1,right, n, newTmp, rnt);
        }
      
    }
}


/////////////////////////////////////////////////////////////////////////////
//Round 2: 1/5/2015
public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        
        ArrayList<String> rnt = new ArrayList<String>();
        int left = 0;
        int right = 0;
        String tmp = new String();
        dfs(left, right, n,rnt, tmp);
        
        return rnt;
    }
    
    public void dfs(int left, int right, int n, ArrayList<String> rnt, String tmp){
        
        if(left+right==2*n)
        {
            rnt.add(tmp);
            return;
        }
        
        //add right
        if(right<left){
            String newTmp = tmp + ")";
            dfs(left, right+1, n, rnt, newTmp);
        }
        
        //add left
        if(left<n)
        {
            String newTmp = tmp + "(";
            dfs(left+1, right, n, rnt, newTmp);
        }
    }
}
