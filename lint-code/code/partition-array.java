public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(ArrayList<Integer> nums, int k) {
	    //write your code here
	    int l = 0;
	    int r = nums.size()-1;
	    
	    while(l <= r){
	        while(l<nums.size()-1 && nums.get(l)<k)
	            l++;
	        while(r>0 && nums.get(r) >=k)
	            r--;
	        if(l<=r){
	            int tmp = nums.get(l);
	            nums.set(l, nums.get(r));
	            nums.set(r, tmp);
	            l++;
	            r--;
	        }
	        
	    }
	    
	    //two special case
	    if(r<0) return 0;
	    if(l>nums.size()-1) return nums.size();
	    
	    //general case
	    return l;
    }
}
