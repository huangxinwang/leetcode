// maximum product of word length

/////////////////////////////////////////////////
// 2015/12/17

// Ref: http://www.jianshu.com/p/bb84b0f866c9
// Highlight: bit operation

public class Solution {
    public int maxProduct(String[] words) {
        int[] processing = new int[words.length];
        int rnt = 0;
        
        //processing[i] is a integer, the lower 26 bits represent whether each char from a-z appears
        for(int i=0; i<words.length; i++){
            String curr = words[i];
            for(int j=0; j<curr.length(); j++){
                char c = curr.charAt(j);
                processing[i] |= (1<< (int)(c-'a'));
            }
        }
        
        for(int i=0; i<processing.length; i++){
            for(int j=i+1; j<processing.length; j++){
                //if & is 0, that means two words does not contains any same char
                if((processing[i] & processing[j])==0)
                    rnt = Math.max(words[i].length()*words[j].length(), rnt);
            }
        }
        
        return rnt;
    }
}
