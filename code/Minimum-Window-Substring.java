/**
 * Problem Statement: Minimum Window Substring
 * Link: https://oj.leetcode.com/problems/minimum-window-substring/
 * Time:  524 ms
 * Ref: http://blog.csdn.net/linhuanmars/article/details/20343903, http://huntfor.iteye.com/blog/2083485
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 */




public class Solution {
    public String minWindow(String S, String T) {
        
        //put each chracter and its count in T to HashMap
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<T.length(); i++){
            char c = T.charAt(i);
            if(map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c,1);
        }
        
		//start and i are "pre" and "end" pointer of the string S
		int start = 0,i= 0;
		//found is total number of chracter in current window
		int found = 0;
		//record return string and its length
		int minLength = 1 + S.length();
		String res = "";
		
		
		for(start = i = 0; i < S.length(); i++){
		    //update HashMap to deduct remain count of matched charcter
		    char c = S.charAt(i);
		    if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
				if(map.get(c)>=0) found++;
                //current window contains all chracters in T
				if(found == T.length()){
				    //advance "pre" poiter of the window to escape these two cases
				    //1. current char is not in T
				    //2. current char is in T, but it is not neccessary, i.e., current window has enough count of this char
					while(start < i){
					    char a = S.charAt(start);
					    if(!map.containsKey(a) || map.containsKey(a) && map.get(a)<=-1){
					        if(map.containsKey(a)) map.put(a, map.get(a)+1);
							start++;
						}else {
							break;
						}
					}
					
					//update minmum string
					if(i - start + 1< minLength){
						minLength = i - start + 1;
						res = S.substring(start,i+1);
					}
					//advance pointer so that current window is not a valid sub-string window
					if(map.containsKey(S.charAt(start))) map.put(S.charAt(start), map.get(S.charAt(start))+1);
					found--;
					start++;
				}
			}
		}
		return res;
	}
}


///////////////////////////////////////////////////////////////////////
//Round 2: 12/21/2014
public class Solution {
    public String minWindow(String S, String T) {
        
        //initialize hash map to count characeters appear in String T
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<T.length(); i++){
            char c = T.charAt(i);
            if(map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c,1);
        }
        
        //i and start are the pre and end pointer of current window in String s respectively
        int i = 0; int start = 0;
        int found = 0; //record the valid characters in current window
        int min = S.length();
        String rnt = "";
        
        for(i=0; i<S.length(); i++){
            char curr = S.charAt(i);
            if(map.containsKey(curr)){
                map.put(curr, map.get(curr)-1);
                if(map.get(curr)>=0) found++;
                
                //evict invalid or excessive character out of the window in order
                if(found == T.length()){
                    while(start<=i){
                        char s = S.charAt(start);
                        if(!map.containsKey(s) || map.containsKey(s) && map.get(s)<0)
                            start++;
                        else break;
                    }
                    
                    if(min > i-start+1){
                        min = i-start+1;
                        rnt = S.substring(start, i+1);
                    }

                    
                    if(map.containsKey(S.charAt(start))){
                        map.put(S.charAt(start), map.get(S.charAt(start)+1));
                        found--;
                        start++;
                    }
                }
            }
        }
        
        return rnt;
    }
}
