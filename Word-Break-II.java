/**
 * Problem Statement: Word Break II 
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word
 * Return all such possible sentences.
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 */
 
 /**
  * Reference
  * http://www.myexception.cn/program/1608942.html
  */


public class Solution {
    
    public List<String> wordBreak(String s, Set<String> dict) {
        
        ArrayList<String> res = new ArrayList<String>();
        if(s.length()==0) return res;
        
        bruteForce(s,dict,0,"",res);
        
        return res;
    }
    
	//enumerate all substring that contained by dict
    public void bruteForce(String s, Set<String> dict, int start, String item, ArrayList<String> res){
        
        if(start >= s.length()){
            res.add(item);
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=start; i<s.length(); i++){
            
            sb.append(s.charAt(i));
            if(dict.contains(sb.toString())){
                String newItem = item.length()>0 ? item+sb.toString():sb.toString();
                bruteForce(s,dict,i+1,newItem,res);
            }
        }
            
    }
}