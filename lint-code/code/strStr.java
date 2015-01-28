class Solution {
    /**
     * Returns a index to the first occurrence of target in source, or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if(source==null || target==null) return  -1;
        if(source.length()==0 && target.length()==0) return 0;
        
        int len = target.length();
        for(int i=0; i<source.length(); i++){
            int j=0;
            for(; j<len; j++){
                if(source.charAt(i+j)!=target.charAt(j))
                    break;
            }
            if(j==len) return i;
        }
        return -1;
    }
}
