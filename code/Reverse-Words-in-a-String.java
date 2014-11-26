/**
 * Problem Statement
 * Given an input string, reverse the string word by word.
 */
 
public class Solution {
    
    
	public String reverseWords(String s) {
	    
	    //special case
		if (s == null || s.length() == 0) {
			return "";
		}
        
        //split string
		String[] splitS = s.split(" ");
	
	    //reverse string
		String rnt = new String();
		for (int i = splitS.length - 1; i >= 0; --i) {
			if (!splitS[i].equals("")) {
			rnt += splitS[i] + " ";
			}
		}
		
		if(rnt.length()==0) return "";
		//substract last appended " "
		return rnt.substring(0,rnt.length()-1);

	}

    
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2, 11/25/2014
//complexity: one pass

public class Solution {
    public String reverseWords(String s) {
        
       if(s==null || s.length() ==0) return s;
       
       String[] items = s.split(" ");
       
       //split by " "
       //scan from tail to front
       //use StringBuilder to maintain
       StringBuilder sb = new StringBuilder();
       for(int i=items.length-1; i>=0; i--){
           if(!items[i].equals("")){
               sb.append(items[i]).append(" ");
           }
       }
       
       if(sb.length()==0) return "";
       //skip last " "
       else return sb.substring(0, sb.length()-1);
       
       }
}
