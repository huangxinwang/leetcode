/**
 * Problem Statement:
 * Link: https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
 * Ref: http://www.cnblogs.com/springfor/p/3872516.html
 * Hardness: ****
 * 
 */


public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        
        ArrayList<Integer> rnt = new ArrayList<Integer>();
        //special condition
        if(S.length()==0 || L.length==0) return rnt;
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
       
        //the length of a word
        int wordLen = L[0].length();
        
        //initialize dict
        for(int i=0; i<L.length; i++){
            if(dict.containsKey(L[i])){
                dict.put(L[i], dict.get(L[i])+1);
            }else
                dict.put(L[i],1);
        }
        
        for(int i=0; i<wordLen; i++){
            
            int currLen = 0;
            int currStart = i;
            
            //maintain word count in current sliding window
            HashMap<String, Integer> currDict = new HashMap<String, Integer>();
             
            //j represents the wordIndex in the tail of window
            for(int j=currStart; j<=S.length()-wordLen; j+=wordLen){
                
                String currWord = S.substring(j, j+wordLen);
                
                //currWord is not in the dict
                //shift the start of the window to next word
                if(!dict.containsKey(currWord)){
                    currStart = j+wordLen;
                    currDict.clear();
                    currLen = 0;
                }else{
                    
                    //update current dict
                    if(currDict.containsKey(currWord)){
                        currDict.put(currWord, currDict.get(currWord)+1);
                      
                    }
                    else{
                        currDict.put(currWord, 1);
                        
                    }
                    currLen++;
                    
                    //current window contains more currWord than dict
                    //shift the window right one word at one time until above condition breaks
                    while(currDict.get(currWord) > dict.get(currWord)){
                            String headWord = S.substring(currStart, currStart+wordLen);
                            currDict.put(headWord, currDict.get(headWord)-1);
                            currLen--;
                            currStart+=wordLen;
                    }
                    
                    //current window satisfy condition
                    //add to results and shift the window right by one word
                    if(currLen == L.length){
                        rnt.add(currStart);
                        String headWord = S.substring(currStart, currStart+wordLen);
                        currDict.put(headWord, currDict.get(headWord)-1);
                        currLen--;
                        currStart+=wordLen;
                        //currStart = currStart+wordLen;
                        
                        //currDict.clear();
                        //currLen = 0;
                    }
                }
 
            }//for j
            
        }//for a
        
        return rnt;
        
    }
}