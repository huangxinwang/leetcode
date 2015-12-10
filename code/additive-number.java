// Additive number is a string whose digits can form additive sequence.

// A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

// For example:
// "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

// 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
// "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
// 1 + 99 = 100, 99 + 100 = 199
// Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

// Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.


//////////////////////////////////////////////
// 2015/12/09
// Highlight: dfs
// Time: seems exponential, since it enumerate all possible dividings.

public class Solution {
    public boolean isAdditiveNumber(String num) {
        
        //for each possible of first and second value
        for(int i=1; i<num.length()-1; i++){
            for(int j=i+1; j<num.length(); j++){
                String firstStr = num.substring(0,i);
                String secondStr = num.substring(i,j);
                if(firstStr.length()>=2 && firstStr.charAt(0)=='0') continue;
                if(secondStr.length()>=2 && secondStr.charAt(0)=='0') continue;
                long first = Long.parseLong(firstStr);
                long second = Long.parseLong(secondStr);
                if(dfs(num, first, second,j)) return true;
            }
        }
        return false;
    }
    
    //recursively check whether first + second == third
    public boolean dfs(String num, long first, long second, int idx){
        if(idx>=num.length()) return true;
        
        for(int i=idx+1; i<=num.length(); i++){
            if(i!=idx+1 && num.charAt(idx)=='0') continue;
            String curr = num.substring(idx,i);
            long val = Long.parseLong(curr);
            if(first+second==val){
                if(dfs(num, second, val, i)) return true;
            }
        }
        
        return false;
    }
}
