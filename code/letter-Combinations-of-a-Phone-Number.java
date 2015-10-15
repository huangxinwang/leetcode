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

/////////////////////////////////////////////////////////////
//Round 2: 1/1/2015
public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        String[] letters = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int index = 0;
        ArrayList<String> rnt = new ArrayList<String>();
        String tmp = new String();
        dfs(letters, digits, index, tmp, rnt);
        return rnt;
    }
    
    //dfs get all combination
    public void dfs(String[] letters, String digits, int index, String tmp, ArrayList<String> rnt){
        if(index==digits.length()){
            rnt.add(tmp);
            return;
        }
        
        int num = digits.charAt(index) - '0';
        String curr = letters[num];
        //case 1: current length is 0   
        if(curr.length()==0)
            dfs(letters, digits, index+1, tmp, rnt);
        //case 2: not 0, try all combinations
        else{
            for(int i=0; i<curr.length(); i++){
                String newtmp = tmp + curr.charAt(i);
                dfs(letters, digits, index+1, newtmp, rnt);
            }
        }
    }
}


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
