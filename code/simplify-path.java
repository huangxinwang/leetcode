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

/////////////////////////////////////
// 2015/11/29
// Highlight: use a stack to maintain the elements between each two "/".
public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        
        int idx = 0;
        while(idx<path.length()){
            
            //find first not "/"
            while( idx<path.length() && path.charAt(idx)=='/'){
                idx++;
            }
            
            //not found
            if(idx >= path.length()) break;
            
            int start = idx;
            
            // find  "/"
            while( idx<path.length() && path.charAt(idx)!='/' ){
                idx++;
            }
            int end = idx;
            String str = path.substring(start,end);
            
            if(str.equals(".")) continue;
            if(str.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }
            else stack.push(str);
        }
        
        //constitute the path from elements in stack
        String rnt = new String();
        for(String s: stack){
            rnt += "/"+s;
        }
        if(rnt.length()==0) return "/";
        else return rnt;
    }
}
