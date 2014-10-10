/**
 * Problem Statement: Letter Combinations of a Phone Number
 * Link: https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Time: 412 ms
 * 
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 */


public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        
        ArrayList<String> rnt = new ArrayList<String>();
        
        //special case
        if(digits.length()==0){
            rnt.add("");
            return rnt;
        } 
        
        String tmp = new String();
        dfs(digits, 0, tmp, rnt);
        return rnt;
    }
    
    public void dfs(String digits, int start, String tmp, ArrayList<String> rnt){
        
        if(start==digits.length()){
            rnt.add(tmp);
            return;
        }
        
        //initialize string array
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        //dfs insert each possible letter at the i-th digits
        char curr = digits.charAt(start);
        int index = curr-'0';
        for(int i=0; i<letters[index].length(); i++){
            dfs(digits, start+1, tmp+letters[index].charAt(i), rnt);
        }
    }
}