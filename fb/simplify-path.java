/**
* Problem Statement: Simplify path
*
*/

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
