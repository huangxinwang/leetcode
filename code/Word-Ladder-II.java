/**
 * Problem Statement: Word Ladder II 
 * Link: https://oj.leetcode.com/problems/word-ladder-ii/
 * Hardness: *****
 * 
 * State: exceed time limit
 * 
 */


public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, Set<String> dict) {
        
        int min = 0;
        int max = 10;
        
        while(min<=max){
            ArrayList<ArrayList<String>> answer = new ArrayList<ArrayList<String>>();
            ArrayList<String> currList = new ArrayList<String>();
            currList.add(start);
            Set<String> traversed = new HashSet<String>();
            traversed.add(start);
            int mid = (min+max)/2;
            dfs(start, end, dict, mid, currList, answer, traversed);
            if(min==max) return answer;
            
            if(answer.size()>0) {
                max = mid;
                if(min==mid) return answer;
            }
            else min = mid+1;
            
        }

        return new ArrayList<ArrayList<String>>();
    }
    
    //DFS
    public void dfs(String curr, String end, Set<String> dict, int depth, ArrayList<String> currList,ArrayList<ArrayList<String>> answer,Set<String> traversed){
        
        if(depth<=0) {
        
            if(curr.equals(end)){
                ArrayList<String> cloneList = new ArrayList<String>(currList);
                //cloneList.add(end);
                answer.add(cloneList);
                
            }
            
            return;
        
        }
        
        for(int i=0; i<curr.length(); i++){
            for(int j=0; j<26; j++){
                
                char[] newWordArray = curr.toCharArray();
                newWordArray[i] = (char)('a'+j);
                String newWord = String.valueOf(newWordArray);
               
                if(dict.contains(newWord) && !newWord.equals(curr) && !traversed.contains(newWord)){
                    currList.add(newWord);
                    traversed.add(newWord);
                    dfs(newWord, end, dict, depth-1, currList, answer,traversed );
                    currList.remove(currList.size()-1);
                    traversed.remove(newWord);
                }
            }
        }
        
    }
}