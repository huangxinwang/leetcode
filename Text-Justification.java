/**
 * Problem Statement: Text Justification 
 * Link: https://oj.leetcode.com/problems/text-justification/
 * Time: 500 ms
 * Hardness: ***, many details
 * 
 * Given an array of words and a length L,
 * format the text such that each line has exactly L characters and is fully (left and right) justified.
 * 
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * 
 * 
 */


public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        
        
        ArrayList<String> rnt = new ArrayList<String>();
        
        //special case
        if(words.length==0) return rnt;
        if(words[0].length()==0){
            String tmp = createSpace(L);
            rnt.add(tmp);
            return rnt;
        }
        
        //indicate the start and end of current line
        int start = 0;
        int i=0;
       
        //iterate over the String array, process when one line is ready 
        while(i<words.length){
            
            //find current line
            int currLen = 0;
            while(currLen<L && i<words.length){
                if(currLen!=0) currLen++;
                currLen += words[i].length();
                i++;
            }
            
            if(currLen > L){
                currLen = currLen - 1 - words[i-1].length();
                i--;
            }
            
            int count = i-start;
            
            //construct space array
            int[] space = new int[count-1]; 
            int wordLen = currLen - count + 1;
            
            if(count!=1){
                for(int m=0; m<count-1; m++){
                    space[m] = (L-wordLen)/(count-1);
                }
                int remainLen = L - wordLen -(L-wordLen)/(count-1)*(count-1);
                int index = 0;
                while(remainLen>0){
                    space[index]++;
                    index++;
                    remainLen--;
                }
            }
            
            //for the last line, space is 1
            if(i==words.length){
                for(int k=0; k<count-1; k++){
                    space[k] = 1;
                }
            }

            //construct string
            String tmp = new String();
           
            for(int idx = start; idx<i; idx++){
               
                tmp += words[idx];
                if(idx!=i-1 || count==1){
                    int currSpace = count==1 ? L - currLen: space[idx-start];
                    int j = 0;
                    tmp += createSpace(currSpace);
                }
            }
            
            //for the last line, append extraspace since it uses left justify
            if(i==words.length && count!=1){
               
                int extraSpace = L - currLen;
                tmp += createSpace(extraSpace);
                
            }
         
            rnt.add(tmp);
             
            //update the start of next line
            start = i;
            
        }
        
        return rnt;
    }
    
    
    public String createSpace(int n){
        String rnt = new String();
        for(int i=0; i<n; i++)
            rnt += ' ';
        return rnt;
    }
}