class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int count = 0;
        for(int i=0; i<=n; i++){
            String s = i+"";
            char[] c = s.toCharArray();
            for(int j=0; j<c.length; j++){
                if(c[j]==(char)(k+'0')) count++;
            }
        }
        
        return count;
    }
    
    
};


//////////////////////////////////////////////////
//Approach 2: mode 10
class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int count = 0;
        for(int i=1; i<=n; i++)
            count = count + helpCount(k,i);
        return count;
    }
    
    public int helpCount(int k, int n){
        int count = 0;
        if(n%10==k) count++;
        if(n/10>0)
            count += helpCount(k, n/10);
        return count;
    }
};
