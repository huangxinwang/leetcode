/**
 * Problem Statement: Letter Combinations of a Phone Number
 * Link: https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Time: 412 ms
 * 
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 */


/////////////////////////////////////////////////////
//2015-10-15
//Highlight: use two sets to alternate adding chars
public class Solution {
    public List<String> letterCombinations(String digits) {
        
        //Use two set to alternate adding chars 
        HashSet<String> rnt = new HashSet<String>();
        
        for(int i=0 ;i<digits.length(); i++){
            char[] array = getChar(digits.charAt(i));
            HashSet<String> newSet = new HashSet<String>();
            for(int j=0; j<array.length; j++){
                for(String currs: rnt){
                    newSet.add(currs+array[j]);
                }
                if(i==0){
                    newSet.add(array[j]+"");
                }
            }
            
            rnt = newSet;
        }
        
        ArrayList<String> rntList = new ArrayList<String>();
        for(String currs: rnt){
            rntList.add(currs);
        }
        return rntList;
    }
    
    public char[] getChar(char c){
        switch(c){
            case '2': return new char[] {'a','b','c'};
            case '3': return new char[]{'d','e','f'};
            case '4': return new char[] {'g', 'h', 'i'};
            case '5': return new char[] {'j','k','l'};
            case '6': return new char[] {'m','n','o'};
            case '7': return new char[] {'p','q','r','s'};
            case '8': return new char[] {'t','u','v'};
            case '9': return new char[] {'w','x','y','z'};
            default: return new char[]{};
        }
    }
}


///////////////////////////////////////////////
// 2015/11/29
// Highlight: dfs
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> rnt = new ArrayList<String>();
        
        //special case
        if(digits==null || digits.length()==0) return rnt;
        
        String[] strs = new String[]{"","","abc","def","hgi","jkl","mno","pqrs","tuv","wxyz"};
        dfs(rnt, digits, strs, "", 0);
        return rnt;
    }
    
    //recursive, each time advance 1
    public void dfs(List<String> rnt, String digits, String[] strs, String curr, int i){
        if(i >= digits.length()){
            rnt.add(curr);
            return;
        }
        
        int num = (int)(digits.charAt(i)-'0');
        for(int j=0; j<strs[num].length(); j++){
            String newcurr = curr + strs[num].charAt(j);
            dfs(rnt, digits, strs, newcurr, i+1);
        }
        if(strs[num].length()==0)
            dfs(rnt, digits, strs, curr, i);
    }
}
