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


///////////////////////////////////////////////////////////////////////////
//Round 2: 12/24/2014
public class Solution {
    public String simplifyPath(String path) {
        
        int start = 0;
        Stack<String> stk = new Stack<String>();
        
        while(start<path.length()){
            
            //find first non "/", index as start
            while(start <path.length() && path.charAt(start) == '/')
                start++;
            //not found
            if(start==path.length()) break;
            //find first "/" from start, index as end
            int end = start;
            while(end< path.length() && path.charAt(end)!='/')
                end++;

            //process string between start and end
            String str = path.substring(start,end);
            //case 1
            if(str.equals("..")){
                if(!stk.isEmpty())
                    stk.pop(); 
            } 
            //case 2
            else if(!str.equals(".")) stk.push(str);
            //update
            start = end+1;
        }
        
        //output
        if(stk.isEmpty()) return "/";
        String rnt = "";
        for(int i=0; i<stk.size(); i++){
            rnt = rnt + "/" + stk.get(i);
        }
        
        return rnt;
        
    }
}


//////////////////////////////////////////////
// 2015/11/07
// Highlight: find string between two successive "/"
public class Solution {
    public String simplifyPath(String path) {
        int start = 0;
        Stack<String> stack = new Stack<String>();
        
        int idx = 0;
        while(idx<path.length()){
            
            //find first "/"
            while(idx<path.length() && path.charAt(idx)=='/')
                idx++;
            
            if(idx==path.length()) break;
            
            start = idx;
            
            
            //find second "/"
            while(idx<path.length() && path.charAt(idx)!='/')
                idx++;
                
            int end = idx;
            String str = path.substring(start,end);
            
            //if string between the first and second "/" is ".", continue
            if(str.equals(".")) continue;
            
            //else
            if(str.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }else {
                stack.push(str);
            }
        }
        
        String rnt = new String();
        for(int i=0; i<stack.size(); i++){
            rnt += "/" + stack.get(i);
        }
        
        if(rnt.length()==0) return "/";
        
        return rnt;
    }
}
