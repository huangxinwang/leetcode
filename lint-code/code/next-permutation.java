public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's next permuation
     */
    public ArrayList<Integer> nextPermuation(ArrayList<Integer> nums) {
		// write your code
		int idx = nums.size()-1;
		
		//from end to front, find the first decreasing neighbor
		for(; idx>=0; idx--){
		    if(idx!=0 && nums.get(idx) > nums.get(idx-1))
		        break;
		}
	
	    //Case 1: no such decreasing neighbours
		if(idx<=0){
		    Collections.sort(nums);
		    return nums;
		}else{
		    //from end to front, find the first number that larger than the number to be swapped
		    idx--;
		    int swapidx = nums.size()-1;
		    for(; swapidx > idx; swapidx--){
		        if(nums.get(swapidx) > nums.get(idx))
		            break;
		    }
		    
		    //swap the number
		    int tmp = nums.get(idx);
		    nums.set(idx, nums.get(swapidx));
		    nums.set(swapidx, tmp);
		    
		    //reverse from the swap number to end
		    for(int i=idx+1; i<=(nums.size()+idx)/2; i++){
		        int tmpnum = nums.get(i);
		        int curridx = nums.size()+idx-i;
		        nums.set(i, nums.get(curridx));
		        nums.set(curridx, tmpnum);
		    }
		}
		
		return nums;
    }
}
