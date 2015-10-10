/**
 * Problem Statement:ZigZag Conversion
 * Link: https://oj.leetcode.com/problems/zigzag-conversion/
 * Ref: https://github.com/kweilin123/Leetcode/blob/master/Q%26A/java/ZigZag_Conversion.java
 * Hardness: ***
 * 
 * 
 */


public class Solution {
    public String convert(String s, int nRows) {
        
        int len = s.length();
        
        //initialize string buffer to store string in each line
        StringBuffer[] sb = new StringBuffer[nRows];
        for(int i=0; i<sb.length; i++){
            sb[i] = new StringBuffer();
        }
        
        int idx = 0;
        //travese the string s, and put the char to each line buffer
        while(idx <len){
            //down
            for(int i=0; i<nRows; i++){
                if(idx < len){
                    sb[i].append(s.charAt(idx));
                    idx++;
                }
                else break;
            }
            
            //up
            for(int i = nRows-2; i>=1; i--){
                if(idx < len){
                    sb[i].append(s.charAt(idx));
                    idx++;
                }
                else break;
            }
        }
        
        
        //cancate the output in each line
        for(int i=1; i<sb.length; i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}


////////////////////////////////////////////////////////////////
//Round 2: 12/27/2014
public class Solution {
    public String convert(String s, int nRows) {
        
        //create n String in Arraylist represent nRows
        ArrayList<String> rnt = new ArrayList<String>();
        for(int i=0; i<nRows; i++)
            rnt.add(new String());
        boolean incr = true;
        
        //put s in these n Strings in the array
        int index = 0;
        for(int i=0; i<s.length(); i++){
            rnt.set(index,rnt.get(index) + s.substring(i,i+1));
            if(incr) index++;
            else index--;
            if(index==nRows){
                //careful with the edge condition
                index = Math.max(0,nRows-2);
                incr = false;
            }
            if(index==-1){
                //careful with the edge condition, nrows may be 1
                index = Math.min(1, nRows-1);
                incr = true;
            }
        }
        
        //concate String in the arrayList
        String rntstr = new String();
        for(int i=0; i<nRows; i++){
            rntstr += rnt.get(i);
        }
        
        return rntstr;
    }
}


//////////////////////////////////////////////////////////////////////////
// 10/09/2015
// Highlight: deal with change of current row
public class Solution {
    public String convert(String s, int numRows) {
        int row = 0;
        String[] strs = new String[numRows];
        int idx = 0;
        boolean down = true;
        
        if(numRows==1) return s;
        
        while(idx<s.length()){
            if(strs[row]==null) strs[row] = new String();
            strs[row] = strs[row] + s.charAt(idx);
            if(down) row++;
            else row--;
            if(row==numRows){
                row = row-2;
                down = false;
            }
            if(row==-1){
                row = row+2;
                down = true;
            }
            idx++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs.length; i++){
            if(strs[i]!=null)
                sb.append(strs[i]);
        }
        return sb.toString();
    }
}
