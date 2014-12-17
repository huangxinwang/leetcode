/**
 * Problem Statement: Restore IP Addresses 
 * Link: https://oj.leetcode.com/problems/restore-ip-addresses/
 * 
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
 
 /**
  * Note:
  * avoid str which has (length greater than 1 and start with 0)
  **/

public class Solution {
    
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> rnt = new ArrayList<String>();
        //spciecal condition
        if(s.length()>12) return rnt;
        
        //dfs find satisfiable string
        dfs(0,s,rnt,"");
        return rnt;
    }
    
    //dfs
    public void dfs(int depth, String str, ArrayList<String> rnt, String curr){
        
        //terminate situation
        if(depth==4){
            if(str.length()==0)
                rnt.add(curr);
            return;
        }
        
        if(str.length()==0) return;
        
        //add new string
        for(int i=1; i<=3 && i<=str.length(); i++){
            String newstr = str.substring(0,i);
            //check if new string is valid
            if(newstr.length()>1 && newstr.charAt(0)=='0') continue;
            if(Integer.parseInt(newstr)<=255){
                //create new string to dfs
                String tmp = curr;
                if(tmp!="")
                    tmp += ".";
                tmp += str.substring(0,i);
                dfs(depth+1, str.substring(i,str.length()), rnt, tmp);
            }
        }
    }
}

///////////////////////////////////////////////////////////////////////
//Round 2: 12/17/2014
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        ArrayList<String> rnt = new ArrayList<String>();
        String tmp = new String();
        dfs(0, 4, tmp, rnt, s);
        return rnt;
        
    }
    
    public void dfs(int start, int depth, String tmp, ArrayList<String> rnt, String s){
        
        //terminate cases
        if(start>=s.length()){
            if(depth==0)
                rnt.add(tmp);
            return;
        }
        if(depth <0) return; 
        
        //dfs find all possible solution
        for(int i=start; i<Math.min(s.length(), start+4); i++){
            String curr = s.substring(start,i+1);
            
            if(testValid(curr)){
                String newtmp = tmp.length()==0? curr : tmp+"."+curr;
                dfs(i+1, depth-1, newtmp, rnt, s);
            }
        }
    }
    
    //decide whether a string is valid to be one part of IP addresss
    public boolean testValid(String s){
        int val = Integer.parseInt(s);
        if(val >255) return false;
        if(val!=0 && val < Math.pow(10,s.length()-1)) return false;
        if(val==0 && s.length()>1) return false;
        return true;
    }
}
