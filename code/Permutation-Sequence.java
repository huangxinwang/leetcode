public class Solution {
    public String getPermutation(int n, int k) {
        
        ArrayList<Integer> candidates = new ArrayList<Integer>();
        for(int i=1; i<=n; i++)
            candidates.add(i);
        //subtract 1 from k, to make index from (0..n-1)
         return getPerm(candidates, k-1);  
       
        
    }
    
    //recursive find the k-th permutation in list
    private String getPerm(ArrayList<Integer> list, int k){
        int n = list.size();
        if(n==1) return list.get(0)+"";
        //get result
        int result = k/ factorial(n-1);
        //get remain
        k = k % factorial(n-1);
        //get element from list, and remove afterwards
        int curr = list.get(result);
        list.remove(result);
        //recursive get the permutation
        return curr + getPerm(list, k);
    }
    
    public int factorial(int n) {
        int fact = 1; // this  will be the result
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}


/////////////////////////////////////////////
// 2015/11/05
// Comment: cool
// Highlight: combination number and factorial!
public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=1; i<=n; i++){
            list.add(i);
        }
        
        return help(list, k-1);
    }
    
    public String help(ArrayList<Integer> list, int k){
        int n = list.size();
        if(n==1) return list.get(0)+"";
        
        int sum = factorial(n-1);
        
        //result corresponding to the number in the list
        //The factorial of (n-1) number indicates the number of combinations of (n-1) numbers
        //Therefore, we can reduce the number of k by mode (factorial of n-1)
        int result = k/sum;
        k = k%sum;
        
        int curr = list.get(result);
        list.remove(result);
        
        return curr + help(list, k);
        
    }
    
    public int factorial(int n){
        if(n==1) return 1;
        int rnt = n;
        return rnt*factorial(n-1);
    }
}
