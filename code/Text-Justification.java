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


///////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 12/24/2014
public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        
       ArrayList<String> rnt = new ArrayList<String>();
       
       int start = 0;
       int end = start;
       while(start<words.length){
           
           //find the words in a line
           end = start;
           int sum = words[start].length();
           int rawsum = words[start].length();
           
           while(sum<L && start<words.length-1){
               if(end==words.length-1) break;
               end++;
               if(sum + words[end].length()+1<=L){
                   sum++;
                   sum = sum + words[end].length();
                   rawsum = rawsum + words[end].length();
               }
               else{
                   end--;
                   break;
               }
           }
           
           //assign space, space represent the general space between two words, extraspace represents the extra space
           int space = 0;
           int extraspace = 0;
 
           if(end==start) space = L - words[start].length();
           else{
               space = (L-rawsum)/(end-start);
               extraspace = L - rawsum - space*(end-start);
           } 
           
           //in the last line, the space should at most be 1
           if(end==words.length-1){
               space = Math.min(space,1);
               extraspace = 0;
           }
           
           
           //put the words and space in a string, and add to return list
           StringBuffer currstr = new StringBuffer();
           
           int index = 0;
           for(int i=start; i<=end; i++){
               for(int j=0; j<words[i].length(); j++){
                   currstr.append(words[i].charAt(j));
               }
               
               if(i==start || i!=end){
                   for(int k=0; k<space; k++){
                        currstr.append(' ');
                       
                   }
                   if(extraspace > 0){
                            currstr.append(' ');
                            extraspace--;
                   }
               }
           }
           
           while(currstr.length() < L){
               currstr.append(' ');
           }
           
           rnt.add(currstr.toString());
           start = end+1;
       }
       
       return rnt;
    }
}


//////////////////////////////////////////////////////////////////
// 2015/11/06
// Highlight: corner case
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> rnt = new ArrayList<String>();
        
        int currspace = 0;
        int lastidx = 0;
        int idx = 0;
        int count = 0;
        int currlen = 0;
        while(idx<words.length){
            
            //reach last words
            if(idx==words.length-1){
                //deal with last string
                String str = new String();
                for(int i=lastidx; i<=idx; i++){
                    str += words[i];
                    if(i!=idx)
                        str += " ";
                }
                while(str.length()<maxWidth){
                    str += " ";
                }
                rnt.add(str);
                
            }
            //not last words
            else{
                if(lastidx!=idx)
                    currspace++;
                count++;
                currlen += words[idx].length();
                
                //reach length
                if(currlen + words[idx+1].length() + currspace>=maxWidth){
                    //array current string
                    rnt.add(getString(words, lastidx, idx, currlen, count, maxWidth));
                    count = 0;
                    currlen = 0;
                    currspace = 0;
                    lastidx = idx+1;
                }
            }
            
            idx++;
        }
        
        return rnt;
    }
    
    //construct a line of string
    public String getString(String[] words, int lastidx, int idx, int currlen, int count, int maxWidth){
        String rnt = new String();
        if(count==1){
            rnt += words[lastidx];
            while(rnt.length()<maxWidth){
                rnt += " ";
            }
            return rnt;
        }
        
        int spaceCount = (maxWidth - currlen)/(count-1);
        int firstspace = maxWidth - currlen - (spaceCount)*(count-1);
        for(int i = lastidx; i<=idx; i++){
            
                rnt += words[i];
                if(i!=idx){
                    for(int j=0; j<spaceCount; j++){
                        rnt += " ";
                    }
                    if(firstspace>0){
                        rnt += " ";
                        firstspace--;
                    }
                }
            }
        
        return rnt;
    }
}
