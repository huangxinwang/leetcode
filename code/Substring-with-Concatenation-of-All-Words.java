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


////////////////////////////////////////////////////////////////////////////
//Round 2： 1/1/2015
public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        
        ArrayList<Integer> rnt = new ArrayList<Integer>();
        
        //create dict for L
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for(int i=0; i<L.length; i++){
            if(dict.containsKey(L[i]))
                dict.put(L[i], dict.get(L[i])+1);
            else
                dict.put(L[i],1);
        }
        
        int wordLen = L[0].length();
        
        //for each possible start of string S
        for(int i=0; i<wordLen; i++){
            
            HashMap<String, Integer> currDict = new HashMap<String, Integer>();
            int count = 0;
            int start = i;
            
            //check each word, in step of wordLen
            for(int j=i; j<=S.length()-wordLen; j+=wordLen){
                String word = S.substring(j, j+wordLen);
                
                //reset the strat, dict, count
                if(!dict.containsKey(word)){
                    currDict.clear();
                    count = 0;
                    start = j+ wordLen;
                }
                else{
                    //add word to currDict
                    if(currDict.containsKey(word))
                        currDict.put(word, currDict.get(word)+1);
                    else
                        currDict.put(word,1);
                    count++;
                    
                    //current window is not valid, advance the front of the window
                    while(currDict.get(word) > dict.get(word)){
                        String headWord = S.substring(start, start+wordLen);
                        currDict.put(headWord, currDict.get(headWord)-1);
                        start+=wordLen;
                        count--;
                    }
                    
                    //curr window is valid, advance the front of the window
                    if(count==L.length){
                        rnt.add(start);
                        String headWord = S.substring(start, start+wordLen);
                        currDict.put(headWord, currDict.get(headWord)-1);
                        count--;
                        start += wordLen;
                    }
                }
            }
        }
        
        return rnt;
    }
}


//////////////////////////////////////////////////////////////////////////////
// 2015/10/31
// Highlight: hashmap, keep track of current window
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> rnt = new ArrayList<Integer>();
        int len = words[0].length();
        
        
        // Hashmap for words 
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for(String word: words){
            if(dict.containsKey(word)){
                dict.put(word, dict.get(word)+1);
            }else{
                dict.put(word, 1);
            }
        }
        
        // There are # len ways to start the string
        for(int i=0; i<len; i++){
            int count = 0;
            int start = i;
            HashMap<String, Integer> currMap = new HashMap<String, Integer>();
            
            //traverse the string
            for(int j=i; j<=s.length()-len; j+=len){
                String currword = s.substring(j, j+len);
                
                //use hashmap to keep track of current word count in current window
                if(dict.containsKey(currword)){
                    if(currMap.containsKey(currword)){
                        int val = currMap.get(currword);
                        if(val==dict.get(currword)){
                            while(true){
                                String wordHead = s.substring(start, start+len);
                                if(wordHead.equals(currword)){
                                    start += len;
                                    break;
                                }else{
                                    currMap.put(wordHead, currMap.get(wordHead)-1);
                                    count--;
                                    start += len;
                                }
                            }
                        }else{
                            currMap.put(currword, val+1);
                            count++;
                        }
                    }else{
                        currMap.put(currword,1);
                        count++;
                    }
                    
                    // advance head by 1 word
                    if(count == words.length){
                        
                        rnt.add(start);
                        String wordHead = s.substring(start, start+len);
                        currMap.put(wordHead, currMap.get(wordHead)-1);
                        count--;
                        start += len;
                    }
                    
                }else{
                    start = (j+len);
                    currMap.clear();
                    count = 0;
                }
            }
        }
        
        
        return rnt;
    }
}
