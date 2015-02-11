public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if(L.length==0) return 0;
        int len = 1;
        int maxLen = 0;
        
        for(int i=0; i<L.length; i++){
            if(L[i] > maxLen) maxLen = L[i];
        }
        int step = (int)Math.log(maxLen);
        
        while(true){
            // if(len>maxLen-step){
            //     len = maxLen;
            //     break;
            // } 
            if(canCut(L,k,len)){
                len += step;
            }else break;
            
        }
        
        for(int i = len-step+1; i<=len; i++){
            if(!canCut(L,k,i)) return i-1;
        }
        
        return len;
    }
    
    public boolean canCut(int[] L, int k, int len){
        int rnt = 0;
        for(int i=0; i<L.length; i++){
            rnt += (L[i]/len);
            if(rnt>=k) return true;
        }
        
        return false;
    }
}
