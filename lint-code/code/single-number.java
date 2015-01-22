public class Solution {
	/**
	 *@param A : an integer array
	 *return : a integer 
	 */
	public int singleNumber(int[] A) {
		
		if(A.length==0) return 0;
		int rnt = A[0];
		
		//XOR: if the same, then 0
		for(int i=1; i<A.length; i++)
		    rnt ^= A[i];
		
		return rnt;
	}
}
