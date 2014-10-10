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