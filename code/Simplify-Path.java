/**
 * Problem Statement: Simplify Path
 * Link: https://oj.leetcode.com/problems/simplify-path/
 * Time: 428 ms
 * Ref: http://fisherlei.blogspot.com/2013/01/leetcode-simplify-path.html
 * 
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 */

public class Solution {
    public String simplifyPath(String path) {

        
        Stack<String> stk = new Stack<String>();
        
        int i = 0;
        while(i < path.length()){
            
            //find first non '/' index
            //note: should put path.length() first in the while condition! Otherwise, index out of boundary
            while(i<path.length() && path.charAt(i) == '/') i++;
            //not found
            if(i == path.length()) break;
            int start = i;
            //find first '/' index after first non '/'
            while(i<path.length() && path.charAt(i) != '/') i++;
            int end = i;
            //get contents betweeen first non '/' and first '/'
            String str = path.substring(start, end);
            //process
            if(str.equals(".")) continue;
            if(str.equals("..")){
                if(!stk.isEmpty())
                    stk.pop();
            }
            else stk.push(str);
        }
        
        //construct path from stack
        if(stk.isEmpty()) return "/";
        String simPath = new String();
        for(i=0; i<stk.size(); i++){
            simPath += "/"+ stk.get(i);
        }
        
        return simPath;
        
        
    }
}