/**
 * Problem Statement:Palindrome Partitioning 
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return
 * [
 *  ["aa","b"],
 *  ["a","a","b"]
 * ]
 */

/**
 * Reference
 * http://blog.csdn.net/yiding_he/article/details/19058421
 */


public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        
        ArrayList<ArrayList<String>> results = new ArrayList<>();
        ArrayList<String> tmpResult = new ArrayList<>();
        dfs(s,0,tmpResult,results);
        return results;
    }
    
    //use dfs approach to find all possible partition
    public void dfs(String s, int start, ArrayList<String> tmpResult, ArrayList<ArrayList<String>> results){
        
        //one partition of the string
        if(start==s.length()){
            //note: make a new copy as tmpResult only has one copy
            results.add(new ArrayList<String>(tmpResult));
            return;
        }
        
        //dfs
        for(int i=start; i<s.length(); i++){
            String curr = s.substring(start,i+1);
            if(isPalindrome(curr)){
                tmpResult.add(curr);
                dfs(s,i+1,tmpResult,results);
                tmpResult.remove(tmpResult.size()-1);
            }
        }
    }
    
    //judge if a string is palindrome
    public boolean isPalindrome(String curr){
        int start = 0;
        int end = curr.length()-1;
        while(start < end){
            if(curr.charAt(start)!=curr.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}