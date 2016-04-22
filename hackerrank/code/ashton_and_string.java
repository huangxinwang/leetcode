// Only pass the small test-case
// For large test case, it will time out

https://www.hackerrank.com/challenges/ashton-and-string

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static Set<String> getSubString(String str, Set<String> curr, int d){
        if(d>=str.length()){
            return curr;
        }
        for(int i=d+1; i<=str.length(); i++){
            String substr = str.substring(d, i);
            if(!curr.contains(substr))
                curr.add(substr);
            getSubString(str, curr, i);
        }
        return curr;
    }
    
    
    public static char getKthChar(String str, int k){
       
        Set<String> set = new HashSet<String>();
        getSubString(str, set,0);
        List<String> sortedList = new ArrayList(set);
        Collections.sort(sortedList);
        char c = '0';
        for(int i=0; i<sortedList.size(); i++){
            String curr = sortedList.get(i);
            //System.out.println(i + " th= "+curr);
            if(curr.length()<k)
                k = k - curr.length();
            else{ c = curr.charAt(k-1);
                 break;
                }
        }
        return c;
    }
    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = 
                      new BufferedReader(new InputStreamReader(System.in));
			
		int totalCount = Integer.parseInt(br.readLine());
        for(int i=0; i<totalCount; i++){
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());
            char c = getKthChar(str, k);
            System.out.println(c);
        }
		
    }
}
