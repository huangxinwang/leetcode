class Solution {
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        // write your code here
        return help(0, numbers.size()-1, k, numbers);
        
    }
    
    public int help(int l, int r, int k, ArrayList<Integer> numbers){
    	
    
    	
        if(l==r) {
        	
        	return numbers.get(l);
        }
        
        int initl = l;
        int initr = r;
        int count = r;

        int mid = l+(r-l)/2;
        
        int pivot = numbers.get(mid);
       
        
        while(l<=r){
            while(l<initr && numbers.get(l) < pivot)
                l++;
            while(r>initl && numbers.get(r) > pivot)
                r--;
            if(l<=r){
                int tmp = numbers.get(l);
                numbers.set(l, numbers.get(r));
                numbers.set(r, tmp);
                l++;
                r--;
            }

        }
        
        
        //l will be right after pivot
        count = initr-l+1;
        
       
    
        if(count>=k) return help(l, initr, k, numbers);
        else return help(initl, l-1, k-count, numbers);
    }
};
