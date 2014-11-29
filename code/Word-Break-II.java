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


/////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 11/29/2014

/**
 * Reference: https://stupidcodergoodluck.wordpress.com/2013/11/16/leetcode-word-break-ii/
 * 
 */

public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        
        ArrayList<String> rnt = new ArrayList<String>();
        
        //use dynamic programming to decide whether the string can is breakable or not
        
        //denote f[0..n] to represent whether f[0..n] can achieve wordbreak
        boolean[] f = new boolean[s.length()+1];
        f[0] = true;
        for(int i=1; i<=s.length(); i++){
            String currWord = s.substring(0,i);
            if(dict.contains(currWord)){
                f[i] = true;
                continue;
            }else{
                for(int j=0; j<i; j++){
                    String word = s.substring(j,i);
                    if(f[j] && dict.contains(word)){
                        f[i] = true;
                        break;
                    }
                }
            }
        }
        
        //cannot break
        if(!f[s.length()]) return rnt;
        
        //dfs 
        dfs(s, dict, 0, "", rnt);
        
        return rnt;
    }
    
    
    //dfs find all string
    public void dfs(String s, Set<String> dict, int start, String tmp, ArrayList<String> rnt){
        
        if(start>= s.length()){
            rnt.add(tmp);
            return;
        }
        
        for(int i=start+1; i<=s.length(); i++){
            String word = s.substring(start, i);
            if(dict.contains(word)){
                String newtmp = tmp.length()==0? word:tmp + " "+word;
                dfs(s, dict, i, newtmp, rnt);
            }
        }
    }
}
